package com.kun.controllers;

import com.kun.models.Credential;
import com.kun.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    CredentialRepository credentialRepository;

    @RequestMapping(value = "/welcome")
    public ModelAndView getWelcomePage(Principal principal) {
        ModelAndView mav = new ModelAndView("welcome");
        Credential credential = credentialRepository.findByUsername(principal.getName());
        mav.addObject("user", credential);

        return mav;
    }
}
