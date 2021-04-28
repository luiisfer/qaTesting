/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.restassured;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

/**
 *
 * @author NewUser
 */
public class RequestMaker {
    
    public static Response makeGetRequest(String url){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response makePostRequest(String url, String bodyContent){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(bodyContent)
                .post(url)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response makeDeleteRequest(String url){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
        return response;
    }
}
