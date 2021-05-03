/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.unitTesting;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.testing.model.Client;
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
public class ClientNGTest {
    
  

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class ClientNGTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method ClientNGTest");
    }
    /**
     * Test of showClient method, of class Client.
     */
    @Test
    public void testShowClient() {
        System.out.println("showClient");
        Client instance = new Client();
        ObjectNode on = new ObjectNode(JsonNodeFactory.instance);
        
        ArrayNode expResult = new ArrayNode(JsonNodeFactory.instance);
        expResult.add(on);
        ArrayNode result = instance.showClient();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of clientAdd method, of class Client.
     */
    @Test(description = "test Added Client", dependsOnMethods = {"testShowClient"} , groups = {"unitTesting"})
    public void testClientAdd() {
        System.out.println("clientAdd");
        String name = "MarioM";
        String lastname = "Martinez";
        String nit = "9063";
        Client instance = new Client();
        boolean expResult = true;
        boolean result = instance.clientAdd(name, lastname, nit);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clientDelete method, of class Client.
     */
    @Test(description = "test deleted Client", dependsOnMethods = {"testClientAdd"} , groups = {"unitTesting"})
    public void testClientDelete() {
        System.out.println("clientDelete");
        String name_client = "MarioM";
        Client instance = new Client();
        boolean expResult = true;
        boolean result = instance.clientDelete(name_client);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. ClientNGTest");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("After class ClientNGTest");
        System.out.println("\n");
    }
    
}
