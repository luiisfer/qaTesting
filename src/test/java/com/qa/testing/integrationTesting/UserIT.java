/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.integrationTesting;


import com.qa.testing.dataProvider.DataProvidersClass;
import com.qa.testing.restassured.RequestMaker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author NewUser
 */
public class UserIT {
    
    
    @Test(dataProviderClass = DataProvidersClass.class, dataProvider = "getParameters")
    public void getBYId(String bodyContent){
        
        Response response = RequestMaker.makeGetRequest("http://localhost:8080/user/logeo?user=U&password=a");
        String responseString = response.asString();
        System.out.println("bodyContent " + bodyContent);
        System.out.println(responseString);
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
