package com.kun.controllers;

import com.kun.models.Reserve;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReserveController {

    @RequestMapping(value = "/reserveform", method = RequestMethod.GET)
    public ModelAndView getReserveForm() {

        ModelAndView mav = new ModelAndView("reserveform");
        mav.addObject("reserveFormObj", new Reserve());

        return mav;
    }

    @RequestMapping(value = "/reserveParkingAction", method = RequestMethod.POST)
    public ModelAndView reserveParkingForm(@ModelAttribute("reserveFormObj") Reserve reserve) {

        ModelAndView mav = new ModelAndView("reserveform");

        return mav;
    }
}
