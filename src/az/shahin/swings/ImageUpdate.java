/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.swings;

import az.shahin.other.GenerateUUID;
import az.shahin.other.ImageOptions;
import az.shahin.other.InternetConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class ImageUpdate extends javax.swing.JDialog {

    private String searchkey = "";
    private String path = "";
    java.awt.Frame Parent = null;

    public ImageUpdate(java.awt.Frame parent,boolean modal, String path, String searchkey) {
        super(parent, modal);
        Parent = parent;
        initComponents();
        this.setTitle(searchkey);
        this.searchkey = searchkey.replaceAll(" ", "+");
        this.path = path;
        start();
    }

    private void start() {
        if (path.length() > 2) {
            BufferedImage img = ImageOptions.setResalution(511, 350,  path);
            lblpic.setIcon(new ImageIcon(img));
        } else {
            BufferedImage img = ImageOptions.setResalution(511, 350, "07046d2f-bc6e-4291-b60f-a18e652f16f7.jpg");
            lblpic.setIcon(new ImageIcon(img));
        }
        txt_id.setText(searchkey);
    }

    private static String fileLocation = null;

    public static String getFileLocation() {
        return fileLocation;
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
        lblWarning = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblpic = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("High Scores");
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);

        lblWarning.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(102, 0, 153));
        lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarning.setText("Image Updater");

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(102, 0, 153));
        btnNext.setText("New Picture from My Computer");
        btnNext.setOpaque(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblpic.setVerifyInputWhenFocusTarget(false);

        btnSelect.setBackground(new java.awt.Color(255, 255, 255));
        btnSelect.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(102, 0, 153));
        btnSelect.setText("Search on Internet");
        btnSelect.setOpaque(false);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(255, 255, 255));
        btnPrev.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(102, 0, 153));
        btnPrev.setText("Ok");
        btnPrev.setOpaque(false);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 51, 255));
        jLabel9.setText("Searching text");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_id))
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblpic, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpic, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + "/Pictures"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setName("Select Picture");
        chooser.setFileFilter(new FileNameExtensionFilter(".jpg , .gif , .png picture files", "jpg", "gif", "png"));
        int status = chooser.showOpenDialog(null);
        if (status != 1) {
            try {
                path = GenerateUUID.getGeneratedUUID();
                ImageOptions.copyFile(chooser.getSelectedFile(), path + ".jpg");
            } catch (IOException ex) {
                Logger.getLogger(ImageUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        start();
    }//GEN-LAST:event_btnNextActionPerformed


    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        try {
            boolean net = InternetConnection.isInternetAvailable();
       //     System.out.println(net);
            if (net) {
                ImageSelect select = new ImageSelect(Parent, true, txt_id.getText());
                select.show();
                if (ImageSelect.getFileLocation() != null) {
                    path = ImageSelect.getFileLocation() +".jpg";
                    start();
                }
            } else {
                JOptionPane.showMessageDialog(Parent, "Check Your Internet Connection", "You are Offline", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Parent, "Check Your Internet Connection", "You are Offline", JOptionPane.ERROR_MESSAGE);
        }
        // Logger.getLogger(ImageUpdate.class.getName()).log(Level.SEVERE, null, ex);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (!path.equals("07046d2f-bc6e-4291-b60f-a18e652f16f7.jpg")) {
            fileLocation = path;
        }else{
            fileLocation=null;
        }
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_btnPrevActionPerformed

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
            java.util.logging.Logger.getLogger(ImageUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImageUpdate dialog = new ImageUpdate(new javax.swing.JFrame(),true, "", "No Picture");
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
    public javax.swing.JButton btnNext;
    public javax.swing.JButton btnPrev;
    public javax.swing.JButton btnSelect;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblWarning;
    public javax.swing.JLabel lblpic;
    public javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
