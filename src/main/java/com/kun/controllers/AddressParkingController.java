package com.kun.controllers;

import com.kun.models.Address;
import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.repositories.CredentialRepository;
import com.kun.repositories.UserRepository;
import com.kun.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Controller
public class AddressParkingController {

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
            mav = new ModelAndView("addparking");
            mav.addObject("message", "Something went wrong");
        } else {

            Address newAddress = parking.getAddress();

            Credential currentCred = credentialRepository.findByUsername(principal.getName());
            currentCred.getUser().getAddresses().add(newAddress);

            Parking newparking = parking;

            newparking.setAddress(newAddress);
            newAddress.getParking().add(newparking);

            addressService.save(newAddress);
            userRepository.save(currentCred.getUser());

            Set<Address> addresses = addressService.getAllAddresses();

            mav = new ModelAndView("home");
            mav.addObject("message", "Successfully added the parking");

            mav.addObject("addresses", addresses);
        }
        return mav;
    }

    @RequestMapping(value = "/parkingdetails", method = RequestMethod.GET)
    public ModelAndView getParkingDetails(@RequestParam("aid") int id) {

        ModelAndView mav = new ModelAndView("parkingdetails");

        Address address = addressService.getAddressById(id);

        mav.addObject("address", address);
        mav.addObject("parkings", address.getParking());

//        mav.addObject("reserveFormObj", new Reserve());
        return mav;
    }

}
