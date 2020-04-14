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
public class HistoryDetailDTO implements Serializable {

    String billCode, bookId, bookTitle;
    float quantity, price;

    public Vector toVector() {
        Vector v = new Vector();
        v.add(bookId);
        v.add(bookTitle);
        v.add(quantity);
        v.add(price);
        return v;
    }

    public HistoryDetailDTO() {

    }

    public HistoryDetailDTO(String billCode, String bookId, String bookTitle, float quantity, float price) {
        this.billCode = billCode;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.price = price;
    }
    public HistoryDetailDTO(String bookId, String bookTitle, float quantity, float price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.price = price;
    }
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
