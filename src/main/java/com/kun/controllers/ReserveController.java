package com.kun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReserveController {

    @RequestMapping(value = "/reserveParkingAction", method = RequestMethod.POST)
    public ModelAndView reserveParkingForm() {

        ModelAndView mav = new ModelAndView("reserveform");

        return mav;
    }
}
