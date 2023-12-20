/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2calculationtax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lizam
 */
public class DatabaseReader extends Database {
    public User getUser(String userName, String password) {
        try (
            Connection conn = DriverManager.getConnection(db_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ) {
           String retrievedUserName = results.getString("UserName");
                String retrievedFirstName = results.getString("FirstName"); // Corrected column name
                String retrievedLastName = results.getString("LastName");
                String retrievedPosition = results.getString("Position");
                Date retrievedBirthDate = results.getDate("BirthDate");
                String retrievedEmail = results.getString("Email");
                String retrievedPassWord = results.getString("PassWord");
                String retrievedType = results.getString("Type");
                commonVariables.Type userType;

                if (retrievedType.equals("Regular")) { // Simplified string comparison
                    userType = commonVariables.Type.Regular;
                } else {
                    userType = commonVariables.Type.Admin;
                }

                String retrievedMaritalStatus = results.getString("MaritalStatus");
                commonVariables.MaritalStatus userMaritalStatus;

                switch (retrievedMaritalStatus) {
                    case "Single":
                        userMaritalStatus = commonVariables.MaritalStatus.Single;
                        break;
                    case "Married":
                        userMaritalStatus = commonVariables.MaritalStatus.Married;
                        break;
                    case "Widowed":
                        userMaritalStatus = commonVariables.MaritalStatus.widowed;
                        break;
                    default:
                        throw new AssertionError();
                } 
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }              
    }
}
