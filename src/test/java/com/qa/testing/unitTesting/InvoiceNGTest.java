/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.unitTesting;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.testing.model.Invoice;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author NewUser
 */
public class InvoiceNGTest {
    
    

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n");
        System.out.println("\nbefore class InvoiceNGTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method InvoiceNGTest");
    }
    /**
     * Test of showInvoice method, of class Invoice.
     */
    @Test
    public void testShowInvoice() {
        System.out.println("showInvoice");
        Invoice instance = new Invoice();
        ObjectNode on = new ObjectNode(JsonNodeFactory.instance);
        on.put("id", 1);
        on.put("serial_number", "0110");
        on.put("fecha", "2021-04-01");
        on.put("nombreCliente", "Cliente1");
        on.put("nitCliente", "14");
        on.put("total", 20.0);
        ObjectNode on1 = new ObjectNode(JsonNodeFactory.instance);
        on1.put("id", 2);
        on1.put("serial_number", "2020");
        on1.put("fecha", "2021-04-02");
        on1.put("nombreCliente", "Cliente2");
        on1.put("nitCliente", "32");
        on1.put("total", 30.0);
        ArrayNode expResult = new ArrayNode(JsonNodeFactory.instance);
        expResult.add(on);
        expResult.add(on1);
        System.out.println("expResult " + expResult);
        ArrayNode result = instance.showInvoice();
        System.out.println("result    " + result);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of invoiceAdd method, of class Invoice.
     */
    @Test(description = "test Added Invoice", dependsOnMethods = {"testShowInvoice"} , groups = {"unitTesting"})
    public void testInvoiceAdd() {
        System.out.println("invoiceAdd");
        String noSerie = "0001";
        String fechaFactura = "2021-04-02";
        String nombreCliente = "Cliente50";
        String nitCliente = "808";
        int total = 10;
        Invoice instance = new Invoice();
        boolean expResult = true;
        boolean result = instance.invoiceAdd(noSerie, fechaFactura, nombreCliente, nitCliente, total);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of invoiceDelete method, of class Invoice.
     */
    @Test(description = "test deleted Invoice", dependsOnMethods = {"testInvoiceAdd"} , groups = {"unitTesting"})
    public void testInvoiceDelete() {
        System.out.println("invoiceDelete");
        String serial_number = "0001";
        Invoice instance = new Invoice();
        boolean expResult = true;
        boolean result = instance.invoiceDelete(serial_number);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method. InvoiceNGTest");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("\n");
        System.out.println("After class InvoiceNGTest");
    }
}
