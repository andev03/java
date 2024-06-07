package com.an.ldapAuth.controller;

import com.an.ldapAuth.model.LdapUser;
import com.an.ldapAuth.service.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LdapAuthenticationController {
    @Autowired
    private LdapService ldapService;
    @GetMapping("/")
    public String index(){
        return "Welcome to the home page!";
    }

    @GetMapping("/getUserDetails")
    public String getUserDetails(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // access user details
        String username = userDetails.getUsername();

        boolean accNonExpired = userDetails.isAccountNonExpired();
        return "UserDetails: " + username + "\n Account Non Expired: " + accNonExpired;
    }
    @GetMapping("/getAllUser")
    public List<LdapUser> getAllUsers(){
        return ldapService.getAllUsers();
    }

}
