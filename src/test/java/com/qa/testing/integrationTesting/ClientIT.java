/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.integrationTesting;

import com.qa.testing.restassured.RequestMaker;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 *
 * @author NewUser
 */
public class ClientIT {
    
    @Test
    public void client(){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/client/client");
        String responseString = response.asString();
        System.out.println("client " +responseString);
    }
    
    @Test
    public void newClient(){
        
        Response response = RequestMaker.makePostRequest("http://localhost:8080/client/client?name=U&lastname=u&nit=a","");
        String responseString = response.asString();
        System.out.println("newClient " +responseString);
    }
    
    @Test
    public void deleteClient(){
        
        Response response = RequestMaker.makeDeleteRequest("http://localhost:8080/client/client?name_client=U");
        String responseString = response.asString();
        System.out.println("deleteClient " +responseString);
    }
}
