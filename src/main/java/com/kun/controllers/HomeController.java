package com.kun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mav = new ModelAndView("home");
        System.out.println("I am here*****");
        return mav;
    }

}
