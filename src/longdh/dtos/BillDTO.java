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
public class BillDTO implements Serializable {

    String userID, billID, date, payrer, addressPayer;
    float totalAmount;

    public BillDTO() {

    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(billID);
        v.add(payrer);
        v.add(totalAmount);
        v.add(date);

        return v;
    }

    public BillDTO(String userID, String billID, String date, String payrer, String addressPayer, float totalAmount) {
        this.userID = userID;
        this.billID = billID;
        this.date = date;
        this.payrer = payrer;
        this.addressPayer = addressPayer;
        this.totalAmount = totalAmount;
    }

    public BillDTO(String userID, String billID, String date, String payrer, float totalAmount) {
        this.userID = userID;
        this.billID = billID;
        this.date = date;
        this.payrer = payrer;
        this.totalAmount = totalAmount;
    }

    public BillDTO(String userID, String billID, String date, float totalAmount, String payrer) {
        this.userID = userID;
        this.billID = billID;
        this.date = date;
        this.payrer = payrer;
        this.totalAmount = totalAmount;
    }

    public BillDTO(String billID) {
        this.billID = billID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayrer() {
        return payrer;
    }

    public void setPayrer(String payrer) {
        this.payrer = payrer;
    }

    public String getAddressPayer() {
        return addressPayer;
    }

    public void setAddressPayer(String addressPayer) {
        this.addressPayer = addressPayer;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
