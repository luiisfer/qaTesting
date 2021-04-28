/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.controller;


import com.fasterxml.jackson.databind.node.ArrayNode;
import com.qa.testing.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private Client client;

    

    @GetMapping("/client")
    public ArrayNode  showClient() {
        return client.showClient();
    }
    
    
    @PostMapping("/client")
    public boolean clientAdd(@DefaultValue("0") @RequestParam(value = "name") String name, @DefaultValue("0") @RequestParam(value = "lastname") String lastname, @DefaultValue("0") @RequestParam(value = "nit") String nit) {
        return client.clientAdd(name, lastname, nit);
    }

    @DeleteMapping("/client")
    public boolean clientDelete( @DefaultValue("0") @RequestParam(value = "name_client") String name_client) {
        return client.clientDelete(name_client);
    }

}
