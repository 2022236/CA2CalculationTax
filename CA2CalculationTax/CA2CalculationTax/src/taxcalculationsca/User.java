/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculationsca;
import java.util.Date;

/**
 *
 * @author lizandra 2022236 and Taciana 2022404
 */

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String position;
    private Date bithDate;
    private String email;
    
    
    private commonVariables.Type typeUser;
    private commonVariables.MaritalStatus userMaritalStatus;
    

    public User(String userName, String firstName,String lastName, String password, Date bithDate,String position,commonVariables.Type userType, String email,commonVariables.MaritalStatus userMaritalStatus) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.bithDate  = bithDate;
        this.email = email;
        this.password = password;
        this.typeUser = userType;
        this.userMaritalStatus = userMaritalStatus;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public Date getBithDate() {
        return bithDate;
    }

    public String getEmail() {
        return email;
    }

    public commonVariables.Type getTypeUser() {
        return typeUser;
    }

    public commonVariables.MaritalStatus getUserMaritalStatus() {
        return userMaritalStatus;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTypeUser(commonVariables.Type typeUser) {
        this.typeUser = typeUser;
    }

    public void setUserMaritalStatus(commonVariables.MaritalStatus userMaritalStatus) {
        this.userMaritalStatus = userMaritalStatus;
    }

    
}
