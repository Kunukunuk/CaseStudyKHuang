package com.kun.controllers;

import com.kun.models.Address;
import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.models.User;
import com.kun.repositories.CredentialRepository;
import com.kun.repositories.ParkingRepository;
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

@Controller
public class AddressParkingController {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @RequestMapping(value = "/addparking", method = RequestMethod.GET)
    public ModelAndView getAddParkingForm() {
        ModelAndView mav = new ModelAndView("addparking");
        System.out.println("going into this");
        mav.addObject("addressFormObj", new Address());
        mav.addObject("parkingFormObj", new Parking());
        System.out.println("going into that");
        return mav;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, "availableDate", new CustomDateEditor(simpleDateFormat, false));
        webDataBinder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(simpleDateFormat, false));
    }

    @RequestMapping(value = "/addressParkingAction", method = RequestMethod.POST)
    public ModelAndView addParkingObj(@ModelAttribute("parkingFormObj") Parking parking, BindingResult brp,
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

            Parking newparking = parking;

            newparking.setAddress(newAddress);
            newAddress.getParking().add(newparking);

            parkingRepository.save(newparking);

            mav = new ModelAndView("home");
            mav.addObject("message", "Successfully added the parking");
        }
        return mav;
    }
}
