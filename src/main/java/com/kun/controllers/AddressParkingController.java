package com.kun.controllers;

import com.kun.models.Address;
import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.repositories.AddressRepository;
import com.kun.repositories.CredentialRepository;
import com.kun.repositories.ParkingRepository;
import com.kun.repositories.UserRepository;
import com.kun.services.AddressService;
import com.kun.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AddressParkingController {

    @Autowired
    ParkingService parkingService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @RequestMapping(value = "/addparking", method = RequestMethod.GET)
    public ModelAndView getAddParkingForm() {
        ModelAndView mav = new ModelAndView("addparking");
        mav.addObject("addressFormObj", new Address());
        mav.addObject("parkingFormObj", new Parking());
        return mav;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, "availableDate", new CustomDateEditor(simpleDateFormat, false));
        webDataBinder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(simpleDateFormat, false));
    }

    @RequestMapping(value = "/addressParkingAction", method = RequestMethod.POST)
    public ModelAndView addParkingObj(@Valid @ModelAttribute("parkingFormObj") Parking parking, BindingResult brp,
                                      Principal principal) {

        ModelAndView mav = null;

        if (brp.hasErrors()) {
            mav = new ModelAndView("redirect:/addparking");
            mav.addObject("message", "Something went wrong");
        } else {
            System.out.println("trying to create parking");
            Address newAddress = parking.getAddress();

            Credential currentCred = credentialRepository.findByUsername(principal.getName());
            currentCred.getUser().getAddresses().add(newAddress);
            //newAddress.setUser(currentCred.getUser());

            Parking newparking = parking;

            newparking.setAddress(newAddress);
            newAddress.getParking().add(newparking);

            addressService.save(newAddress);
            userRepository.save(currentCred.getUser());

            Set<Parking> parkings = parkingService.getAllParkings();
            Set<Address> addresses = new HashSet<Address>();
            parkings.forEach(p -> addresses.add(p.getAddress()));

//            parkings.forEach(p -> addressService.getAddressById(p.getAddress().getAID()));

            mav = new ModelAndView("home");
            mav.addObject("message", "Successfully added the parking");
            mav.addObject("parkings", parkings);
            mav.addObject("addresses", addresses);
        }
        return mav;
    }

    @RequestMapping(value = "/parkingdetails")
    public ModelAndView getParkingDetails() {

        ModelAndView mav = new ModelAndView("parkingdetails");

        return mav;
    }
}
