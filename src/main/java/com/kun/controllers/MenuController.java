package com.kun.controllers;

import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.repositories.CredentialRepository;
import com.kun.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Set;

@Controller
public class MenuController {

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    ParkingRepository parkingRepository;

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView getHome() {
        ModelAndView mav = new ModelAndView("home");
        Set<Parking> parkings = parkingRepository.findAll();
        mav.addObject("parkings", parkings);
        return mav;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView getAbout() {
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfile(Principal principal) {
        ModelAndView mav = new ModelAndView("profile");
        Credential user = credentialRepository.findByUsername(principal.getName());
        if (user != null) {
            mav.addObject("user", user);
        }
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterForm() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("userRegistrationObj", new Credential());
        return mav;
    }

}
