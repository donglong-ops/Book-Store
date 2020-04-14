/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author donglong
 */
public class DiscountCodeDTO implements Serializable {

    String DiscountCode, DiscountValue, ExpiredDate, UserID, Status;

    public Vector toVector() {
        Vector v = new Vector();
        v.add(DiscountCode);
        v.add(DiscountValue);
        v.add(ExpiredDate);
        return v;
    }

    public DiscountCodeDTO(String DiscountCode, String UserID) {
        this.DiscountCode = DiscountCode;
        this.UserID = UserID;
    }

    public DiscountCodeDTO(String DiscountCode, String DiscountValue, String ExpiredDate, String UserID, String Status) {
        this.DiscountCode = DiscountCode;
        this.DiscountValue = DiscountValue;
        this.ExpiredDate = ExpiredDate;
        this.UserID = UserID;
        this.Status = Status;
    }

    public String getDiscountCode() {
        return DiscountCode;
    }

    public void setDiscountCode(String DiscountCode) {
        this.DiscountCode = DiscountCode;
    }

    public String getDiscountValue() {
        return DiscountValue;
    }

    public void setDiscountValue(String DiscountValue) {
        this.DiscountValue = DiscountValue;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(String ExpiredDate) {
        this.ExpiredDate = ExpiredDate;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
