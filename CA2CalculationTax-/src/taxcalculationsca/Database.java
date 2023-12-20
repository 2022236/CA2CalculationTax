/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculationsca;

/**
 *
 * @author lizandra 2022236 and Taciana 2022404
 */


public abstract class Database {
   protected final static String dbBaseURL = "jdbc:mysql://localhost";
   protected final static String USER = "OOC2023";
   protected final static String PASSWORD = "ooc2023";
   protected final static String dbName = "mydb";
   protected final static String tableName = "User";
   protected final static String db_URL = dbBaseURL + "/" + dbName;
   
   
}
