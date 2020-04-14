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
public class CartDTO implements Serializable {

    String BookId, BookTitle, UserID;
    float quantity, Price;
    String numBill;

    public CartDTO() {

    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(BookId);
        v.add(BookTitle);
        v.add(quantity);
        v.add(Price);
        v.add(UserID);
        return v;
    }

    public CartDTO(String BookId, String BookTitle, String UserID, float quantity, float Price, String numBill) {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.UserID = UserID;
        this.quantity = quantity;
        this.Price = Price;
        this.numBill = numBill;
    }

    public CartDTO(String BookId, String BookTitle, String UserID, float quantity, float Price) {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.UserID = UserID;
        this.quantity = quantity;
        this.Price = Price;
    }

    public CartDTO(String BookId, String BookTitle, float quantity, float Price) {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.quantity = quantity;
        this.Price = Price;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String BookId) {
        this.BookId = BookId;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getNumBill() {
        return numBill;
    }

    public void setNumBill(String numBill) {
        this.numBill = numBill;
    }

}
