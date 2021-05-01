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
public class InvoiceIT {
    
    
    @Test
    public void invoice(){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/invoice/invoice");
        String responseString = response.asString();
        System.out.println("invoice " +responseString);
    }
    
    @Test
    public void newInvoice(){
        
        Response response = RequestMaker.makePostRequest("http://localhost:8080/invoice/invoice?noSerie=U&fechaFactura=u&nombreCliente=a&nitCliente=aaab&total=25","");
        String responseString = response.asString();
        System.out.println("newInvoice " +responseString);
    }
    
    @Test
    public void deleteInvoice(){
        
        Response response = RequestMaker.makeDeleteRequest("http://localhost:8080/invoice/invoice?serial_number=U");
        String responseString = response.asString();
        System.out.println("deleteInvoice " +responseString);
    }
}
