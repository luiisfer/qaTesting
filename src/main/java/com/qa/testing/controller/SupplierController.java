/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;


import com.qa.testing.model.Supplier;
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
@RequestMapping("supplier")
public class SupplierController {
    
    

    @Autowired
    private Supplier supplier;
    
    @GetMapping("/supplier")
    public ArrayNode  showSupplier() {
        return supplier.Supplier();
    }
     
    @PostMapping("/supplier")
    public boolean supplierAdd(@DefaultValue("0") @RequestParam(value = "name") String name,@DefaultValue("0") @RequestParam(value = "direccion") String direccion,  @DefaultValue("0") @RequestParam(value = "nit") String nit) {
        return supplier.AddSupplier(name,direccion,nit);
    }

    @DeleteMapping("/supplier")
    public boolean supplierDelete( @DefaultValue("0") @RequestParam(value = "name_supplier") String name_supplier) {
        return supplier.DelSupplier(name_supplier);
    }
}
