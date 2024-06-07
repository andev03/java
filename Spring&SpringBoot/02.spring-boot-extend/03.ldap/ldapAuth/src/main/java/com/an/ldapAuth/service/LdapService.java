package com.an.ldapAuth.service;

import com.an.ldapAuth.model.LdapUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class LdapService {
    @Autowired
    private LdapTemplate ldapTemplate;


    public void addUser(LdapUser ldapUser) {
        ldapTemplate.bind("uid=" + ldapUser.getUsername(), null, ldapUser.toAttributes());
    }

    public List<LdapUser> getAllUsers() {
        Logger logger = LoggerFactory.getLogger(getClass());
        List<LdapUser> users = new ArrayList<>();

        try {
            users = ldapTemplate.search("", "(objectClass=inetOrgPerson)",
                    (AttributesMapper<LdapUser>) attributes -> {
                        LdapUser ldapUser = new LdapUser();
                        if (attributes.get("cn") != null) {
                            ldapUser.setCn(attributes.get("cn").get().toString());
                        }
                        if (attributes.get("sn") != null) ldapUser.setSn(attributes.get("sn").get().toString());
                        if (attributes.get("uid") != null) ldapUser.setUsername(attributes.get("uid").get().toString());
                        if (attributes.get("userPassword") != null)
                            ldapUser.setPassword(attributes.get("userPassword").get().toString());
                        return ldapUser;
                    });
        } catch (Exception e) {
            logger.error("Error while fetching users from LDAP", e);
        }

        if (users.isEmpty()) {
            logger.info("No users found with " + users);
        } else {
            logger.info("Found {} users", users.size());
        }

        return users;
    }
}
