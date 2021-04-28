/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.controller;

import com.qa.testing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NewUser
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private User userClass;

    @GetMapping("/logeo")
    public boolean login(@DefaultValue("0") @RequestParam(value = "user") String user, @DefaultValue("0") @RequestParam(value = "password") String password) {
        return userClass.isLoggin(user,password);
    }

    @PostMapping("/user")
    public boolean userAdd(@DefaultValue("0") @RequestParam(value = "name") String name, @DefaultValue("0") @RequestParam(value = "user") String user, @DefaultValue("0") @RequestParam(value = "password") String password) {
        return userClass.addedUser(name,user,password);
    }

    @DeleteMapping("/user")
    public boolean userDelete( @DefaultValue("0") @RequestParam(value = "user") String user) {
        return  userClass.deletedUser(user);
    }
    

}
