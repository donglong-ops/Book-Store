/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import longdh.connect.DBconnect;
import longdh.dtos.BookDTO;
import longdh.dtos.DiscountCodeDTO;
import longdh.dtos.UserDTO;

public class AdminDAO implements Serializable {

    public AdminDAO() {

    }
    Connection conn;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<BookDTO> getBook() {
        List<BookDTO> list = new ArrayList<>();
        String sql = "Select BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status from Books where Status=? ";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                list.add(new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, date, price));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public BookDTO getBookByID(String BookID) throws Exception {
        BookDTO result = null;
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status from Books where BookID=? and Status=? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, BookID);
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) { //sửa
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                result = new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, "active", price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertBook(BookDTO book) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into Books Values (?, ?, ? ,? ,? ,? ,? , ? , ?)";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookId());
            pst.setString(2, book.getBookTitle());
            pst.setString(3, Double.toString(book.getPrice()));
            pst.setString(4, book.getQuantity());
            pst.setString(5, book.getAuthor());
            pst.setString(6, book.getCategories());
            pst.setString(7, book.getImageName());
            pst.setString(8, book.getDate());
            pst.setString(9, book.getStatus());
            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteBook(BookDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "Update Books " + "Set Status=?" + " Where BookID=?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "inactive");
            pst.setString(2, dto.getBookId());

            result = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateBook(BookDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "Update Books " + "Set BookTitle=? ,Price=?, Quantity=?, Author=? , Categories=? , ImageName=?, Date=?" + " Where BookID=?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, dto.getBookTitle());
            pst.setString(2, Double.toString(dto.getPrice()));
            pst.setString(3, dto.getQuantity());
            pst.setString(4, dto.getAuthor());
            pst.setString(5, dto.getCategories());
            pst.setString(6, dto.getImageName());
            pst.setString(7, dto.getDate());
            pst.setString(8, dto.getBookId());

            result = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> getBookByName(String bookTitle) throws Exception {
        List<BookDTO> list = new ArrayList<>();
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status from Books where BookTitle like ? and Status=? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + bookTitle + "%");
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                list.add(new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, "active", price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookDTO> getBookByMoney(String range) throws Exception {
        List<BookDTO> list = new ArrayList<>();
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status from Books where Status=? and Price <= ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "active");
            pst.setString(2, range);
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float Price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                list.add(new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, "active", Price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookDTO> getBookByCategory(String category) throws Exception {
        List<BookDTO> list = new ArrayList<>();
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status from Books where Status=? and Categories like ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "active");
            pst.setString(2, "%" + category + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float Price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                list.add(new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, "active", Price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addUser(UserDTO user) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into Users Values (?, ?, ? ,? ,? ,? ,? ,? )";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUserID());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getPassWord());
            pst.setString(4, String.valueOf(user.getPhone()));
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getEmail());
            pst.setString(7, user.getRole());
            pst.setString(8, user.getStatus());

            result = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public UserDTO getUserByID(String userID) throws Exception {
        UserDTO result = null;
        try {
            String sql = "Select UserID, UserName, Phone , Address , Email, Role, Status from Users where UserID= ? and Status = ? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("UserID");
                String username = rs.getString("UserName");
                int phone = rs.getInt("Phone");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                String role = rs.getString("Role");
                String status = rs.getString("Status");

                result = new UserDTO(userid, username, "1", address, email, role, status, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean addDiscount(DiscountCodeDTO discount) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into Discounts Values (?, ?, ? ,? ,? )";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, discount.getDiscountCode());
            pst.setString(2, discount.getDiscountValue());
            pst.setString(3, discount.getExpiredDate());
            pst.setString(4, discount.getUserID());
            pst.setString(5, discount.getStatus());

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public DiscountCodeDTO getDisCountByID(String userID, String discountCode) throws Exception {
        DiscountCodeDTO result = null;
        try {
            String sql = "Select DiscountCode, UserID from Discounts where UserID = ? and DiscountCode= ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, discountCode);
            rs = pst.executeQuery();
            while (rs.next()) {
                String DiscountCode = rs.getString("DiscountCode");
                String UserID = rs.getString("UserID");

                result = new DiscountCodeDTO(DiscountCode, UserID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> getBookNotBuy(String datecheck) {
        List<BookDTO> list = new ArrayList<>();
        String sql = "select  BookID, BookTitle, Price , Quantity, Author, Categories, ImageName, Date, Status \n" +
                        "from Books "
                        + "where Status='active' and  Date not in (select date from Bill where  date = ?) ";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, datecheck);
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                String quantity = rs.getString("Quantity");
                String author = rs.getString("Author");
                String categories = rs.getString("Categories");
                String date = rs.getString("Date");
                String imagename = rs.getString("ImageName");

                list.add(new BookDTO(bookid, booktitle, quantity, author, categories, imagename, date, date, price));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }
}
