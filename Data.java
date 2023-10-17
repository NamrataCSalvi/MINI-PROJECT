

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Data {

    public static void main(String[] args) {
        // Replace "jdbc:mysql://localhost:3306/database_name" with the appropriate database connection string
        String connectionUrl = "jdbc:mysql://localhost:3306/mproject";
       
        // Replace "root" and "password" with the appropriate database username and password
        String username = "root";
        String password = "12345";

        // Assuming 'request' represents a form request object (you should adapt this to your framework)
        request request = new request();

        String name = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        Blob image = request.getimBlob("imageinput");
        int pass = request.getIntegerPassword("passw");

        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);
            

            // Create a prepared statement to insert the form data into the database
            String sql = "INSERT INTO itable3 (name, email, image, pass) VALUES (username, email, uimage, passw)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setBlob(3, image);
            preparedStatement.setInt(4, pass);

            // Execute the prepared statement
            preparedStatement.executeUpdate();

            // Close the prepared statement and the connection
            preparedStatement.close();
            connection.close();

            System.out.println("Data stored successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class request {
    // Implement your 'getParameter' method to return the form data as needed
    public String getParameter(String paramName) {
        // This is a placeholder; implement your logic here to retrieve form data
        return null;
    }
    public Blob getimBlob(String imageParamName) {
           return null;
    }
    public int getIntegerPassword (int passwordParamName) {
        return 0;
        }
}
