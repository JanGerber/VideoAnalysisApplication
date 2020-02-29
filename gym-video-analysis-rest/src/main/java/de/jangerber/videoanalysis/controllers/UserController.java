package de.jangerber.videoanalysis.controllers;

import de.jangerber.videoanalysis.entities.Customer;
import de.jangerber.videoanalysis.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer createUser(@RequestBody Customer customer) {
        return userDetailsService.registerNewUserAccount(customer);
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public Customer getUserByName(@PathVariable String username) {
        return userDetailsService.getUserByName(username);
    }

}
