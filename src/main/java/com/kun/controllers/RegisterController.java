package com.kun.controllers;

import com.kun.models.Credential;
import com.kun.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @RequestMapping(value = "processCredentials", method = RequestMethod.POST)
    public ModelAndView getRegistrationForm(@ModelAttribute("userRegistrationObj") Credential credential, BindingResult br,
                                            @RequestParam("confirmPassword") String confirmPassword) {
        ModelAndView mav = null;
        Credential newUser = new Credential();

        if (br.hasErrors()) {
            mav = new ModelAndView("register");
            mav.addObject("message", "There was an error registering your account");
        } else {
            mav = new ModelAndView("login");
        }

        return  mav;
    }
}
