/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.swings;

import az.shahin.pojo.AccountPojo;
import az.shahin.pojo.LanguagePojo;
import az.shahin.pojo.TestsPojo;
import az.shahin.pojo.XMLTestModel;
import az.shahin.sql.AccountSQL;
import az.shahin.sql.TestsSQL;
import az.shahin.tests.AllLanguage;
import az.shahin.tests.Level;
import az.shahin.tests.Rate;
import az.shahin.tests.XMLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class TestBoxSettings extends javax.swing.JFrame {

    private AccountPojo pojo = null;
    private final int mode;

    private void start() {
        //  tbl_test.setModel(new TestModel(pojo.getId()));
        setTitle(pojo.getFirstname() + "'s Test Box");
        lblUserDetails.setText("Welcome , " + pojo.getFirstname() + "  " + pojo.getLastname());
        group.add(btn_Show);
        group.add(btn_Add);
        this.setSize(1005, 800);
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
                        //  Logger.getLogger(TestOperations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
        Training();
    }

    private void Training() {
        insertcmbBox();
        listinnull();
        list_my();
        list_all();
        setBtnEnble(false);
    }
    private HashSet<TestsPojo> list_allelements = new HashSet<>();
    private HashSet<TestsPojo> list_myelements = new HashSet<>();

    private void list_my() {
        List<XMLTestModel> listtest = null;
        try {
            listtest = new XMLConnection(this.pojo.getId()).getAllEmloyee(this.pojo.getId());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Vector<String> listdata = new Vector<>();
        if (listtest != null) {
            for (XMLTestModel pojo : listtest) {
                if (pojo.getId() == this.pojo.getId()) {
                    List<Integer> listint = pojo.getTests();
                    for (int testid : listint) {
                        TestsPojo pojoex = new TestsSQL().getTestoPjo(testid);
                        list_myelements.add(pojoex);
                        listdata.add(listdata.size() + 1 + ") " + pojoex.getDescription());
                    }
                }
            }
        }
        list_my.setListData(listdata);
    }

    private void list_all() {
        List<TestsPojo> listtest = new TestsSQL().getAllData(-1, false);
        list_allelements = new HashSet<>();
        first:
        for (TestsPojo pojo : listtest) {
            if (pojo.getAccount() == this.pojo.getId() || ((pojo.getMode() == 1) || (pojo.getMode() == 3))) {
                //System.out.println(pojo.getId());
                second:
                for (TestsPojo check : list_myelements) {
                    if (pojo.getId() == check.getId()) {
                        continue first;
                    }
                }
                list_allelements.add(pojo);
            }
        }
        reloadlist();
    }

    private void setBtnEnble(boolean set) {

        cmb_rate.setEnabled(true);
    }

    public TestBoxSettings(String username, int mode) {
        if (username != null) {
            pojo = new AccountSQL().getAccountPojo(username);
        }
        this.mode = mode;
        initComponents();
        start();
        switch (mode) {
            case 1:
                btn_Show.setSelected(true);
                btn_ShowActionPerformed(null);
                break;
            case 2:
                btn_Add.setSelected(true);
                btn_AddActionPerformed(null);
                break;
        }
    }

    /**
     * Creates new form EasyTestMaker
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_Show = new javax.swing.JToggleButton();
        btn_Add = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblUserDetails = new javax.swing.JLabel();
        btn_Add1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmb_lang1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmb_Lang2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmb_level = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmb_rate = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_score = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_my = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_all = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1005, 740));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 100));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Test Box (Set Mode)");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(2, 0, 1000, 30);

        btn_Show.setBackground(new java.awt.Color(255, 255, 255));
        btn_Show.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_Show.setForeground(new java.awt.Color(102, 0, 153));
        btn_Show.setText("Show My TestBOX");
        btn_Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Show);
        btn_Show.setBounds(170, 40, 240, 50);

        btn_Add.setBackground(new java.awt.Color(255, 255, 255));
        btn_Add.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(102, 0, 153));
        btn_Add.setText("Search Tests");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Add);
        btn_Add.setBounds(540, 40, 240, 50);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(815, 40));
        jPanel3.setLayout(null);

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(102, 0, 153));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("Easy Test Maker");
        lblTime.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblTime.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel3.add(lblTime);
        lblTime.setBounds(700, 10, 300, 30);

        lblUserDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblUserDetails.setForeground(new java.awt.Color(102, 0, 153));
        lblUserDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserDetails.setText("Easy Test Maker");
        lblUserDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblUserDetails.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel3.add(lblUserDetails);
        lblUserDetails.setBounds(10, 10, 417, 30);

        btn_Add1.setBackground(new java.awt.Color(255, 255, 255));
        btn_Add1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        btn_Add1.setForeground(new java.awt.Color(102, 0, 153));
        btn_Add1.setText("<< Return to Main Page");
        btn_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Add1);
        btn_Add1.setBounds(438, 2, 250, 36);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(995, 320));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 300));

        jLabel3.setBackground(new java.awt.Color(230, 228, 228));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Test Details");
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 23));

        cmb_lang1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cmb_lang1.setForeground(new java.awt.Color(153, 102, 255));
        cmb_lang1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 51, 255));
        jLabel5.setText("First Language");

        cmb_Lang2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cmb_Lang2.setForeground(new java.awt.Color(153, 102, 255));
        cmb_Lang2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 51, 255));
        jLabel6.setText("Second Language");

        cmb_level.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cmb_level.setForeground(new java.awt.Color(153, 102, 255));
        cmb_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 51, 255));
        jLabel7.setText("Level of Test");

        cmb_rate.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cmb_rate.setForeground(new java.awt.Color(153, 102, 255));
        cmb_rate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 51, 255));
        jLabel8.setText("Rating of Test");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 51, 255));
        jLabel9.setText("Number of Test");

        txt_id.setEditable(false);
        txt_id.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_id.setForeground(new java.awt.Color(153, 102, 255));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 51, 255));
        jLabel10.setText("Score Of Test");

        txt_score.setEditable(false);
        txt_score.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_score.setForeground(new java.awt.Color(153, 102, 255));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 51, 255));
        jLabel13.setText("Author of Test");

        txt_username.setEditable(false);
        txt_username.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(153, 102, 255));

        txt_date.setEditable(false);
        txt_date.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_date.setForeground(new java.awt.Color(153, 102, 255));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 51, 255));
        jLabel14.setText("Last Updated date");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 51, 255));
        jLabel15.setText("Description");

        txt_desc.setColumns(10);
        txt_desc.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_desc.setForeground(new java.awt.Color(153, 102, 255));
        txt_desc.setRows(5);
        txt_desc.setWrapStyleWord(true);
        txt_desc.setEnabled(false);
        jScrollPane2.setViewportView(txt_desc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb_level, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(cmb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_lang1, 0, 169, Short.MAX_VALUE)
                            .addComponent(txt_id))))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_Lang2, 0, 174, Short.MAX_VALUE)
                            .addComponent(txt_score))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(72, 72, 72))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_id)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_score, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_lang1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_Lang2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb_level, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_id, txt_score});

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 400, 1000, 220);

        list_my.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Tests", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(153, 51, 255))); // NOI18N
        list_my.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        list_my.setForeground(new java.awt.Color(153, 51, 255));
        list_my.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_my.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_my.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_myMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(list_my);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(590, 10, 380, 390);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 51, 255));
        jButton1.setText("Refresh");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(420, 170, 160, 50);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 51, 255));
        jButton2.setText("=>>");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(420, 30, 160, 50);

        list_all.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Tests", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(153, 51, 255))); // NOI18N
        list_all.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        list_all.setForeground(new java.awt.Color(153, 51, 255));
        list_all.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1", "item1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_all.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_allMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(list_all);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 10, 380, 390);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 51, 255));
        jButton3.setText("Clear");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(420, 240, 160, 50);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 51, 255));
        jButton4.setText("<<=");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(420, 100, 160, 50);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 51, 255));
        jButton5.setText("Save");
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(420, 320, 160, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listinnull() {
        list_all.removeAll();
        list_my.removeAll();
    }

    private void reloadlist() {
        listinnull();
        Vector<String> listdata = new Vector<>();
        listdata.removeAllElements();
        listdata.clear();
        //System.out.println("\n--------\n");
        first:
        for (TestsPojo pojoex : list_myelements) {
          //  System.out.println("MY : " + pojoex.getId());
            listdata.add(listdata.size() + 1 + ") " + pojoex.getDescription());
        }
        list_my.setListData(listdata.toArray());
        listdata.clear();
        listdata.removeAllElements();
        Iterator<TestsPojo> pojoe = list_allelements.iterator();
        first:while (pojoe.hasNext()) {
            TestsPojo pojoex = pojoe.next();
            for (TestsPojo pojoex2 : list_myelements) {
                if (pojoex.getId() == pojoex2.getId()) {
                    pojoe.remove();
                    continue first;
                }
            }
            //System.out.println("ALL : " + pojoex.getId());
            listdata.add(listdata.size() + 1 + ") " + pojoex.getDescription());
            //System.out.println("all : " + pojoex.getDescription());
        }
        list_all.setListData(listdata.toArray());
    }

    private void checklist() {
        listinnull();
        Vector<String> listdata = new Vector<>();
        listdata.clear();
        listdata.removeAllElements();
        Iterator iterator = list_allelements.iterator();
        first:
        while (iterator.hasNext()) {
            TestsPojo pojoex = (TestsPojo) iterator.next();
            for (TestsPojo pojoex1 : list_myelements) {
                if (pojoex.equals(pojoex1)) {
                    iterator.remove();
                    continue first;
                }
            }
            listdata.add(listdata.size() + 1 + ") " + pojoex.getDescription());
        }
        list_all.setListData(listdata.toArray());
    }


    private void btn_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add1ActionPerformed
        EasyTestMaker maker = new EasyTestMaker(pojo.getUsername());
        this.dispose();
        this.setVisible(false);
        maker.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Add1ActionPerformed

    private void btn_ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ShowActionPerformed

    }//GEN-LAST:event_btn_ShowActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        SearchTests search = new SearchTests(this, true, pojo.getUsername());
        search.show();
        btn_Show.setSelected(true);
        if (search.getTests() != null) {
            list_allelements.clear();
            first:
            for (TestsPojo pojo1 : search.getTests()) {
                for (TestsPojo pojo2 : list_myelements) {
                    if (pojo1.equals(pojo2)) {
                        continue first;
                    }
                }
                list_my.removeAll();
                list_all.removeAll();
                list_allelements.add(pojo1);
            }
        }
        reloadlist();

    }//GEN-LAST:event_btn_AddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton3ActionPerformed(evt);
        listinnull();
        list_allelements.clear();
        list_myelements.clear();
        start();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        list_my.setListData(new Vector());
        list_all.setListData(new Vector());
        list_myelements.clear();
        list_all();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        List<TestsPojo> tests = new ArrayList<>();
        tests.addAll(list_myelements);
        if (list_my.getSelectedIndex() > -1) {
            int selected = list_my.getSelectedIndex();
            list_allelements.add(tests.get(selected));
            boolean remove = list_myelements.remove(tests.get(selected));
            reloadlist();
        } else {
            JOptionPane.showMessageDialog(this, "Please Select One Test !");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<TestsPojo> tests = new ArrayList<>();
        tests.addAll(list_allelements);
        if (list_all.getSelectedIndex() > -1) {
            int selected = list_all.getSelectedIndex();
            list_myelements.add(tests.get(selected));
            boolean remove = list_allelements.remove(tests.get(selected));
            reloadlist();
        } else {
            JOptionPane.showMessageDialog(this, "Please Select One Test !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void list_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_allMouseClicked
        List<TestsPojo> tests = new ArrayList<>();
        tests.addAll(list_allelements);
        if (list_all.getSelectedIndex() > -1) {
            InsertPanels(tests.get(list_all.getSelectedIndex()).getId());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_list_allMouseClicked

    private void list_myMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_myMouseClicked
        List<TestsPojo> tests = new ArrayList<>();
        tests.addAll(list_myelements);
        if (list_my.getSelectedIndex() > -1) {
            InsertPanels(tests.get(list_my.getSelectedIndex()).getId());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_list_myMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (list_myelements.size() < 1) {
            JOptionPane.showMessageDialog(this, "Your List Is Null !");
        } else {
            List<Integer> intlist = new ArrayList<>();
            for (TestsPojo pojoyec : list_myelements) {
                intlist.add(pojoyec.getId());
            }
            try {
                new XMLConnection(this.pojo.getId()).createXML(new XMLTestModel(pojo.getId(), intlist));
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void InsertPanels(int id) {
        insertcmbBox();
        TestsPojo model = new TestsSQL().getTestoPjo(id);
        txt_id.setEnabled(false);
        txt_id.setText(String.valueOf(id));
        cmb_lang1.setSelectedItem(AllLanguage.getLanguage(model.getLang1()));
        cmb_Lang2.setSelectedItem(AllLanguage.getLanguage(model.getLang2()));
        cmb_level.setSelectedItem(Level.getLevel(model.getLevel()));
        cmb_rate.setSelectedItem(Rate.getRating(model.getRating()));
        txt_score.setText(String.valueOf(model.getScore()));
        AccountPojo pojo = new AccountSQL().getAccountPojo(model.getAccount());
        txt_username.setText(pojo.getFirstname() + " " + pojo.getLastname());
        txt_date.setText(model.getDate().toString());
        txt_desc.setText(model.getDescription());
    }
    private String path = "";

    private void insertcmbBox() {
        cmb_lang1.removeAllItems();
        cmb_Lang2.removeAllItems();
        cmb_level.removeAllItems();
        cmb_rate.removeAllItems();
        for (LanguagePojo langpojo : AllLanguage.getAllLanguage()) {
            cmb_lang1.addItem(langpojo.getLanguage());
            cmb_Lang2.addItem(langpojo.getLanguage());
        }
        for (int i = 0; i <= 8; i++) {
            cmb_level.addItem(Level.getLevel(i));
        }
        for (String rating : Rate.getAllString()) {
            cmb_rate.addItem(rating);
        }
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestBoxSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestBoxSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestBoxSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestBoxSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestBoxSettings("Admin", 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton btn_Add;
    public javax.swing.JToggleButton btn_Add1;
    public javax.swing.JToggleButton btn_Show;
    public javax.swing.JComboBox cmb_Lang2;
    public javax.swing.JComboBox cmb_lang1;
    public javax.swing.JComboBox cmb_level;
    public javax.swing.JComboBox cmb_rate;
    public javax.swing.ButtonGroup group;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lblTime;
    public javax.swing.JLabel lblUserDetails;
    public javax.swing.JList list_all;
    public javax.swing.JList list_my;
    public javax.swing.JTextField txt_date;
    public javax.swing.JTextArea txt_desc;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_score;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
