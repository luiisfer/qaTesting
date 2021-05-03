/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.unitTesting;

import com.qa.testing.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;

/**
 *
 * @author NewUser
 */
public class UserClassNGTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class UserClassNGTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method UserClassNGTest");
    }

    /**
     * Test of isLoggin method, of class UserClass.
     */
    @Test(groups = {"unitTesting"})
    public void testIsLoggin() {
        System.out.println("isLoggin");
        final boolean actualResult = true;
        String user = "Prueba";
        String password = "123";
        User userClass = new User();
        boolean expectedResult = userClass.isLoggin(user, password);
        Assert.assertEquals(actualResult, expectedResult, " Valor no es correcto");
    }
//    

    @Test(groups = {"unitTesting"})
    public void testAddedUser() {
        System.out.println("addedUser");
        String name = "PruebasUni";
        String user = "PruebasUni";
        String password = "741";
        User userClass = new User();
        boolean expResult = true;
        boolean result = userClass.addedUser(name, user, password);
        Assert.assertEquals(result, expResult, " Valor no es correcto");
        // TODO review the generated test code and remove the default call to fail.

    }
//    

    @Test(description = "test deleted User", dependsOnMethods = {"testAddedUser"} ,groups = {"unitTesting"})
    public void testDeletedUser() {
        System.out.println("deletedUser");
        String user = "PruebasUni";
        User userClass = new User();
        boolean expResult = true;
        boolean result = userClass.deletedUser(user);
        Assert.assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. UserClassNGTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class UserClassNGTest");
        System.out.println("\n");
    }

}
