package ooad.ooad;

import java.sql.*;


public class SQLiteTest {
    public static void main(String[] args) {
        try {
            // The SQLite (3.3.8) Database File
            // This database has one table (pmp_countries) with 3 columns (country_id, country_code, country_name)
            //.OpenAtts test.db
            //create tableCREATE TABLE country(country_id int PRIMARY KEY not null,country_code  char(50),,country_name char(50));
        	//INSERT INTO country(country_id, country_code, country_name) VALUES (1,'221116','徐州',);
        	//INSERT INTO country(country_id, country_code, country_name) VALUES (2,'474369','南阳',);
        	// It has like 237 records of all the countries I could think of.
            String fileName = "D:/SQLite/test.db";
            // Driver to Use
            // http://www.zentus.com/sqlitejdbc/index.html
            Class.forName("org.sqlite.JDBC");
            // Create Connection Object to SQLite Database
            // If you want to only create a database in memory, exclude the +fileName
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fileName);
            // Create a Statement object for the database connection, dunno what this stuff does though.
            Statement stmt = conn.createStatement();
            // Create a result set object for the statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM country ");
            // Iterate the result set, printing each column
            // if the column was an int, we could do rs.getInt(column name here) as well, etc.
            while (rs.next()) {
                String id   = rs.getString("country_id");   // Column 1
                String code = rs.getString("country_code"); // Column 2
                String name = rs.getString("country_name"); // Column 3
                System.out.println("ID: "+id+" Code: "+code+" Name: "+name);

            }
            // Close the connection
            conn.close();
        }
        catch (Exception e) {
            // Print some generic debug info
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}