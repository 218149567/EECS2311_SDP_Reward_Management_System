package dataBase;

import java.sql.*;
import java.util.Map;

public class JDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name_here";
        String user = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try {
            // Create a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM your_table_name_here";
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate through the result set and print the data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
