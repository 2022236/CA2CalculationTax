/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2calculationtax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2022236 and 2022404
 */
public class DatabaseSetup extends Database{
     final static String dbBaseURL = "jdbc:mysql://localhost";
    final static String USER = "OOC2023";
    final static String PASSWORD = "ooc2023";
    
    public static boolean setupDB()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    try(
         Connection conn = DriverManager.getConnection(dbBaseURL,USER,PASSWORD);
         Statement stmt = conn.createStatement();
            
            ){
            // Create database if it doesn't exist
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + dbName + ";");
            stmt.execute("USE " + dbName + ";");

            // SQL to create a table with all the attributes and PK
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "UserName VARCHAR(255),"
                + "FirstName VARCHAR(255),"
                + "LastName VARCHAR(255),"
                + "Position VARCHAR(255),"
                + "BirthDate DATE,"
                + "Email VARCHAR(255),"
                + "PassWord VARCHAR(255),"
                + "Type ENUM('Admin', 'Regular'),"
                + "MaritalStatus ENUM('Single', 'Married', 'Widowed'),"
                + "PRIMARY KEY (UserName)"
                + ");";
        stmt.execute(sql);
        return true;
      } catch (Exception e){
          e.printStackTrace();
          return false;
      }   
   }
}
