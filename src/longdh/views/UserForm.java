package longdh.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import longdh.dtos.BillDTO;
import longdh.dtos.BookDTO;
import longdh.dtos.CartDTO;
import longdh.dtos.DiscountCodeDTO;
import longdh.dtos.HistoryDetailDTO;
import longdh.dtos.UserDTO;
import longdh.models.AdminDAO;
import longdh.models.BillDAO;
import longdh.models.UserDAO;

public class UserForm extends javax.swing.JFrame {

    DefaultTableModel tblViewBook = null;
    DefaultTableModel tblViewCart = null;
    DefaultTableModel tblViewBill = null;
    DefaultTableModel tblViewHistory = null;
    DefaultTableModel tblViewUserDiscount = null;
    DefaultTableModel tblViewHistoryDetail = null;
    AdminDAO adminDAO = new AdminDAO();
    UserDAO userDAO = new UserDAO();
    BillDAO billDAO = new BillDAO();
    int number = 4;

    public UserForm() {
        initComponents();
        showDataBook();
        showDataCart();
        showDataBill();
        btnAddToCart.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnApply.setEnabled(false);
        btnDeleteByUser.setEnabled(false);
        btnUpdateQuatity.setEnabled(false);
        txtTEssss.setEditable(false);
        btnSearchHisByName.setEnabled(false);
        btnSearchHisByDate.setEnabled(false);
        txtBillCode.setEditable(false);
    }

    public UserForm(String userName) {
        initComponents();
        lblWelcome.setText(userName.toUpperCase());
        showDataBook();
        showDataCart();
        showDataBill();
        showDataHistory();
        showDataDiscount();
        txtTotalAmount.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnSubmit.setEnabled(false);
        txtTEssss.setEditable(false);
        btnApply.setEnabled(false);
        btnSearchHisByName.setEnabled(false);
        btnSearchHisByDate.setEnabled(false);
        txtDiscountCode.setEditable(false);
        btnDeleteByUser.setEnabled(false);
        btnUpdateQuatity.setEnabled(false);
        txtBillCode.setEditable(false);
    }

    public void showDataBook() {
        List<BookDTO> listBook = userDAO.getBook();
        tblViewBook = (DefaultTableModel) tblBook.getModel();
        while (tblViewBook.getRowCount() > 0) {
            tblViewBook.removeRow(0);
        }
        for (BookDTO bookDTO : listBook) {
            tblViewBook.addRow(bookDTO.toVector());
        }
    }

    public void showDataCart() {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        List<CartDTO> listInCart = userDAO.getInCartByID(userID);
        tblViewCart = (DefaultTableModel) tblCart.getModel();
        while (tblViewCart.getRowCount() > 0) {
            tblViewCart.removeRow(0);
        }
        for (CartDTO cartDTO : listInCart) {
            tblViewCart.addRow(cartDTO.toVector());
        }
    }

    public void showDataBill() {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        List<CartDTO> listInCart = userDAO.getInCartByID(userID);
        tblViewBill = (DefaultTableModel) tblBill.getModel();
        while (tblViewBill.getRowCount() > 0) {
            tblViewBill.removeRow(0);
        }
        for (CartDTO cartDTO : listInCart) {
            tblViewBill.addRow(cartDTO.toVector());
        }
        txtTotalAmount.setText(totalAmount());
    }

    public void showDataHistory() {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        List<BillDTO> listInHistory = billDAO.getHistoryInBill(userID);
        tblViewHistory = (DefaultTableModel) tblBillHistory.getModel();
        while (tblViewHistory.getRowCount() > 0) {
            tblViewHistory.removeRow(0);
        }
        for (BillDTO billDTO : listInHistory) {
            tblViewHistory.addRow(billDTO.toVector());
        }

    }

    public void showDataDiscount() {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        List<DiscountCodeDTO> listDiscountUserID = userDAO.getDiscountByID(userID);
        tblViewUserDiscount = (DefaultTableModel) tblUserDiscount.getModel();
        while (tblViewUserDiscount.getRowCount() > 0) {
            tblViewUserDiscount.removeRow(0);
        }
        for (DiscountCodeDTO discountDTO : listDiscountUserID) {
            tblViewUserDiscount.addRow(discountDTO.toVector());
        }

    }

