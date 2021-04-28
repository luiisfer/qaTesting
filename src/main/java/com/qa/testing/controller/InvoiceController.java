/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qa.testing.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.qa.testing.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NewUser
 */
@RestController
@RequestMapping("invoice")
public class InvoiceController {
    
    @Autowired
    private Invoice invoice;
    
    @GetMapping("/invoice")
    public ArrayNode  showInvoice() {
        return invoice.showInvoice();
    }
    
    @PostMapping("/invoice")
    public boolean invoiceAdd(@DefaultValue("0") @RequestParam(value = "noSerie") String noSerie,@DefaultValue("0") @RequestParam(value = "fechaFactura") String fechaFactura,  
            @DefaultValue("0") @RequestParam(value = "nombreCliente") String nombreCliente, @DefaultValue("0") @RequestParam(value = "nitCliente") String nitCliente,
            @DefaultValue("0") @RequestParam(value = "total") int total) {
        return invoice.invoiceAdd(noSerie, fechaFactura, nombreCliente, nitCliente, total);
    }

    @DeleteMapping("/invoice")
    public boolean invoiceDelete( @DefaultValue("0") @RequestParam(value = "serial_number") String serial_number) {
        return invoice.invoiceDelete(serial_number);
    }
   
    
}
