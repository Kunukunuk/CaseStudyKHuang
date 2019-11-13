package com.kun.controllers;

import com.kun.models.Credential;
import com.kun.models.Parking;
import com.kun.models.Reserve;
import com.kun.repositories.CredentialRepository;
import com.kun.repositories.UserRepository;
import com.kun.services.ParkingService;
import com.kun.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    ParkingService parkingService;

    @RequestMapping(value = "/reserveform", method = RequestMethod.GET)
    public ModelAndView getReserveForm(@RequestParam("pid") int id) {

        ModelAndView mav = new ModelAndView("reserveform");

        Parking parking = parkingService.findById(id);
        mav.addObject("reserveFormObj", new Reserve());
        mav.addObject("parking", parking);

        return mav;
    }

    @RequestMapping(value = "/reserveParkingAction", method = RequestMethod.POST)
    public ModelAndView reserveParkingForm(@Valid @ModelAttribute("reserveFormObj") Reserve reserve, BindingResult br,
                                           Principal principal) {

        ModelAndView mav = null;

        if (br.hasErrors()) {
            mav = new ModelAndView("redirect:/reserveform");
            mav.addObject("message", "Something went wrong");
        } else {

            Reserve reserve1 = reserve;

            Credential currentCred = credentialRepository.findByUsername(principal.getName());
            currentCred.getUser().getReserves().add(reserve1);
            reserve1.setUser(currentCred.getUser());


//            Set<Parking> parkings = parkingService.getAllParkings();

//            parking.setReservedBy(currentCred.getUser());

            reserveService.save(reserve1);
            userRepository.save(currentCred.getUser());

//            parkingService.save(parking);

            mav = new ModelAndView("home");
            mav.addObject("message", "Successfully reserved the parking");

        }


        return mav;
    }

}
