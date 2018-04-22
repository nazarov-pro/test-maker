/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.swings;

import az.shahin.pojo.AccountPojo;
import az.shahin.pojo.TestPojo;
import az.shahin.pojo.XMLTestModel;
import az.shahin.sql.AccountSQL;
import az.shahin.tests.XMLConnection;
import az.shahin.tests.XMLContinue;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class EasyTestMaker extends javax.swing.JFrame {

    private final AccountSQL accountSQL = new AccountSQL();
    private AccountPojo pojo = null;

    private void start() {
        checkbutton();
        this.setSize(815, 500);
        usr_Admin.setEnabled(true);
        usr_Admin.setVisible(true);
        if (pojo != null) {
            lblUserDetails.setText("Welcome , " + pojo.getFirstname() + "  " + pojo.getLastname());
        }
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Calendar calendar = new GregorianCalendar();

                    String date = null;
                    date = date.format("%02d/%02d/%04d   %02d : %02d : %02d", calendar.getTime().getDate(), calendar.getTime().getMonth() + 1, calendar.getTime().getYear() + 1900, calendar.getTime().getHours(), calendar.getTime().getMinutes(), calendar.getTime().getSeconds());
                    lblTime.setText(date);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EasyTestMaker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }

    public EasyTestMaker(String username) {
        if (username != null) {
            pojo = accountSQL.getAccountPojo(username);
        }
        initComponents();
        start();
    }

    private void checkbutton() {
        jButton18.setEnabled(true);
        try {
            XMLConnection xml = new XMLConnection(this.pojo.getId());
           
            List<TestPojo> xml2 = new XMLContinue(pojo.getId()).getAllEmloyee(pojo.getId());
            continuecheck = true;
            jButton19.setEnabled(true);
            jButton18.setEnabled(false);
            jButton18.setText("First You Finish Tests");
            if (xml2 == null) {
                jButton18.setEnabled(true);
                jButton19.setEnabled(false);
                jButton18.setText("Start Again Tests");
                //  JOptionPane.showMessageDialog(this, "Your TestBOX is Empty\nPlease add tests in your TestBOX !");
            }
             List<XMLTestModel> xmllist = xml.getAllEmloyee(pojo.getId());
            if (xmllist == null) {
                jButton18.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Your TestBOX is Empty\nPlease add tests in your TestBOX !");
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EasyTestMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(EasyTestMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EasyTestMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form EasyTestMaker
     */
    public EasyTestMaker() {
        initComponents();
        start();
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
        jLabel5 = new javax.swing.JLabel();
        usr_delete = new javax.swing.JButton();
        usr_update = new javax.swing.JButton();
        usr_add = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        usr_add1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        usrProfile = new javax.swing.JButton();
        usr_Admin = new javax.swing.JButton();
        usr_Score = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblUserDetails = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Test Maker");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(815, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(815, 150));
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Easy Test Maker");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(2, 0, 790, 30);

        usr_delete.setBackground(new java.awt.Color(255, 255, 255));
        usr_delete.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_delete.setForeground(new java.awt.Color(102, 0, 153));
        usr_delete.setText("Delete Test");
        usr_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(usr_delete);
        usr_delete.setBounds(600, 150, 170, 50);

        usr_update.setBackground(new java.awt.Color(255, 255, 255));
        usr_update.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_update.setForeground(new java.awt.Color(102, 0, 153));
        usr_update.setText("Update Test");
        usr_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_updateActionPerformed(evt);
            }
        });
        jPanel1.add(usr_update);
        usr_update.setBounds(420, 150, 170, 50);

        usr_add.setBackground(new java.awt.Color(255, 255, 255));
        usr_add.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_add.setForeground(new java.awt.Color(102, 0, 153));
        usr_add.setText("Show My Tests");
        usr_add.setPreferredSize(new java.awt.Dimension(230, 31));
        usr_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_addActionPerformed(evt);
            }
        });
        jPanel1.add(usr_add);
        usr_add.setBounds(20, 150, 190, 50);

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(102, 0, 153));
        jButton17.setText("My Test History");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17);
        jButton17.setBounds(300, 60, 240, 50);

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(102, 0, 153));
        jButton18.setText("Start Again Tests");
        jButton18.setPreferredSize(new java.awt.Dimension(230, 31));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18);
        jButton18.setBounds(20, 60, 240, 50);

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(102, 0, 153));
        jButton19.setText("Continue My Test");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19);
        jButton19.setBounds(570, 60, 210, 50);

        usr_add1.setBackground(new java.awt.Color(255, 255, 255));
        usr_add1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_add1.setForeground(new java.awt.Color(102, 0, 153));
        usr_add1.setText("Add Test");
        usr_add1.setPreferredSize(new java.awt.Dimension(230, 31));
        usr_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_add1ActionPerformed(evt);
            }
        });
        jPanel1.add(usr_add1);
        usr_add1.setBounds(220, 150, 190, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 150));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User settings");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(2, 0, 790, 30);

        usrProfile.setBackground(new java.awt.Color(255, 255, 255));
        usrProfile.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usrProfile.setForeground(new java.awt.Color(102, 0, 153));
        usrProfile.setText("Change User Profile");
        usrProfile.setPreferredSize(new java.awt.Dimension(230, 31));
        usrProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrProfileActionPerformed(evt);
            }
        });
        jPanel2.add(usrProfile);
        usrProfile.setBounds(20, 50, 240, 50);

        usr_Admin.setBackground(new java.awt.Color(255, 255, 255));
        usr_Admin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_Admin.setForeground(new java.awt.Color(102, 0, 153));
        usr_Admin.setText("Search User");
        usr_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_AdminActionPerformed(evt);
            }
        });
        jPanel2.add(usr_Admin);
        usr_Admin.setBounds(330, 50, 170, 50);

        usr_Score.setBackground(new java.awt.Color(255, 255, 255));
        usr_Score.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usr_Score.setForeground(new java.awt.Color(102, 0, 153));
        usr_Score.setText("High Scores");
        usr_Score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_ScoreActionPerformed(evt);
            }
        });
        jPanel2.add(usr_Score);
        usr_Score.setBounds(590, 50, 190, 50);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(815, 150));
        jPanel3.setLayout(null);

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(102, 0, 153));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("Easy Test Maker");
        lblTime.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblTime.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel3.add(lblTime);
        lblTime.setBounds(424, 120, 360, 30);

        lblUserDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblUserDetails.setForeground(new java.awt.Color(102, 0, 153));
        lblUserDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserDetails.setText("Easy Test Maker");
        lblUserDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblUserDetails.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel3.add(lblUserDetails);
        lblUserDetails.setBounds(10, 120, 417, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Other settings");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(2, 0, 790, 30);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 0, 153));
        jButton9.setText("Log Out");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(613, 50, 170, 50);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(102, 0, 153));
        jButton10.setText("Add Tests to TestBOX");
        jButton10.setPreferredSize(new java.awt.Dimension(230, 31));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(20, 50, 240, 50);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(102, 0, 153));
        jButton11.setText("Search Tests");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(290, 50, 300, 50);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usrProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrProfileActionPerformed
        UserSettings user = new UserSettings(this, true, pojo);
        user.show();
