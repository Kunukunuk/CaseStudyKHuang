package com.kun.controllers;

import com.kun.models.Authority;
import com.kun.models.Credential;
import com.kun.models.User;
import com.kun.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        Credential newCredential = credential;

        if (br.hasErrors() || credential == null) {
            mav = new ModelAndView("register");
            mav.addObject("message", "There was an error registering your account");
        } else {
            if (credential.getPassword().equals(confirmPassword)) {
                //set up the user
                User user = credential.getUser();
                user.setEmail(credential.getUsername());

                //Authority
                Authority authority = new Authority();
                authority.setAuthority("user");

                //set up credentials
//                newCredential.setPassword(credential.getPassword());
                String encodedPass = new BCryptPasswordEncoder().encode(credential.getPassword());
                newCredential.setUsername(credential.getUsername());
                newCredential.setPassword(encodedPass);
                newCredential.setUser(user);
                newCredential.getAuthorities().add(authority);
                authority.setCredential(newCredential);

                credentialRepository.save(newCredential);
                mav = new ModelAndView("login");
                mav.addObject("message", "Successfully registered account.\nYou can login using the account.");

            } else {
                mav = new ModelAndView("redirect:/register");
            }
        }

        return  mav;
    }
}
