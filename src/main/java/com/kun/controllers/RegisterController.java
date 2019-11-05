package com.kun.controllers;

import com.kun.models.Authority;
import com.kun.models.Credential;
import com.kun.models.User;
import com.kun.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    CredentialRepository credentialRepository;

    @RequestMapping(value = "processCredentials", method = RequestMethod.POST)
    public ModelAndView getRegistrationForm(@ModelAttribute("userRegistrationObj") Credential credential, BindingResult br,
                                            @RequestParam("confirmPassword") String confirmPassword) {
        ModelAndView mav = null;
        Credential newUser = new Credential();

        if (br.hasErrors() || credential == null) {
            mav = new ModelAndView("register");
            mav.addObject("message", "There was an error registering your account");
        } else {
            if (credential.getPassword().equals(confirmPassword)) {
                mav = new ModelAndView("login");
                //set up the user
                User user = credential.getUser();
                user.setEmail(credential.getUsername());
                user.setCredential(newUser);

                //Authority

                Authority authority = new Authority();
                authority.setAuthority("user");
                authority.setCredential(newUser);

                //set up credentials
                newUser.setPassword(credential.getPassword());
                newUser.setUsername(credential.getUsername());
                newUser.setUser(user);
                newUser.getAuthorities().add(authority);

                credentialRepository.save(newUser);
                mav.addObject("message", "Successfully registered account.\nYou can login using the account.");

            } else {
                mav = new ModelAndView("redirect:/register");
            }
        }

        return  mav;
    }
}
