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
public class ProductIT {
    
    @Test
    public void product(){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/product/product");
        String responseString = response.asString();
        System.out.println("product " +responseString);
    }
    
    @Test
    public void newProduct(){
        
        Response response = RequestMaker.makePostRequest("http://localhost:8080/product/product?name=U&lastname=u&price=18","");
        String responseString = response.asString();
        System.out.println("newProduct " +responseString);
    }
    
    @Test
    public void deleteProduct(){
        
        Response response = RequestMaker.makeDeleteRequest("http://localhost:8080/product/product?name_product=U");
        String responseString = response.asString();
        System.out.println("deleteProduct " +responseString);
    }
}