    public String totalAmount() {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        ArrayList total = billDAO.getTotalAmountByUserID(userID);
        String TotalAmountByUserID = null;
        for (Object totalAmount : total) {
            TotalAmountByUserID = totalAmount.toString();
        }
        return TotalAmountByUserID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnSearchByCategory = new javax.swing.JButton();
        btnSearchByMoney = new javax.swing.JButton();
        btnSearchByName = new javax.swing.JButton();
        txtSearchByName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtCategories = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        lblHi = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBookID1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBookTitle1 = new javax.swing.JTextField();
        txtPrice1 = new javax.swing.JTextField();
        txtQuantity1 = new javax.swing.JTextField();
        btnDeleteByUser = new javax.swing.JButton();
        btnUpdateQuatity = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDiscountCode = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblUserDiscount = new javax.swing.JTable();
        txtTEssss = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBillHistory = new javax.swing.JTable();
        txtSearchHistoryByName = new javax.swing.JTextField();
        btnSearchHisByName = new javax.swing.JButton();
        txtSearchHistoryByDate = new javax.swing.JTextField();
        btnSearchHisByDate = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHistoryDetail = new javax.swing.JTable();
        txtBillCode = new javax.swing.JTextField();
        cbxSearchCategory = new javax.swing.JComboBox();
        cbxRangeMoney = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblWelcome.setText(".");

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BookID", "Book Title", "Author", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnSearchByCategory.setText("Search By Category");
        btnSearchByCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByCategoryActionPerformed(evt);
            }
        });

        btnSearchByMoney.setText("Search Range Money");
        btnSearchByMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByMoneyActionPerformed(evt);
            }
        });

        btnSearchByName.setText("Search Name");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));

        jLabel1.setText("BookID");

        jLabel2.setText("BookTitle");

        txtBookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBookIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookIDKeyReleased(evt);
            }
        });

        jLabel3.setText("Price (VND)");

        jLabel4.setText("Quantity");

        jLabel5.setText("Author");

        jLabel6.setText("Categories");

        jLabel7.setText("DateImport");

        txtBookTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookTitleKeyReleased(evt);
            }
        });

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });

        txtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAuthorKeyReleased(evt);
            }
        });

        txtCategories.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoriesKeyReleased(evt);
            }
        });

        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDateKeyReleased(evt);
            }
        });

        jLabel8.setText("ImageName");

        txtImage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImageKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(txtCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtPrice)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBookID, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtBookTitle)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtImage))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnClear.setText("Clear and Reload");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblHi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHi.setForeground(new java.awt.Color(255, 0, 0));
        lblHi.setText("WELCOME TO BOOK STORE, ");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BookID", "Book Title", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCart);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));

        jLabel9.setText("BookID");

        jLabel10.setText("BookTitle");

        jLabel11.setText("Price");

        jLabel12.setText("Quantity");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantity1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtPrice1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBookID1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtBookTitle1))))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBookID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBookTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeleteByUser.setText("Delete");
        btnDeleteByUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteByUserActionPerformed(evt);
            }
        });

        btnUpdateQuatity.setText("Update Quantity");
        btnUpdateQuatity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQuatityActionPerformed(evt);
            }
        });

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jButton2.setText("History");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnDeleteByUser, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateQuatity, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteByUser)
                    .addComponent(btnUpdateQuatity)
                    .addComponent(btnPay)
                    .addComponent(jButton2))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Your Cart", jPanel3);

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BookID", "Book Title", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBill);

        txtTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAmountActionPerformed(evt);
            }
        });
        txtTotalAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalAmountKeyReleased(evt);
            }
        });

        jLabel13.setText("Total Amount");

        txtDiscountCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountCodeKeyReleased(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Way To Pay"));

        jLabel15.setText("Full Name");

        txtFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFullNameKeyReleased(evt);
            }
        });

        jLabel16.setText("Your Address");

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        jLabel17.setText("Phone");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jButton3.setText("History");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(35, 35, 35)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap())))
        );

        tblUserDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Discount Code", "Discount Persent", "Expired Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserDiscountMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblUserDiscount);

        txtTEssss.setText("------------(VND)------------");

        jLabel14.setText("Your Discount Code");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtDiscountCode, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTEssss)))))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTEssss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscountCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApply)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Pay", jPanel4);

        tblBillHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BillCode", "Payer Name", "TotalAmount", "Date Bought"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBillHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillHistoryMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblBillHistory);

        txtSearchHistoryByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHistoryByNameKeyReleased(evt);
            }
        });

        btnSearchHisByName.setText("Search By Name");
        btnSearchHisByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHisByNameActionPerformed(evt);
            }
        });

        txtSearchHistoryByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchHistoryByDateActionPerformed(evt);
            }
        });
        txtSearchHistoryByDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHistoryByDateKeyReleased(evt);
            }
        });

        btnSearchHisByDate.setText("Search By Date");
        btnSearchHisByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHisByDateActionPerformed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        tblHistoryDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BookID", "Book Title", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHistoryDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryDetailMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHistoryDetail);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtSearchHistoryByName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchHisByName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReload)
                .addGap(27, 27, 27))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(txtBillCode, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearchHistoryByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchHisByDate))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchHistoryByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHisByName)
                    .addComponent(btnReload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchHisByDate)
                    .addComponent(txtSearchHistoryByDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBillCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tabbedPane.addTab("History", jPanel8);

        cbxSearchCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choice One Category", "Politics - law", "Art science", "Economics", "Socio-cultural", "Literature", "Education", "Psychological, religious", "Learning", "LoveStory", "Travel", "Experience", "LifeStory" }));

        cbxRangeMoney.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choice Range Money", "<= 50k   VND", "<= 150k  VND", "<= 250k  VND", "<= 300k  VND", "<= 400k  VND", "<= 500k  VND" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(lblHi)
                        .addGap(18, 18, 18)
                        .addComponent(lblWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxSearchCategory, 0, 145, Short.MAX_VALUE)
                                            .addComponent(cbxRangeMoney, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSearchByMoney))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(btnSearchByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(lblHi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchByName))
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSearchByCategory)
                                    .addComponent(cbxSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSearchByMoney)
                                    .addComponent(btnClear)
                                    .addComponent(btnAddToCart)
                                    .addComponent(cbxRangeMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(tabbedPane)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int r = JOptionPane.showConfirmDialog(this, "Are you sure to LogOut ?", "LogOut ?", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnSearchByCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByCategoryActionPerformed

        String category = null;
        int selectPersent = cbxSearchCategory.getSelectedIndex();
        switch (selectPersent) {
            case 1:
                category = "Politics - law";
                break;
            case 2:
                category = "Art science";
                break;
            case 3:
                category = "Economics";
                break;
            case 4:
                category = "Socio-cultural";
                break;
            case 5:
                category = "Literature";
                break;
            case 6:
                category = "Education";
                break;
            case 7:
                category = "Psychological, religious";
                break;
            case 8:
                category = "Learning";
                break;
            case 9:
                category = "LoveStory";
                break;
            case 10:
                category = "Travel";
                break;
            case 11:
                category = "Experience";
                break;
            case 12:
                category = "LifeStory";
                break;
        }
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        List<BookDTO> listBookFindByCategory = null;
        try {
            listBookFindByCategory = adminDAO.getBookByCategory(category);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (BookDTO dto : listBookFindByCategory) {
            model.addRow(dto.toVector());
        }
        tblBook.updateUI();
    }//GEN-LAST:event_btnSearchByCategoryActionPerformed

    private void btnSearchByMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByMoneyActionPerformed

        String rangeMoney = null;
        int selectPersent = cbxRangeMoney.getSelectedIndex();
        switch (selectPersent) {
            case 1:
                rangeMoney = "50000";
                break;
            case 2:
                rangeMoney = "150000";
                break;
            case 3:
                rangeMoney = "250000";
                break;
            case 4:
                rangeMoney = "300000";
                break;
            case 5:
                rangeMoney = "400000";
                break;
            case 6:
                rangeMoney = "500000";
                break;
        }
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        List<BookDTO> listBookFindByMoney = null;
        try {
            listBookFindByMoney = adminDAO.getBookByMoney(rangeMoney);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (BookDTO dto : listBookFindByMoney) {
            model.addRow(dto.toVector());
        }
        tblBook.updateUI();
    }//GEN-LAST:event_btnSearchByMoneyActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        // TODO add your handling code here:
        String search = txtSearchByName.getText().trim();
        if (!search.matches("[A-Za-z, ]{1,30}")) {
            JOptionPane.showMessageDialog(null, "Please Inter Name Of Book and Max Length 30 !!!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        List<BookDTO> listBookFindByName = null;
        try {
            listBookFindByName = adminDAO.getBookByName(search);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (BookDTO dto : listBookFindByName) {
            model.addRow(dto.toVector());
        }
        tblBook.updateUI();
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    public void fullField() {
        if (!txtBookID.getText().isEmpty() && !txtBookTitle.getText().isEmpty() && !txtPrice.getText().isEmpty() && !txtAuthor.getText().isEmpty()
                && !txtCategories.getText().isEmpty() && !txtQuantity.getText().isEmpty() && !txtDate.getText().isEmpty() && !txtImage.getText().isEmpty()) {
            btnAddToCart.setEnabled(true);
        }
    }
    private void txtBookIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookIDKeyPressed
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtBookIDKeyPressed

    private void txtBookIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookIDKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtBookIDKeyReleased

    private void txtBookTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookTitleKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtBookTitleKeyReleased

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtAuthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAuthorKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtAuthorKeyReleased

    private void txtDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtDateKeyReleased

    private void txtImageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImageKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtImageKeyReleased

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        // TODO add your handling code here:
        int row = tblBook.getSelectedRow();
        if (row < 0) {
            return;
        }
        String BookID = (String) tblBook.getValueAt(row, 0);
        BookDTO dto = null;
        try {
            dto = adminDAO.getBookByID(BookID);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtBookID.setText(dto.getBookId());
        txtBookTitle.setText(dto.getBookTitle());
        txtPrice.setText(Double.toString(dto.getPrice()));
        txtQuantity.setText(dto.getQuantity());
        txtAuthor.setText(dto.getAuthor());
        txtCategories.setText(dto.getCategories());
        txtDate.setText(dto.getDate());
        txtImage.setText(dto.getImageName());

        txtBookID.setEditable(false);
        txtBookTitle.setEditable(false);
        txtPrice.setEditable(false);
        txtQuantity.setEditable(false);
        txtAuthor.setEditable(false);
        txtCategories.setEditable(false);
        txtDate.setEditable(false);
        txtImage.setEditable(false);
        btnAddToCart.setEnabled(true);
        btnDeleteByUser.setEnabled(false);
        btnUpdateQuatity.setEnabled(false);
    }//GEN-LAST:event_tblBookMouseClicked

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String bookId = txtBookID.getText();
        String bookTitle = txtBookTitle.getText();
        String price = txtPrice.getText();
        float prices = Float.parseFloat(price);
        String quantity = txtQuantity.getText();
        int quantities = Integer.parseInt(quantity);

        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        try {
            if (userDAO.getBookByIDs(userID, bookId) != null) {
                JOptionPane.showMessageDialog(this, "Book Already In Your Cart.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userID == null) {
            int m = JOptionPane.showConfirmDialog(this, "You Didn't Login Before. Login Now ?", "-------Login------", JOptionPane.YES_NO_OPTION);
            if (m != JOptionPane.YES_OPTION) {
                return;
            } else {
                new LoginForm().setVisible(true);
                this.dispose();
            }
        } else {
            String num = Integer.toString(number);
            CartDTO book = new CartDTO(bookId, bookTitle, userID, quantities, prices, num);
            int n = JOptionPane.showConfirmDialog(this, "Do you want to Add to Your Cart ?", "Add", JOptionPane.YES_NO_OPTION);
            if (n != JOptionPane.YES_OPTION) {
                return;
            }
            boolean check = false;
            try {
                check = userDAO.addBookToCarts(book, userID);
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check) {
                JOptionPane.showMessageDialog(this, "Add Book to Your Cart Success");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Add Book to Your Cart Failed");
            }
            showDataCart();
            tblCart.updateUI();
            showDataBill();
            tblBill.updateUI();
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here
        txtBookID.setText("");
        txtBookTitle.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtAuthor.setText("");
        txtCategories.setText("");
        txtDate.setText("");
        txtImage.setText("");
        txtSearchByName.setText("");
        btnAddToCart.setEnabled(false);
        showDataBook();
        totalAmount();
        showDataCart();
        showDataBill();
        showDataHistory();
        showDataDiscount();
        txtDiscountCode.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        btnApply.setEnabled(false);
        btnDeleteByUser.setEnabled(false);
        btnUpdateQuatity.setEnabled(false);

    }//GEN-LAST:event_btnClearActionPerformed

    public void fullFields() {
        if (!txtFullName.getText().isEmpty() && !txtPhone.getText().isEmpty() && !txtAddress.getText().isEmpty()) {
            btnSubmit.setEnabled(true);
        }
    }
    private void txtCategoriesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriesKeyReleased
        // TODO add your handling code here:
        fullField();
    }//GEN-LAST:event_txtCategoriesKeyReleased

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        showDataHistory();
        showDataDiscount();
        showDataBill();
        showDataBook();
        showDataCart();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnSearchHisByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHisByDateActionPerformed
        // TODO add your handling code here:
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        String search = txtSearchHistoryByDate.getText().trim();
        if (!search.matches("[0-9-/ ]{0,30}")) {
            JOptionPane.showMessageDialog(null, "Please enter Date Buy Of Payer and Max Length 30 !!!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblBillHistory.getModel();
        List<BillDTO> listPayerFindByDate = null;
        try {
            listPayerFindByDate = userDAO.getPayerByDate(search, userID);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (BillDTO dto : listPayerFindByDate) {
            model.addRow(dto.toVector());
        }
        tblBillHistory.updateUI();
    }//GEN-LAST:event_btnSearchHisByDateActionPerformed

    private void txtSearchHistoryByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchHistoryByDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchHistoryByDateActionPerformed

    private void btnSearchHisByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHisByNameActionPerformed
        // TODO add your handling code here:
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        String search = txtSearchHistoryByName.getText().trim();
        if (!search.matches("[A-Za-z, ]{1,30}")) {
            JOptionPane.showMessageDialog(null, "Please enter Name Of Payer and Max Length 30 !!!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblBillHistory.getModel();
        List<BillDTO> listPayerFindByName = null;
        try {
            listPayerFindByName = userDAO.getPayerByName(search, userID);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (BillDTO dto : listPayerFindByName) {
            model.addRow(dto.toVector());
        }
        tblBillHistory.updateUI();

    }//GEN-LAST:event_btnSearchHisByNameActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        LocalDate date = java.time.LocalDate.now();
        String Date = date.toString();
        String payer = txtFullName.getText().trim();
        if (!payer.matches("[A-Za-z/0-9 ]{1,30}")) {
            JOptionPane.showMessageDialog(null, "Name of Payer has Max Length 30 !!!");
            return;
        }
        String address = txtAddress.getText().trim();
        if (!address.matches("[A-Za-z/0-9 ]{1,100}")) {
            JOptionPane.showMessageDialog(null, "Address has Max Length 100 !!!");
            return;
        }
        String phone = txtPhone.getText().trim();
        if (!phone.matches("[0-9.]{1,11}")) {
            JOptionPane.showMessageDialog(null, "Phone must be number and has Max Length 11 !!!");
            return;
        }
        int count = new Random().doubles().hashCode();
        String billId = Integer.toString(count);
        String Total = txtTotalAmount.getText().trim();
        float total = Float.parseFloat(Total);
        BillDTO bill = new BillDTO(userID, billId, Date, payer, address, total);
        try {
            billDAO.addToHistory(bill, userID);
        } catch (Exception ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean check = false;
        try {
            check = billDAO.deleteBookInCarts(userID);
        } catch (Exception ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check) {
            JOptionPane.showMessageDialog(null, "Buy Successed. Please keep Phone and we will contact 2 or 3 days later.");

        } else {
            JOptionPane.showMessageDialog(null, "Buy Failse");
        }
        showDataCart();
        showDataBill();
        showDataHistory();
        txtAddress.setText("");
        txtPhone.setText("");
        txtFullName.setText("");

        ArrayList persent = userDAO.getPersentByDiscountCode(txtDiscountCode.getText().toLowerCase().trim(), userID);
        String Persent = null;
        for (Object list1 : persent) {
            Persent = list1.toString();
        }
        try {
            userDAO.deleteDiscountByPersent(Persent, userID);
        } catch (Exception ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        showDataDiscount();
        txtDiscountCode.setText("");
        addToHistoryDetail(billId);
        number++;
    }//GEN-LAST:event_btnSubmitActionPerformed

    public void addToHistoryDetail(String billCode) {
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        String num = Integer.toString(number);
        List<CartDTO> listInCart = userDAO.getInCartByIDs(userID, num);
        for (CartDTO cartDTO : listInCart) {
            String bookid = cartDTO.getBookId();
            String booktitle = cartDTO.getBookTitle();
            float quantity = (cartDTO.getQuantity());
            float price = (cartDTO.getPrice());
            HistoryDetailDTO his = new HistoryDetailDTO(billCode, bookid, booktitle, quantity, price);
            try {
                userDAO.addHistoryInfo(his, billCode);
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        // TODO add your handling code here:
        fullFields();
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        // TODO add your handling code here:
        fullFields();
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtFullNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullNameKeyReleased
        // TODO add your handling code here:
        fullFields();
    }//GEN-LAST:event_txtFullNameKeyReleased

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        ArrayList list = userDAO.getUserIDbyUserNames(lblWelcome.getText().toLowerCase().trim());
        String userID = null;
        for (Object list1 : list) {
            userID = list1.toString();
        }
        float money = 0;
        String totalAmount = totalAmount();
        float total = Float.parseFloat(totalAmount);

        ArrayList listDis = userDAO.getPersentByDiscountCode(txtDiscountCode.getText().toLowerCase().trim(), userID);
        String persent = null;
        for (Object list1 : listDis) {
            persent = list1.toString();
        }
        float Persent = Float.parseFloat(persent);
        if (Persent == 10) {
            money = ((total * 90) / 100);
        } else if (Persent == 20) {
            money = ((total * 80) / 100);
        } else if (Persent == 30) {
            money = ((total * 70) / 100);
        } else if (Persent == 35) {
            money = ((total * 65) / 100);
        } else if (Persent == 40) {
            money = ((total * 60) / 100);
        } else if (Persent == 50) {
            money = ((total * 50) / 100);
        } else if (Persent == 70) {
            money = ((total * 30) / 100);
        } else if (Persent == 100) {
            money = ((total * 0) / 100);
        }
        String MONEYPAY = Float.toString(money);
        txtTotalAmount.setText(MONEYPAY);


    }//GEN-LAST:event_btnApplyActionPerformed

    private void txtTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAmountActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked

    }//GEN-LAST:event_tblBillMouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        tabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnUpdateQuatityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateQuatityActionPerformed
        // TODO add your handling code here:
        String bookId = txtBookID1.getText();
        String bookTitle = txtBookTitle1.getText();
        String price = txtPrice1.getText();
        float prices = Float.parseFloat(price);
        String quantity = txtQuantity1.getText();
        if (quantity.equals("0")) {
            JOptionPane.showMessageDialog(this, "Quantity can't be Zero");
            return;
        }
        if (!quantity.matches("[0-9]{1,10000}")) {
            JOptionPane.showMessageDialog(null, "Quantity must is Integer Number(Begin 1)");
            return;
        }
        int quantitys = Integer.parseInt(quantity);

        CartDTO cart = new CartDTO(bookId, bookTitle, quantitys, prices);
        int n = JOptionPane.showConfirmDialog(this, "Do you want to Update " + bookTitle + "?", "Update", JOptionPane.YES_NO_OPTION);
        if (n != JOptionPane.YES_OPTION) {
            return;
        }
        boolean check = false;
        try {
            check = userDAO.updateBookFromCart(cart, quantity);

        } catch (Exception ex) {
            Logger.getLogger(UserForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (check) {
            JOptionPane.showMessageDialog(this, "Update Book Success");
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Update Book Failed");
        }
        showDataCart();
        tblCart.updateUI();
        showDataBill();
        tblBill.updateUI();
    }//GEN-LAST:event_btnUpdateQuatityActionPerformed

    private void btnDeleteByUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteByUserActionPerformed
        // TODO add your handling code here:
        String bookId = txtBookID1.getText();
        String bookTitle = txtBookTitle1.getText();
        String price = txtPrice1.getText();
        float prices = Float.parseFloat(price);
        String quantity = txtQuantity1.getText();
        int quantitys = Integer.parseInt(quantity);

        CartDTO cart = new CartDTO(bookId, bookTitle, quantitys, prices);
        int n = JOptionPane.showConfirmDialog(this, "Do you want to Delete " + bookTitle + "?", "Delete", JOptionPane.YES_NO_OPTION);
        if (n != JOptionPane.YES_OPTION) {
            return;
        }
        boolean check = false;
        try {
            check = userDAO.deleteBookFromCarts(cart);
        } catch (Exception ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check) {
            JOptionPane.showMessageDialog(this, "Delete Book Success");
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Delete Book Failed");
        }
        showDataCart();
        tblCart.updateUI();
        showDataBill();
        tblBill.updateUI();
    }//GEN-LAST:event_btnDeleteByUserActionPerformed

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked

        int row = tblCart.getSelectedRow();
        if (row < 0) {
            return;
        }
        String BookID = (String) tblCart.getValueAt(row, 0);
        CartDTO dto = null;
        try {
            dto = userDAO.getBookByID(BookID);

        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtBookID1.setText(dto.getBookId());
        txtBookTitle1.setText(dto.getBookTitle());
        txtPrice1.setText(Float.toString(dto.getPrice()));
        txtQuantity1.setText(Float.toString(dto.getQuantity()));


        txtBookID1.setEditable(false);
        txtBookTitle1.setEditable(false);
        txtPrice1.setEditable(false);
        txtQuantity1.setEditable(true);
        btnDeleteByUser.setEnabled(true);
        btnUpdateQuatity.setEnabled(true);
        showDataBill();
    }//GEN-LAST:event_tblCartMouseClicked

    private void tblUserDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserDiscountMouseClicked
        // TODO add your handling code here:
        int row = tblUserDiscount.getSelectedRow();
        if (row < 0) {
            return;
        }
        String discountcode = (String) tblUserDiscount.getValueAt(row, 0);
        DiscountCodeDTO dto = null;
        try {
            dto = userDAO.getDiscountCode(discountcode);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtDiscountCode.setText(dto.getDiscountCode());
        if (!txtDiscountCode.getText().isEmpty()) {
            btnApply.setEnabled(true);
        }
    }//GEN-LAST:event_tblUserDiscountMouseClicked

    private void tblHistoryDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHistoryDetailMouseClicked

    private void tblBillHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillHistoryMouseClicked
        // TODO add your handling code here:
        int row = tblBillHistory.getSelectedRow();
        if (row < 0) {
            return;
        }
        String BillID = (String) tblBillHistory.getValueAt(row, 0);
        BillDTO dto = null;
        try {
            dto = userDAO.getBillByID(BillID);
        } catch (Exception ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtBillCode.setText(dto.getBillID());
        showHistoryDetail(txtBillCode.getText().trim());

    }//GEN-LAST:event_tblBillHistoryMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTotalAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalAmountKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTotalAmountKeyPressed

    private void txtTotalAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalAmountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAmountKeyReleased

    private void txtDiscountCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountCodeKeyReleased
        // TODO add your handling code here:
        if (!txtDiscountCode.getText().isEmpty()) {
            btnApply.setEnabled(true);
        }
    }//GEN-LAST:event_txtDiscountCodeKeyReleased

    private void txtSearchHistoryByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHistoryByNameKeyReleased
        // TODO add your handling code here:
        if (!txtSearchHistoryByName.getText().isEmpty()) {
            btnSearchHisByName.setEnabled(true);
        }
    }//GEN-LAST:event_txtSearchHistoryByNameKeyReleased

    private void txtSearchHistoryByDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHistoryByDateKeyReleased
        // TODO add your handling code here:
        if (!txtSearchHistoryByDate.getText().isEmpty()) {
            btnSearchHisByDate.setEnabled(true);
        }
    }//GEN-LAST:event_txtSearchHistoryByDateKeyReleased

    public void showHistoryDetail(String billId) {
        List<HistoryDetailDTO> list = userDAO.getHisByID(billId);
        tblViewHistoryDetail = (DefaultTableModel) tblHistoryDetail.getModel();
        while (tblViewHistoryDetail.getRowCount() > 0) {
            tblViewHistoryDetail.removeRow(0);
        }
        for (HistoryDetailDTO hisDTO : list) {
            tblViewHistoryDetail.addRow(hisDTO.toVector());
        }
    }

    public void clear() {
        txtBookID1.setText("");
        txtBookTitle1.setText("");
        txtPrice1.setText("");
        txtQuantity1.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteByUser;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearchByCategory;
    private javax.swing.JButton btnSearchByMoney;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JButton btnSearchHisByDate;
    private javax.swing.JButton btnSearchHisByName;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdateQuatity;
    private javax.swing.JComboBox cbxRangeMoney;
    private javax.swing.JComboBox cbxSearchCategory;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblHi;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblBillHistory;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblHistoryDetail;
    private javax.swing.JTable tblUserDiscount;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBillCode;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookID1;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtBookTitle1;
    private javax.swing.JTextField txtCategories;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDiscountCode;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtSearchByName;
    private javax.swing.JTextField txtSearchHistoryByDate;
    private javax.swing.JTextField txtSearchHistoryByName;
    private javax.swing.JTextField txtTEssss;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
