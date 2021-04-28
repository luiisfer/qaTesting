package com.qa.testing.model;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONException;


import java.sql.*;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Supplier {


    public ArrayNode Supplier() {

        String sqlSelectlogin = "SELECT * FROM qa_supplier";

        ObjectNode objectNode;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement ps = conn.prepareStatement(sqlSelectlogin);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                objectNode = new ObjectNode(JsonNodeFactory.instance);
                objectNode.put("id", rs.getInt(1));
                objectNode.put("nombre", rs.getString(2));
                objectNode.put("direccion", rs.getString(3));
                objectNode.put("nit", rs.getString(4));
                arrayNode.add(objectNode);

            }

            return arrayNode;
        } catch (JSONException | SQLException e) {
            System.out.println("error" + e);
            return arrayNode;
        }

    }

    public boolean AddSupplier( String name,  String direccion,  String nit) {
        boolean isInserted = false;

        String sqlInsert = "INSERT INTO qa_supplier(nombre, direccion,nit) VALUES (?, ?, ?)";
        if (name.equals("0") || direccion.equals("0")) {
            System.out.println("Prametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, nit);


            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            isInserted = true;
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isInserted;
    }

    public boolean DelSupplier(  String name_supplier) {
        boolean isInserted = false;

        String sqlInsert = "DELETE FROM qa_supplier WHERE nombre =?";
        if (name_supplier.equals("0")) {
            System.out.println("Prametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, name_supplier);
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
