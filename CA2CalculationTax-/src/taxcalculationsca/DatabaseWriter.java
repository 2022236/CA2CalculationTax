package taxcalculationsca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import jdk.jpackage.internal.IOUtils;

/**
 *
 * @author lizandra 2022236 and Taciana 2022404
 */

public class DatabaseWriter extends Database {
    
    
    public boolean addUserDatabase(String userName ,String FisrtName, String LastName,String Position, String BirthDate, String Email, String PassWord, String Type) throws SQLException {
        IOUtils scan = new IOUtils ();
        try (
            Connection conn = DriverManager.getConnection(db_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ) {
            String sql = String.format("INSERT INTO " + tableName + " (userName, FisrtName, LastName,Position, BirthDate, Email, PassWord, Type) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
        FisrtName, LastName,Position, BirthDate, Email, PassWord, Type);

            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
    }
    
    
    
}
    