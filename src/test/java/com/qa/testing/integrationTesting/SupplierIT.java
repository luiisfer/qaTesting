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
public class SupplierIT {
    
    @Test(groups = {"integrationTesting"})
    public void supplier(){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/supplier/supplier");
        String responseString = response.asString();
        System.out.println("supplier " +responseString);
    }
    
    @Test(groups = {"integrationTesting"})
    public void newSupplier(){
        
        Response response = RequestMaker.makePostRequest("http://localhost:8080/supplier/supplier?name=U&lastname=u&nit=a","");
        String responseString = response.asString();
        System.out.println("newSupplier " +responseString);
    }
    
    @Test(groups = {"integrationTesting"})
    public void deleteSupplier(){
        
        Response response = RequestMaker.makeDeleteRequest("http://localhost:8080/supplier/supplier?name_supplier=U");
        String responseString = response.asString();
        System.out.println("deleteSupplier " +responseString);
    }
    
}
