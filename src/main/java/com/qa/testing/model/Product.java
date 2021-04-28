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
public class Product {

    public ArrayNode Product() {

        String sqlSelectlogin = "SELECT * FROM qa_product";

        ObjectNode objectNode;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement ps = conn.prepareStatement(sqlSelectlogin);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                objectNode = new ObjectNode(JsonNodeFactory.instance);
                objectNode.put("id", rs.getInt(1));
                objectNode.put("nombre", rs.getString(2));
                objectNode.put("price", rs.getDouble(3));
                arrayNode.add(objectNode);

            }

            return arrayNode;
        } catch (JSONException | SQLException e) {
            System.out.println("error" + e);
            return arrayNode;
        }

    }

    public boolean newProduct( String name, double price) {
        boolean isInserted = false;

        String sqlInsert = "INSERT INTO qa_product(nombre, price) VALUES (?, ?)";
        if (name.equals("0") || price == 0) {
            System.out.println("Parametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);

            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            isInserted = true;
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isInserted;
    }

    public boolean DelProduct(String name_product) {
        boolean isInserted = false;

        String sqlInsert = "DELETE FROM qa_product WHERE nombre =?";
        if (name_product.equals("0")) {
            System.out.println("Parametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
                PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, name_product);
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
