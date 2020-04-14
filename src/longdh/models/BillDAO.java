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
import longdh.connect.DBconnect;
import longdh.dtos.BillDTO;

/**
 *
 * @author donglong
 */
public class BillDAO implements Serializable {

    public BillDAO() {

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

    public List<BillDTO> getHistoryInBill(String userID) {
        List<BillDTO> list = new ArrayList<>();
        String sql = "Select UserID,PayerName, BillID ,Amount , Date from Bill where UserID = ?";
        try {
            pst = DBconnect.openConnect().prepareStatement(sql);
            pst.setString(1, userID);
            rs = pst.executeQuery();
            while (rs.next()) {
                String billid = rs.getString("BillID");
                float amount = Float.parseFloat(rs.getString("Amount"));
                String date = rs.getString("Date");
                String payer = rs.getString("PayerName");

                list.add(new BillDTO(userID, billid, date, payer, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<Integer> getTotalAmountByUserID(String userID) {
        ArrayList list = new ArrayList<>();
        try {
            String sql = " Select UserID, SUM(Quantity * Price) as Total  from Cart where UserID = ? and Status = ? Group By UserID";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, "active");
            rs = pst.executeQuery();
            while (rs.next()) {
                String totalAmount = rs.getString("Total");
                float TotalAmount = Float.parseFloat(totalAmount);
                list.add(TotalAmount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean addToHistory(BillDTO history, String userID) throws Exception {
        boolean result = false;
        try {
            String sql = "Insert into Bill Values (?, ?, ?, ? , ? , ?)";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, history.getBillID());
            pst.setString(3, Float.toString(history.getTotalAmount()));
            pst.setString(4, history.getDate());
            pst.setString(5, history.getPayrer());
            pst.setString(6, history.getAddressPayer());

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteBookInCart(String UserID) throws Exception {
        boolean result = false;
        try {
            String sql = "Delete from Cart where UserID = ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, UserID);

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteBookInCarts(String UserID) throws Exception {
        boolean result = false;
        try {
            String sql = "Update Cart Set Status=?  Where UserID=?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "inactive");
            pst.setString(2, UserID);

            result = pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BillDTO> getHisByName(String namePayer) throws Exception {
        List<BillDTO> list = new ArrayList<>();
        try {
            String sql = "Select UserID, BillID, PayerName, Amount,Date from Bill where PayerName like ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + namePayer + "%");
            rs = pst.executeQuery();
            if (rs.next()) {
                String userid = rs.getString("UserID");
                String billid = rs.getString("BillID");
                String payername = rs.getString("PayerName");
                float amount = rs.getFloat("Amount");
                String date = rs.getString("Date");

                list.add(new BillDTO(userid, billid, date, amount, payername));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BillDTO> getHisByDate(String date) throws Exception {
        List<BillDTO> list = new ArrayList<>();
        try {
            String sql = "Select UserID, BillID, PayerName, Amount,Date from Bill where Date like ?";
            conn = DBconnect.openConnect();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + date + "%");
            rs = pst.executeQuery();
            if (rs.next()) {
                String userid = rs.getString("UserID");
                String billid = rs.getString("BillID");
                String payername = rs.getString("PayerName");
                float amount = rs.getFloat("Amount");
                String Date = rs.getString("Date");

                list.add(new BillDTO(userid, billid, Date, amount, payername));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
}
