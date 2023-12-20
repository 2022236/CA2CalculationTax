package taxcalculationsca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                String userRole = results.getString("role");
                return new User(userName, password, userRole);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }              
    }

   
}
