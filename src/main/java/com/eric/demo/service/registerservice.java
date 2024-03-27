package com.eric.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.demo.domain.login;
import com.eric.demo.reposiory.loginrepo;
@Service
public class registerservice {

   
    @Autowired
    private loginrepo rep;
    public login saveUser(String username, String password) {
        login user = new login();
        user.setUsername(username);
        user.setPassword(password);
        return rep.save(user);
        
    }


}
