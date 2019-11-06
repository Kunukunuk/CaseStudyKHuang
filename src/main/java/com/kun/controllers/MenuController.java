package com.kun.controllers;

import com.kun.models.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

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
    public ModelAndView getProfile() {
        ModelAndView mav = new ModelAndView("profile");
        return mav;
    }

    @RequestMapping("/addparking")
    public ModelAndView getAddParkingForm() {
        ModelAndView mav = new ModelAndView("addparking");
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
