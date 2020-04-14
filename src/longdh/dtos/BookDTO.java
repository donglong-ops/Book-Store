package longdh.dtos;

import java.io.Serializable;
import java.util.Vector;

public class BookDTO implements Serializable {

    String BookId, BookTitle, Quantity, Author, Categories, ImageName, Date, Status;
    float Price;

    public BookDTO() {

    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(BookId);
        v.add(BookTitle);
        v.add(Author);
        v.add(Price);
        v.add(Quantity);
        return v;
    }

    public BookDTO(String BookId, String BookTitle, String Quantity, String Author, String Categories, String ImageName, String Date, String Status, float Price) {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.Quantity = Quantity;
        this.Author = Author;
        this.Categories = Categories;
        this.ImageName = ImageName;
        this.Date = Date;
        this.Status = Status;
        this.Price = Price;
    }
        public BookDTO(String BookId, String BookTitle, String Quantity, String Author,  String ImageName, String Date, String Status, float Price) {
        this.BookId = BookId;
        this.BookTitle = BookTitle;
        this.Quantity = Quantity;
        this.Author = Author;
        this.ImageName = ImageName;
        this.Date = Date;
        this.Status = Status;
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

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCategories() {
        return Categories;
    }

    public void setCategories(String Categories) {
        this.Categories = Categories;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

}
