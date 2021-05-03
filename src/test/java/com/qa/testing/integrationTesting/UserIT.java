/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.integrationTesting;



import com.qa.testing.dataProvider.DataProvidersClass;
import com.qa.testing.restassured.RequestMaker;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



/**
 *
 * @author NewUser
 */

public class UserIT {
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class UserIT");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method UserIT");
    }
    //integrationTesting.UserIT
    
    @Test(dataProviderClass = DataProvidersClass.class, dataProvider = "getParameters" , groups = {"integrationTesting"})
    public void logeo(String name, String user, String password  ){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/user/logeo?user="+name+"&password="+password);
        System.out.println("http://localhost:8080/user/logeo?user="+name+"&password="+password);
        String responseString = response.asString();
        System.out.println("logeo " +responseString);
    }
    
    @Test(groups = {"integrationTesting"})
    public void newUser(){
        
        Response response = RequestMaker.makePostRequest("http://localhost:8080/user/user/?name=U&user=U&password=123","");
        String responseString = response.asString();
        System.out.println("newUser " +responseString);
    }
    
    @Test(groups = {"integrationTesting"})
    public void deleteUser(){
        
        Response response = RequestMaker.makeDeleteRequest("http://localhost:8080/user/user?user=U");
        String responseString = response.asString();
        System.out.println("deleteUser " +responseString);
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. UserIT");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class UserIT");
        System.out.println("\n");
    }
    
    
//    @Test(dataProviderClass = DataProvidersClass.class, dataProvider = "getParameters")
//    public void NewUserIT(String bodyContent){
//        Response response = RequestMaker.makePostRequest("http://localhost:8000/user/logeo",bodyContent);
//        if(bodyContent.contains("499")){
//            Assert.fail("fails");
//        }
//        String responseString = response.asString();
//        System.out.println(responseString);
//    }
}
