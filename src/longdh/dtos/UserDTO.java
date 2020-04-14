/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.dtos;

import java.io.Serializable;

/**
 *
 * @author donglong
 */
public class UserDTO implements Serializable {

    String UserID, UserName, PassWord, Address, Email, Role, Status;
    int phone;

    public UserDTO(String UserID, String UserName, String PassWord, String Address, String Email, String Role, String Status, int phone) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.Address = Address;
        this.Email = Email;
        this.Role = Role;
        this.Status = Status;
        this.phone = phone;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
