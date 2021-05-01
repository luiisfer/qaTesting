/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.dataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
            String name = "name"+i;
            String user = "user"+i;
            String password = "password"+i;
            data.add(new Object[]{name,user,password});
        }
        return data.iterator();
    }
}
