package com.an.ldapAuth.controller;

import com.an.ldapAuth.model.LdapUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.an.ldapAuth.service.LdapService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private LdapService ldapService;

    @GetMapping("/addUserForm")
    public String index(Model model){
        model.addAttribute("ldapUser", new LdapUser());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(LdapUser ldapUser){
        ldapService.addUser(ldapUser);
        return "success";
    }


}
