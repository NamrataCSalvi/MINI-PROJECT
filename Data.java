
package com.example;

import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("user-form")
public class Data extends HttpServlet {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Replace "jdbc:mysql://localhost:3306/database_name" with the appropriate
            // database connection string
            String connectionUrl = "jdbc:mysql://localhost:3306/mproject";

            // Replace "root" and "password" with the appropriate database username and
            // password
            String username = "root";
            String password = "12345";

            // Assuming 'request' represents a form request object (you should adapt this to
            // your framework)
            request request = new request();

            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            Blob image = request.getimBlob("imageinput");
            int pass = request.getIntegerPassword("passw");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);

            String q = "insert into itable3 (username,email,uimage,passw) values (?,?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setBlob(3, image);
            pstm.setInt(4, pass);
            pstm.executeUpdate();
            System.out.println("Data inserted successfully!");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        // Create a prepared statement to insert the form data into the database
        // String sql = "INSERT INTO itable3 (username, email, uimage, passw) VALUES
        // (name, email, image, pass)";
        // PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // preparedStatement.setString(1, name);
        // preparedStatement.setString(2, email);
        // preparedStatement.setBlob(3, image);
        // preparedStatement.setInt(4, pass);

        // Execute the prepared statement
        // preparedStatement.executeUpdate();

        // Close the prepared statement and the connection
        // preparedStatement.close();
        // c//onnection.close();
        // if (connection.isClosed()) {
        // System.out.println("not connected");
        // }

        // else {
        // System.out.println("Data stored successfully");
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }
}

class request {

    public String getParameter(String paramName) {

        return null;
    }

    public Blob getimBlob(String imageParamName) {
        return null;
    }

    public int getIntegerPassword(String passwordParamName) {
        return 0;
    }
}