// TODO add your handling code here:
    }//GEN-LAST:event_usrProfileActionPerformed

    private void usr_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_AdminActionPerformed
        UserTools usertools = new UserTools(pojo.getUsername(), 0);
        this.dispose();
        this.setVisible(false);
        usertools.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_usr_AdminActionPerformed

    private void usr_ScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_ScoreActionPerformed
        HighScore score = new HighScore(this, true, pojo.getUsername());
        score.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_usr_ScoreActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Are you sure to exit , " + pojo.getFirstname() + " ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            Login login = new Login();
            this.dispose();
            this.setVisible(false);
            login.show();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        TestBoxPage(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void usr_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_deleteActionPerformed
        TestOpeaartionPage(4);
    }//GEN-LAST:event_usr_deleteActionPerformed

    private void usr_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_updateActionPerformed
        TestOpeaartionPage(3);
    }//GEN-LAST:event_usr_updateActionPerformed
    private void TestOpeaartionPage(int mode) {
        TestOperations operations = new TestOperations(pojo.getUsername(), mode);
        this.dispose();
        this.setVisible(false);
        operations.show();
    }

    private void TestBoxPage(int mode) {
        TestBoxSettings operations = new TestBoxSettings(pojo.getUsername(), mode);
        this.dispose();
        this.setVisible(false);
        operations.show();
    }
    private void usr_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_addActionPerformed
        TestOpeaartionPage(1);
// TODO add your handling code here:
    }//GEN-LAST:event_usr_addActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        History history = new History(this, true, pojo.getUsername());
        history.show();// TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed
    private boolean continuecheck = false;

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        TestStart start = new TestStart(pojo.getUsername(), false);
        this.dispose();
        this.setVisible(false);
        start.show();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        TestStart start = new TestStart(pojo.getUsername(), true);
        this.dispose();
        this.setVisible(false);
        start.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void usr_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_add1ActionPerformed
        TestOpeaartionPage(2);
        // TODO add your handling code here:
    }//GEN-LAST:event_usr_add1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        TestBoxPage(2);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton10;
    public javax.swing.JButton jButton11;
    public javax.swing.JButton jButton17;
    public javax.swing.JButton jButton18;
    public javax.swing.JButton jButton19;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblTime;
    public javax.swing.JLabel lblUserDetails;
    public javax.swing.JButton usrProfile;
    public javax.swing.JButton usr_Admin;
    public javax.swing.JButton usr_Score;
    public javax.swing.JButton usr_add;
    public javax.swing.JButton usr_add1;
    public javax.swing.JButton usr_delete;
    public javax.swing.JButton usr_update;
    // End of variables declaration//GEN-END:variables
}
