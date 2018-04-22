/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.swings;

import az.shahin.other.Validator;
import az.shahin.pojo.AccountPojo;
import az.shahin.sql.AccountSQL;
import az.shahin.sql.HighScoreSQL;
import java.awt.Color;
import java.awt.Event;
import javax.swing.JFrame;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class Registration extends javax.swing.JDialog {

    /**
     * Creates new form Registration
     */
    private final AccountSQL accountSQL = new AccountSQL();
    private final HighScoreSQL highScoreSQL = new HighScoreSQL();
    private JFrame LoginFrame = null;
    public Registration(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        LoginFrame = parent;
    }

    private void InserData() {
        char x;
        if (cmbGender.getSelectedIndex() == 0) {
            x = 'M';
        } else {
            x = 'F';
        }
        AccountPojo pojo = new AccountPojo( txtUser.getText(), txtFirst.getText(), txtLast.getText(), txtTel.getText(), txtMail.getText(), txtPass.getText(), x);
        accountSQL.InserData(pojo);
        highScoreSQL.Add(pojo.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFirst = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLast = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        cmbGender = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(102, 0, 153));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 153));
        jButton1.setText("Back to Log In page");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 153));
        jButton2.setText("Sign In");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 0, 153));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setText("Username:");

        txtFirst.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtFirst.setForeground(new java.awt.Color(102, 0, 153));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 153));
        jLabel5.setText("Fist Name:");

        txtLast.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtLast.setForeground(new java.awt.Color(102, 0, 153));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setText("Last Name:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 153));
        jLabel7.setText("Gender:");

        txtPass.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtPass.setForeground(new java.awt.Color(102, 0, 153));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 153));
        jLabel8.setText("Password:");

        txtPass2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtPass2.setForeground(new java.awt.Color(102, 0, 153));
        txtPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 153));
        jLabel9.setText("Again:");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 153));
        jLabel10.setText("E-Mail:");

        txtMail.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtMail.setForeground(new java.awt.Color(102, 0, 153));
        txtMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 153));
        jLabel11.setText("Telephone:");

        txtTel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtTel.setForeground(new java.awt.Color(102, 0, 153));
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelKeyPressed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(102, 0, 153));

        cmbGender.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cmbGender.setForeground(new java.awt.Color(102, 0, 153));
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cmbGender.setBorder(null);
        cmbGender.setName("Select Gender"); // NOI18N
        cmbGender.setOpaque(false);
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtUser)
                                                    .addComponent(txtFirst)
                                                    .addComponent(txtLast))
                                                .addComponent(cmbGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFirst, txtLast, txtMail, txtPass, txtPass2, txtTel, txtUser});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFirst, txtLast, txtMail, txtPass, txtPass2, txtTel, txtUser});

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome to Easy Test Maker v1.1.0");

        lblWarning.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(102, 0, 153));
        lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarning.setText("Registration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(lblWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPass2ActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lblWarning.setText("");
                lblWarning.setForeground(Color.red);
        if (txtUser.getText().length() < 3 || txtUser.getText().length() > 19) {
            lblWarning.setText("Username is too small (or large) ");
        } else if (accountSQL.RegistrationCheck(txtUser.getText(), true) == 1) {
            lblWarning.setText("This username already exist");
        } else if (txtFirst.getText().length() < 3 || txtFirst.getText().length() > 19) {
            lblWarning.setText("FirstName is too small (or large) ");
        } else if (txtLast.getText().length() < 3 || txtLast.getText().length() > 19) {
            lblWarning.setText("LastName is too small (or large) ");
        } else if (txtPass.getText().length() < 5 || txtPass.getText().length() > 19) {
            lblWarning.setText("Password is too small (or large) ");
        } else if (!txtPass.getText().equals(txtPass2.getText())) {
            lblWarning.setText("Again type password error");
        } else if (!Validator.isValidEmailAddress(txtMail.getText()) && txtMail.getText().length() > 34) {
            lblWarning.setText("Invalid Email adress  (or large) ");
        }else if (accountSQL.RegistrationCheck(txtMail.getText(), false) == 1) {
            lblWarning.setText("This Email already exist");
        }        else if (!Validator.isValidNumber(txtTel.getText()) || txtTel.getText().length() > 13) {
            lblWarning.setText("Invalid Telephone number (or large) ");
        } else {
            InserData();
            dispose();
            setVisible(false);
            LoginFrame.dispose();
            LoginFrame.setVisible(false);
            EasyTestMaker test = new EasyTestMaker(txtUser.getText());
            test.show();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
if(evt.getKeyCode() == Event.ENTER )
        jButton2ActionPerformed(null);       // TODO add your handling code here:
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtMailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyPressed
if(evt.getKeyCode() == Event.ENTER )
        jButton2ActionPerformed(null);        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailKeyPressed

    private void txtTelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyPressed
if(evt.getKeyCode() == Event.ENTER )
        jButton2ActionPerformed(null);        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelKeyPressed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registration dialog = new Registration(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cmbGender;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lblWarning;
    public javax.swing.JTextField txtFirst;
    public javax.swing.JTextField txtLast;
    public javax.swing.JTextField txtMail;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JPasswordField txtPass2;
    public javax.swing.JTextField txtTel;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
