/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.qa.testing.model.Product;
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
@RequestMapping("product")
public class ProductController {

    @Autowired
    private Product product;

    @GetMapping("/product")
    public ArrayNode showProduct() {
        return product.Product();
    }

    @PostMapping("/product")
    public boolean productAdd(@DefaultValue("0") @RequestParam(value = "name") String name, @DefaultValue("0") @RequestParam(value = "price") double price) {
        return product.newProduct(name, price);
    }

    @DeleteMapping("/product")
    public boolean productDelete(@DefaultValue("0") @RequestParam(value = "name_product") String name_product) {
        return product.DelProduct(name_product);
    }

}
