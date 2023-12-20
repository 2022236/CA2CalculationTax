package taxcalculationsca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author lizandra 2022236 and Taciana 2022404
 */

public class DatabaseReader extends Database {
    public User getUser(String userName, String password) {
        try (
            Connection conn = DriverManager.getConnection(db_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ) {
            String sql = String.format("SELECT * FROM %s WHERE UserName='%s' AND PassWord='%s';", tableName, userName, password);
            ResultSet results = stmt.executeQuery(sql);
    
            if (results.next()) {
                String retrievedUserName = results.getString("UserName");
                String retrievedFirstName = results.getString("FisrtName");
                String retrievedLastName = results.getString("LastName");
                String retrievedPosition= results.getString("Position");
                Date retrievedBirthDate = results.getDate("BirthDate");
                String retrievedEmail = results.getString("Email");
                String retrievedPassWord = results.getString("PassWord");
                String retrievedType = results.getString("Type");
                commonVariables.Type userType;
                if(retrievedType.equals(new String("Regular"))) {
                    userType = commonVariables.Type.Regular;
                } else {
                    userType = commonVariables.Type.Admin;
                }
                String retrievedMaritalStatus = results.getString("MaritalStatus");
                commonVariables.MaritalStatus userMaritalStatus;
               
                switch (retrievedMaritalStatus) {
                    case "Single":
                        userMaritalStatus = commonVariables.MaritalStatus.Single;
                     
                    case "Married":
                        userMaritalStatus = commonVariables.MaritalStatus.Married;
                    case "Widowed":
                        userMaritalStatus = commonVariables.MaritalStatus.widowed;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                
                // Acesse outros valores conforme necessário

                // Crie e retorne um objeto User com os valores obtidos
                
//                String userName, String firstName,String lastName, String password, Date bithDate,String position,commonVariables.Type userType, String email,commonVariables.MaritalStatus userMaritalStatus;
                return new User( retrievedUserName, 
                 retrievedFirstName,
                 retrievedLastName,  retrievedPassWord, 
                 retrievedBirthDate, retrievedPosition, 
                 userType, retrievedEmail,
                 userMaritalStatus);
            }   
               
               
           
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }              
    }

   
}
