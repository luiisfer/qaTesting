package com.qa.testing.model;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Invoice {
    
    public ArrayNode  showInvoice() {
        
        String sqlSelectlogin = "SELECT * FROM qa_invoice";
        
        ObjectNode objectNode;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement ps = conn.prepareStatement(sqlSelectlogin);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                objectNode = new ObjectNode(JsonNodeFactory.instance);
                objectNode.put("id", rs.getInt(1));
                objectNode.put("serial_number", rs.getString(2));
                objectNode.put("fecha", rs.getString(3));
                objectNode.put("nombreCliente", rs.getString(4));
                objectNode.put("nitCliente", rs.getString(5));
                objectNode.put("total", rs.getDouble(6));
                arrayNode.add(objectNode);

            }

            return arrayNode;
        } catch (JSONException | SQLException e) {
            System.out.println("error" + e);
            return arrayNode;
        }

    }
    
    public boolean invoiceAdd( String noSerie, String fechaFactura,  
            String nombreCliente, String nitCliente,
            int total) {
        boolean isInserted = false;

        String sqlInsert = "INSERT INTO qa_invoice(serial_number, invoice_date,client_name,client_nit,total_price) VALUES (?, ?, ?, ?, ?)";
        if (noSerie.equals("0") || nombreCliente.equals("0")) {
            System.out.println("Parametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, noSerie);
            preparedStatement.setString(2, fechaFactura);
            preparedStatement.setString(3, nombreCliente);
            preparedStatement.setString(4, nitCliente);
            preparedStatement.setInt(5, total);
            
                
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            isInserted = true;
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isInserted;
    }
    
     public boolean invoiceDelete(  String serial_number) {
        boolean isInserted = false;

        String sqlInsert = "DELETE FROM qa_invoice WHERE serial_number =?";
        if (serial_number.equals("0")) {
            System.out.println("Parametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, serial_number);
            System.out.println("Eliminado Exitosamente");
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            isInserted = true;
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isInserted;
    }
}
