/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.unitTesting;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.testing.model.Product;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author NewUser
 */
public class ProductNGTest {
    
    

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class ProductNGTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method ProductNGTest");
    }
    /**
     * Test of Product method, of class Product.
     */
    @Test
    public void testProduct() {
        System.out.println("Product");
        Product instance = new Product();
        ObjectNode on = new ObjectNode(JsonNodeFactory.instance);
        on.put("id", 1);
        on.put("nombre", "pasta");
        on.put("price", 10.50);
        ObjectNode on1 = new ObjectNode(JsonNodeFactory.instance);
        on1.put("id", 2);
        on1.put("nombre", "arroz");
        on1.put("price", 5.80);
        ArrayNode expResult = new ArrayNode(JsonNodeFactory.instance);
        expResult.add(on);
        expResult.add(on1);
        ArrayNode result = instance.Product();
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of newProduct method, of class Product.
     */
    //dependsOnMethods = {"testProduct"},
    @Test(description = "test Added Product",  groups = {"unitTesting"})
    public void testNewProduct() {
        System.out.println("newProduct");
        String name = "Producto1";
        double price = 10.0;
        Product instance = new Product();
        boolean expResult = true;
        boolean result = instance.newProduct(name, price);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DelProduct method, of class Product.
     */
    @Test(description = "test deleted Product", dependsOnMethods = {"testNewProduct"} , groups = {"unitTesting"})
    public void testDelProduct() {
        System.out.println("DelProduct");
        String name_product = "Producto1";
        Product instance = new Product();
        boolean expResult = true;
        boolean result = instance.DelProduct(name_product);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. ProductNGTest");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("\n");
        System.out.println("After class ProductNGTest");
    }
    
}
