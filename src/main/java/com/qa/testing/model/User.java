package com.qa.testing.model;



import java.sql.*;
import org.springframework.context.annotation.Configuration;




@Configuration
public class User {


    public boolean isLoggin (String user, String password){
        boolean isLoggin = false;
        String sqlSelectlogin = "SELECT count(*) as contador FROM qa_user where usuario='" + user + "' and password= '" + password + "'";
        if (user.equals("0") || password.equals("0")) {
            System.out.println("PArametros vacios");
        }
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement ps = conn.prepareStatement(sqlSelectlogin);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                long id = rs.getLong("contador");
                System.out.println("id " + id);
                if (rs.getLong("contador") == 1) {
                    isLoggin = true;
                }

            }
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isLoggin;
    }

    public boolean addedUser(String name, String user, String password){
        boolean isInserted = false;

        String sqlInsert = "INSERT INTO qa_user(nombre, usuario, password) VALUES (?, ? ,?)";
        if (user.equals("0") || password.equals("0")) {
            System.out.println("Prametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, user);
            preparedStatement.setString(3, password);

            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            isInserted = true;
        } catch (SQLException e) {
            System.out.println("error" + e);
        }

        return isInserted;
    }

    public boolean deletedUser(String user){
        boolean isInserted = false;

        String sqlInsert = "DELETE FROM qa_user WHERE usuario =?";
        if (user.equals("0")) {
            System.out.println("Prametros vacios");
            return isInserted;
        }
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://160.153.133.172:3306/qatesting", "i12345678_1", "123qweasd!");
             PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, user);
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
