package com.kun.controllers;

import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MenuController {

    @Autowired
    CredentialRepository credentialRepository;

    @RequestMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping("/about")
    public ModelAndView getAbout() {
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }

    @RequestMapping("/profile")
    public ModelAndView getProfile(Principal principal) {
        ModelAndView mav = new ModelAndView("profile");
        Credential user = credentialRepository.findByUsername(principal.getName());
        if (user != null) {
            mav.addObject("user", user);
        }
        return mav;
    }

    @RequestMapping("/addparking")
    public ModelAndView getAddParkingForm() {
        ModelAndView mav = new ModelAndView("addparking");
        mav.addObject("parkingFormObj", new Parking());
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

    @RequestMapping(value = "addParkingAction", method = RequestMethod.POST)
    public ModelAndView doAddParkingForm(@ModelAttribute("parkingFormObj") Parking parking, BindingResult br) {

        ModelAndView mav = null;

        return mav;
    }

}
