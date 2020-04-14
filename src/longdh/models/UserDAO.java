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
import longdh.dtos.BillDTO;
import longdh.dtos.BookDTO;
import longdh.dtos.CartDTO;
import longdh.dtos.DiscountCodeDTO;
import longdh.dtos.HistoryDetailDTO;

/**
 *
 * @author donglong
 */
public class UserDAO implements Serializable {

    public UserDAO() {

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

    public String checklogIn(String userID, String pass) {
        String role = "Failed";
        String sql = "Select role from Users where UserName = ? and Password = ? and Status = 'active'";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
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

    public ArrayList<Integer> getUserIDbyUserNames(String userName) {
        ArrayList list = new ArrayList<>();
        try {
            String sql = "Select UserID from Users where UserName like ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + userName + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("UserID");
                int userID = Integer.parseInt(userid);
                list.add(userID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public String getUserIDbyUserName(String userName) {
        String results = null;
        ArrayList list = new ArrayList<>();
        try {
            String sql = "Select UserID from Users where UserName like ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + userName + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("UserID");
                int userID = Integer.parseInt(userid);
                list.add(userID);
                for (int i = 0; i < list.size(); i++) {
                    int result = i;
                    results = Integer.toString(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return results;
    }

    public boolean addBookToCarts(CartDTO book, String userID) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into Cart Values (?, ?, ?, ?, ?, ?, ?)";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookId());
            pst.setString(2, book.getBookTitle());
            pst.setString(3, "1");
            pst.setString(4, Float.toString(book.getPrice()));
            pst.setString(5, userID);
            pst.setString(6, "active");
            pst.setString(7, book.getNumBill());

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }


    public List<CartDTO> getInCartByID(String userID) {
        List<CartDTO> list = new ArrayList<>();
        String sql = " Select UserID ,BookID, BookTitle, Quantity, Price, NumBill from  Cart  where  UserID = ? and Status = ? ";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float quantity = Float.parseFloat(rs.getString("Quantity"));
                float price = Float.parseFloat(rs.getString("Price"));

                list.add(new CartDTO(bookid, booktitle, quantity, price));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CartDTO> getInCartByIDs(String userID, String numbill) {
        List<CartDTO> list = new ArrayList<>();
        String sql = " Select UserID ,BookID, BookTitle, Quantity, Price, NumBill from  Cart  where  UserID = ? and Status = ? and NumBill = ?";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, "inactive");
            pst.setString(3, numbill);
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float quantity = Float.parseFloat(rs.getString("Quantity"));
                float price = Float.parseFloat(rs.getString("Price"));
                String Numbill = rs.getString("NumBill");
                list.add(new CartDTO(bookid, booktitle, userID, quantity, price, Numbill));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CartDTO> getInCart() {
        List<CartDTO> list = new ArrayList<>();
        String sql = "Select BookID, BookTitle, Quantity , Price from Cart ";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float quantity = Float.parseFloat(rs.getString("Quantity"));
                float price = Float.parseFloat(rs.getString("Price"));

                list.add(new CartDTO(bookid, booktitle, quantity, price));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean deleteBookFromCart(CartDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "Delete From Cart  Where BookID=?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, dto.getBookId());

            result = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteBookFromCarts(CartDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "update Cart set Status =?  Where BookID=?";
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

    public boolean updateBookFromCart(CartDTO dto, String quantity) throws Exception {
        boolean result = false;
        try {
            String sql = "Update Cart " + " Set Quantity= ? " + " Where BookID=? and Status = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, quantity);
            pst.setString(2, dto.getBookId());
            pst.setString(3, "active");

            result = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public CartDTO getBookByID(String BookID) throws Exception {
        CartDTO result = null;
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity from Cart where BookID= ? and Status = ? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, BookID);
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                float quantity = rs.getFloat("Quantity");

                result = new CartDTO(bookid, booktitle, quantity, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public CartDTO getBookByIDs(String userID, String BookID) throws Exception {
        CartDTO result = null;
        try {
            String sql = "Select BookID, BookTitle, Price , Quantity from Cart where BookID= ? and Status = ? and UserID = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, BookID);
            pst.setString(2, "active");
            pst.setString(3, userID);
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float price = rs.getFloat("Price");
                float quantity = rs.getFloat("Quantity");

                result = new CartDTO(bookid, booktitle, quantity, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<DiscountCodeDTO> getDiscountByID(String userID) {
        List<DiscountCodeDTO> list = new ArrayList<>();
        String sql = "Select DiscountCode, DiscountValue, ExpiredDate , UserID, Status from Discounts where UserID = ? and Status = ?";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, "notUse");
            rs = pst.executeQuery();
            while (rs.next()) {
                String discountcode = rs.getString("DiscountCode");
                String discountvalue = rs.getString("DiscountValue");
                String exprireddate = rs.getString("ExpiredDate");
                String userId = rs.getString("UserID");
                String status = rs.getString("Status");

                list.add(new DiscountCodeDTO(discountcode, discountvalue, exprireddate, userId, status));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public DiscountCodeDTO getDiscountCode(String DiscountCode) throws Exception {
        DiscountCodeDTO result = null;
        try {
            String sql = "Select DiscountCode, DiscountValue, ExpiredDate , UserID, Status from Discounts where DiscountCode = ? and Status = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, DiscountCode);
            pst.setString(2, "notUse");
            rs = pst.executeQuery();
            while (rs.next()) {
                String discountcode = rs.getString("DiscountCode");
                String discountvalue = rs.getString("DiscountValue");
                String exprireddate = rs.getString("ExpiredDate");
                String userId = rs.getString("UserID");
                String status = rs.getString("Status");

                result = new DiscountCodeDTO(discountcode, discountvalue, exprireddate, userId, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<Integer> getPersentByDiscountCode(String discountCode, String userId) {
        ArrayList list = new ArrayList<>();
        try {
            String sql = "Select DiscountValue from Discounts where DiscountCode like ? and UserID = ? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + discountCode + "%");
            pst.setString(2, userId);
            rs = pst.executeQuery();

            while (rs.next()) {
                String persent = rs.getString("DiscountValue");
                int Persent = Integer.parseInt(persent);
                list.add(Persent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<Integer> getDiscountByDiscountName(String discountName, String userId) {
        ArrayList list = new ArrayList<>();
        try {
            String sql = "Select DiscountCode from Discounts where DiscountCode like ? and UserID = ? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + discountName + "%");
            pst.setString(2, userId);
            rs = pst.executeQuery();

            while (rs.next()) {
                String disName = rs.getString("DiscountCode");
                int Persent = Integer.parseInt(disName);
                list.add(Persent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean deleteDiscountByPersent(String persent, String userId) throws Exception {
        boolean result = false;
        try {
            String sql = "Delete from Discounts where DiscountValue = ? And UserID = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, persent);
            pst.setString(2, userId);

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public BillDTO getBillByID(String BillID) throws Exception {
        BillDTO result = null;
        try {
            String sql = "Select UserID, BillID , Amount, Date , PayerName, AddressUser from Bill where BillID=? ";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, BillID);
            rs = pst.executeQuery();
            while (rs.next()) {
                String userId = rs.getString("UserID");
                String billid = rs.getString("BillID");
                float amount = rs.getFloat("Amount");
                String date = rs.getString("Date");
                String payer = rs.getString("PayerName");
                String address = rs.getString("AddressUser");
                result = new BillDTO(userId, billid, date, payer, address, amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    // làm cái history Info dddddddđyyyyyyyyyyyyyyyyyyy
    public boolean addHistoryInfo(HistoryDetailDTO historyDetail, String billid) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into HistoryDetail Values (?, ?, ?, ?, ?, ?)";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, billid);
            pst.setString(2, historyDetail.getBookId());
            pst.setString(3, historyDetail.getBookTitle());
            pst.setString(4, Float.toString(historyDetail.getQuantity()));
            pst.setString(5, Float.toString(historyDetail.getPrice()));
            pst.setString(6, "done");

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<HistoryDetailDTO> getHisByID(String billID) {
        List<HistoryDetailDTO> list = new ArrayList<>();
        String sql = " Select BookID, BookTitle, Quantity, Price from  HistoryDetail  where BillID = ? and Status = ? ";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, billID);
            pst.setString(2, "done");
            rs = pst.executeQuery();
            while (rs.next()) {
                String bookid = rs.getString("BookID");
                String booktitle = rs.getString("BookTitle");
                float quantity = rs.getFloat("Quantity");
                float price = rs.getFloat("Price");

                list.add(new HistoryDetailDTO(bookid, booktitle, quantity, price));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BillDTO> getPayerByName(String payer, String userid) throws Exception {
        List<BillDTO> list = new ArrayList<>();
        try {
            String sql = "Select UserID, BillID, Amount , Date, PayerName from Bill where PayerName like ? and UserID = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + payer + "%");
            pst.setString(2, userid);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Userid = rs.getString("UserID");
                String billid = rs.getString("BillID");
                float amount = rs.getFloat("Amount");
                String date = rs.getString("Date");
                String Payer = rs.getString("PayerName");

                list.add(new BillDTO(Userid, billid, date, Payer, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BillDTO> getPayerByDate(String date, String Userid) throws Exception {
        List<BillDTO> list = new ArrayList<>();
        try {
            String sql = "Select UserID, BillID, Amount , Date, PayerName from Bill where Date like ? and UserID = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + date + "%");
            pst.setString(2, Userid);
            rs = pst.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("UserID");
                String billid = rs.getString("BillID");
                float amount = rs.getFloat("Amount");
                String Date = rs.getString("Date");
                String Payer = rs.getString("PayerName");

                list.add(new BillDTO(userid, billid, Date, Payer, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

}
