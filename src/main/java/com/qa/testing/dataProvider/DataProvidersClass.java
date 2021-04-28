/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.dataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

/**
 *
 * @author NewUser
 */
public class DataProvidersClass {
    
    @DataProvider(name = "getParameters", parallel = true)
    public Iterator<Object[]> getParameters() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("username","username"+i);
            bodyContent.put("firstname","firstname"+i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }
}
