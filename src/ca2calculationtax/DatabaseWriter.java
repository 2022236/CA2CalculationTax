/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2calculationtax;

import ioutils.IOUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Updating the method addUserDatabse since it is more accurate to the table, matching values and in the DBWriter 
 * where is responsible for writing new information on the actual  Database
 * @author 2022236 and 2022404
 */
public class DatabaseWriter extends Database{ // Now arguments are better and matching with the attributes the table has
   public boolean addUserDatabase(String userName ,String FirstName, String LastName,String Position, Date BirthDate, String Email, String PassWord, commonVariables.Type Type, commonVariables.MaritalStatus MaritalStatus) throws SQLException {
        IOUtils scan = new IOUtils (); 
        try ( // trycatch being a good option to try the code and if there is an error, catch will catch and return false
            Connection conn = DriverManager.getConnection(db_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();    
        ) { //sql and java command to create a table 
            String sql = String.format("INSERT INTO " + tableName + " (userName, FirstName, LastName,Position, BirthDate, Email, PassWord, Type, MaritalStatus) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
        userName,FirstName, LastName,Position, BirthDate, Email, PassWord, Type, MaritalStatus);
            
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
    }
}
