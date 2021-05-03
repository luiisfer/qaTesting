/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.unitTesting;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.testing.model.Supplier;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author NewUser
 */
public class SupplierNGTest {

    

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class SupplierNGTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method SupplierNGTest");
    }

    /**
     * Test of Supplier method, of class Supplier.
     */
    @Test
    public void testSupplier() {
        System.out.println("Supplier");
        Supplier instance = new Supplier();
        ObjectNode on = new ObjectNode(JsonNodeFactory.instance);
        on.put("id", 1);
        on.put("nombre", "Proveedor");
        on.put("direccion", "GT");
        on.put("nit", "10");
        ArrayNode expResult = new ArrayNode(JsonNodeFactory.instance);
        expResult.add(on);
        System.out.println("expResult " + expResult);
        ArrayNode result = instance.Supplier();
        System.out.println("result    " + result);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AddSupplier method, of class Supplier.
     */
    @Test(description = "test Added Supplier", dependsOnMethods = {"testSupplier"} , groups = {"unitTesting"})
    public void testAddSupplier() {
        System.out.println("AddSupplier");
        String name = "Proveedor5";
        String direccion = "GT";
        String nit = "14";
        Supplier instance = new Supplier();
        boolean expResult = true;
        boolean result = instance.AddSupplier(name, direccion, nit);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of DelSupplier method, of class Supplier.
     */
    @Test(description = "test deleted Supplier", dependsOnMethods = {"testAddSupplier"} , groups = {"unitTesting"})
    public void testDelSupplier() {
        System.out.println("DelSupplier");
        String name_supplier = "Proveedor5";
        Supplier instance = new Supplier();
        boolean expResult = true;
        boolean result = instance.DelSupplier(name_supplier);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. SupplierNGTest");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("\n");
        System.out.println("After class SupplierNGTest");
    }
}

