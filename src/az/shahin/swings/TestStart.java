/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.swings;

import az.shahin.other.ImageOptions;
import az.shahin.other.OpenFile;
import az.shahin.pojo.AccountPojo;
import az.shahin.pojo.TestPojo;
import az.shahin.pojo.TestsPojo;
import az.shahin.pojo.XMLTestModel;
import az.shahin.sql.AccountSQL;
import az.shahin.sql.TestsSQL;
import az.shahin.tests.AllLanguage;
import az.shahin.tests.XMLConnection;
import az.shahin.tests.XMLContinue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class TestStart extends javax.swing.JFrame {

    private final AccountSQL accountSQL = new AccountSQL();
    private int size = 0;
    private AccountPojo pojo = null;
    private List<TestsPojo> list_myelements = new ArrayList<>();
    private List<TestPojo> alltest = new ArrayList<>();
    private Map<Integer, Integer> answers = new HashMap<>();

    private void list_my() {
        List<XMLTestModel> listtest = null;
        try {
            listtest = new XMLConnection(this.pojo.getId()).getAllEmloyee(this.pojo.getId());
            if (listtest == null || listtest.size() < 1) {
                JOptionPane.showMessageDialog(this, "Your TextBOX is empty !");
                TestBoxSettings operations = new TestBoxSettings(pojo.getUsername(), 1);
                this.dispose();
                this.setVisible(false);
                operations.show();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestBoxSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (listtest != null) {
            for (XMLTestModel pojo : listtest) {
                if (pojo.getId() == this.pojo.getId()) {
                    List<Integer> listint = pojo.getTests();
                    for (int testid : listint) {
                        TestsPojo pojoex = new TestsSQL().getTestoPjo(testid);
                        list_myelements.add(pojoex);
                    }
                }
            }
        }
    }
    private Random random = new Random();

    private void loadall() {
        List<TestsPojo> pojoall1 = new TestsSQL().getAllData(-1, false);
        Set<TestsPojo> pojoall = new HashSet<>();
        pojoall.addAll(pojoall1);
        allvar:
        for (TestsPojo pojos : list_myelements) {
            TestPojo pojo = new TestPojo();
            pojo.setMode(random.nextInt(3));
            if (pojos.getPicture().length() < 6) {
                pojo.setMode(random.nextInt(2));
            }
            int answer = random.nextInt(5);
            pojo.setAnswer(answer);
            List<String> lststring = new ArrayList<>();
            if (pojo.getMode() == 0 || pojo.getMode() == 1) {
                variant:
                for (int i = 0; i < 5; i++) {
                    check:
                    for (TestsPojo pojocheck : pojoall) {
                        if (pojo.getMode() == 0) {
                            if (pojos.getLang2() == pojocheck.getLang1()) {
                                onecheck:
                                for (String check : lststring) {
                                    if (pojocheck.getQuestion().equals(check)) {
                                        continue check;
                                    }
                                }
                                lststring.add(pojocheck.getQuestion());
                                continue variant;
                            } else if (pojos.getLang2() == pojocheck.getLang2()) {
                                for (String check : lststring) {
                                    if (pojocheck.getAnswer().equals(check)) {
                                        continue check;
                                    }
                                }
                                lststring.add(pojocheck.getAnswer());
                                continue variant;
                            }
                        } else if (pojo.getMode() == 1) {
                            if (pojos.getLang1() == pojocheck.getLang1()) {
                                onecheck:
                                for (String check : lststring) {
                                    if (pojocheck.getQuestion().equals(check)) {
                                        continue check;
                                    }
                                }
                                lststring.add(pojocheck.getQuestion());
                                continue variant;
                            } else if (pojos.getLang1() == pojocheck.getLang2()) {
                                for (String check : lststring) {
                                    if (pojocheck.getAnswer().equals(check)) {
                                        continue check;
                                    }
                                }
                                lststring.add(pojocheck.getAnswer());
                                continue variant;
                            }
                        }
                    }

                }

            } else {
                variant:
                for (int i = 0; i < 5; i++) {
                    check:
                    for (TestsPojo pojocheck : pojoall) {
                        for (String check : lststring) {
                            if (pojocheck.getPicture().equals(check)) {
                                continue check;
                            }
                        }
                        if (pojocheck.getPicture().length() > 5) {
                            lststring.add(pojocheck.getPicture());
                            continue variant;
                        }
                    }
                }
            }
            if (pojo.getMode() == 0) {
                boolean found = false;
                for (int i = 0; i < lststring.size(); i++) {
                    if (pojos.getAnswer().equals(lststring.get(i))) {
                        found = true;
                        if (i == pojo.getAnswer() && lststring.get(i).equals(pojos.getAnswer())) {
                            break;
                        } else {
                            try {
                                String word = lststring.get(pojo.getAnswer());
                                lststring.set(pojo.getAnswer(), pojos.getAnswer());
                                lststring.set(i, word);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "Please delete this answer id : " + pojos.getId());
                            }
                            break;
                        }
                    }
                }
                if (!found) {
                    lststring.set(pojo.getAnswer(), pojos.getAnswer());
                }
            }
            if (pojo.getMode() == 1) {
                boolean found = false;
                for (int i = 0; i < lststring.size(); i++) {
                    if (pojos.getQuestion().equals(lststring.get(i))) {
                        found = true;
                        if (i == pojo.getAnswer() && lststring.get(i).equals(pojos.getQuestion())) {
                            break;
                        } else {
                            try {
                                String word = lststring.get(pojo.getAnswer());
                                lststring.set(pojo.getAnswer(), pojos.getQuestion());
                                lststring.set(i, word);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "Please delete this answer id : " + pojos.getId());
                            }
                            break;
                        }
                    }
                }
                if (!found) {
                    lststring.set(pojo.getAnswer(), pojos.getAnswer());
                }
            }
            if (pojo.getMode() == 2) {
                boolean found = false;
                for (int i = 0; i < lststring.size(); i++) {
                    if (pojos.getPicture().equals(lststring.get(i))) {
                        found = true;
                        if (i == pojo.getAnswer() && lststring.get(i).equals(pojos.getPicture())) {
                            break;
                        } else {
                            try {
                                String word = lststring.get(pojo.getAnswer());
                                lststring.set(pojo.getAnswer(), pojos.getPicture());
                                lststring.set(i, word);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "Please delete this answer id : " + pojos.getId());
                            }
                            break;
                        }
                    }
                }
                if (!found) {
                    lststring.set(pojo.getAnswer(), pojos.getPicture());
                }
            }
            pojo.setAnswers(lststring);
            alltest.add(pojo);
        }
//     for (TestPojo pojo : alltest) {
//            System.out.println("Answer : " + pojo.getAnswer() + "\nMode :" + pojo.getMode());
//            for (String go : pojo.getAnswers()) {
//                System.out.println(go);
//            }
//
//        }

    }

    private void readTests() {
        List<TestPojo> backup = new ArrayList<>();
        try {
            XMLContinue conti = new XMLContinue(pojo.getId());
            backup = conti.getAllEmloyee(pojo.getId());
            seconds = conti.getSeconds();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        list_myelements.clear();
        alltest.clear();
        answers.clear();
        for (int i = 0; i < backup.size(); i++) {
            //System.out.println("Answer1 "+backup.get(i).getMyselected());
            list_myelements.add(new TestsSQL().getTestoPjo(backup.get(i).getTestId()));
            alltest.add(backup.get(i));
            if (backup.get(i).getMyselected() != 5 && backup.get(i).getMyselected() != -1) {
                answers.put(i, backup.get(i).getMyselected());
            } else {
                answers.put(i, 5);
            }
        }
    }

    private void insertlist() {
        if (!cont) {
            loadall();
        }
        Vector<String> alllist = new Vector<>();
        this.size = list_myelements.size();
        for (TestsPojo pojo : list_myelements) {
            alllist.add(String.valueOf((alllist.size() + 1)) + ") " + pojo.getDescription());
        }
        list_alltest.setListData(alllist.toArray());
        list_alltest.setSelectedIndex(0);
        list_alltestMouseClicked(null);
        slideshow();
    }
    private String path = "";

    private void setPictureIcon(String picture) {
        if (picture.length() > 2) {
            picture = picture.endsWith(".jpg") ? picture : (picture + ".jpg");
            BufferedImage img = ImageOptions.setResalution(460, 240, picture);
            lbl_pic.setIcon(new ImageIcon(img));
            this.path = picture;
        } else {
            BufferedImage img = ImageOptions.setResalution(460, 240, "07046d2f-bc6e-4291-b60f-a18e652f16f7.jpg");
            lbl_pic.setIcon(new ImageIcon(img));
            path = "";
        }
    }

    private void setPictureIcon2(JToggleButton button, String picture) {
        if (picture.length() > 2) {
            picture = picture.endsWith(".jpg") ? picture : (picture + ".jpg");
            BufferedImage img = ImageOptions.setResalution(148, 110, picture);
            button.setIcon(new ImageIcon(img));
        } else {
            BufferedImage img = ImageOptions.setResalution(148, 110, "07046d2f-bc6e-4291-b60f-a18e652f16f7.jpg");
            button.setIcon(new ImageIcon(img));
        }
    }

    private void start() {
        this.setSize(797, 550);
        if (pojo != null) {
            lblUserDetails.setText("Welcome , " + pojo.getFirstname() + "  " + pojo.getLastname());
        }
        rdgroup.add(rd_a);
        rdgroup.add(rd_b);
        rdgroup.add(rd_c);
        rdgroup.add(rd_d);
        rdgroup.add(rd_e);
        rdgroup.add(hide_btn);
        tgbutton.add(tg_a);
        tgbutton.add(tg_b);
        tgbutton.add(tg_c);
        tgbutton.add(tg_d);
        tgbutton.add(tg_e);
        tgbutton.add(tg_h);
        tg_h.setVisible(false);
        hide_btn.setVisible(false);
        if (cont) {
            readTests();
        } else {
            list_my();
        }

    }

    private void timeover() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                //System.out.println(seconds);
                if (seconds == -1 || seconds == 0) {
                    seconds = list_myelements.size() * 10;
                }
                while (true) {
                    String date = null;
                    date = date.format("%02d : %02d : %02d", (seconds / 3600), (seconds / 60), seconds % 60);
                    lblTime.setText(date);
                    if (seconds <= 0) {
                        lblTime.setText("Time Over !");
                        testover();
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    seconds--;

                }
            }
        });
        thread.start();
    }
    private int seconds = -1;

    private boolean pacientdied = false;

    private void testover() {
        if (!pacientdied) {
            new XMLContinue(pojo.getId()).removeLog(pojo.getId());
            pacientdied = true;
            TestFinished operations = new TestFinished(this, true, pojo.getUsername(), list_myelements, alltest, answers);
            operations.show();
        }
    }

    private final boolean cont;

    public TestStart(String username, boolean continuet) {
        if (username != null) {
            pojo = accountSQL.getAccountPojo(username);
        }
        cont = continuet;
        initComponents();
        start();
        insertlist();
        timeover();
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

        rdgroup = new javax.swing.ButtonGroup();
        tgbutton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_testdetails = new javax.swing.JList();
        btn_next = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_over = new javax.swing.JButton();
        lbl_pic = new javax.swing.JLabel();
        pic_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tg_a = new javax.swing.JToggleButton();
        tg_b = new javax.swing.JToggleButton();
        tg_c = new javax.swing.JToggleButton();
        tg_e = new javax.swing.JToggleButton();
        tg_d = new javax.swing.JToggleButton();
        tg_h = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_alltest = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_question = new javax.swing.JTextArea();
        variant_panel = new javax.swing.JPanel();
        rd_a = new javax.swing.JRadioButton();
        rd_b = new javax.swing.JRadioButton();
        rd_e = new javax.swing.JRadioButton();
        rd_d = new javax.swing.JRadioButton();
        rd_c = new javax.swing.JRadioButton();
        hide_btn = new javax.swing.JRadioButton();
        btn_full = new javax.swing.JButton();
        lbl_details1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblUserDetails = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Test Maker");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(815, 610));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(815, 150));
        jPanel1.setLayout(null);

        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        list_testdetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(153, 51, 255))); // NOI18N
        list_testdetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        list_testdetails.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_testdetails.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_testdetails.setMinimumSize(new java.awt.Dimension(61, 154));
        list_testdetails.setPreferredSize(new java.awt.Dimension(61, 154));
        list_testdetails.setVisibleRowCount(6);
        list_testdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_testdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_testdetails);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(640, 10, 140, 190);

        btn_next.setBackground(new java.awt.Color(255, 255, 255));
        btn_next.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btn_next.setForeground(new java.awt.Color(153, 51, 255));
        btn_next.setText("Next >>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        jPanel1.add(btn_next);
        btn_next.setBounds(590, 490, 190, 50);

        btn_prev.setBackground(new java.awt.Color(255, 255, 255));
        btn_prev.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btn_prev.setForeground(new java.awt.Color(153, 51, 255));
        btn_prev.setText("<< Previous");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });
        jPanel1.add(btn_prev);
        btn_prev.setBounds(10, 490, 190, 50);

        btn_over.setBackground(new java.awt.Color(255, 255, 255));
        btn_over.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btn_over.setForeground(new java.awt.Color(153, 51, 255));
        btn_over.setText("Finish");
        btn_over.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overActionPerformed(evt);
            }
        });
        jPanel1.add(btn_over);
        btn_over.setBounds(270, 490, 270, 50);
        jPanel1.add(lbl_pic);
        lbl_pic.setBounds(170, 10, 460, 240);

        pic_panel.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("2");
        pic_panel.add(jLabel1);
        jLabel1.setBounds(270, 80, 20, 20);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("3");
        pic_panel.add(jLabel2);
        jLabel2.setBounds(430, 80, 20, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("4");
        pic_panel.add(jLabel3);
        jLabel3.setBounds(120, 200, 20, 20);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("5");
        pic_panel.add(jLabel4);
        jLabel4.setBounds(270, 200, 20, 20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("1");
        pic_panel.add(jLabel5);
        jLabel5.setBounds(120, 80, 20, 20);

        tg_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tg_aActionPerformed(evt);
            }
        });
        pic_panel.add(tg_a);
        tg_a.setBounds(0, 0, 148, 110);

        tg_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tg_bActionPerformed(evt);
            }
        });
        pic_panel.add(tg_b);
        tg_b.setBounds(155, 0, 148, 110);

        tg_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tg_cActionPerformed(evt);
            }
        });
        pic_panel.add(tg_c);
        tg_c.setBounds(310, 0, 148, 110);

        tg_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tg_eActionPerformed(evt);
            }
        });
        pic_panel.add(tg_e);
        tg_e.setBounds(155, 117, 148, 110);

        tg_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tg_dActionPerformed(evt);
            }
        });
        pic_panel.add(tg_d);
        tg_d.setBounds(0, 117, 148, 110);
        pic_panel.add(tg_h);
        tg_h.setBounds(310, 117, 148, 110);

        jPanel1.add(pic_panel);
        pic_panel.setBounds(170, 10, 460, 240);

        jScrollPane2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        list_alltest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tests", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(153, 51, 255))); // NOI18N
        list_alltest.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        list_alltest.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_alltest.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_alltest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_alltestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(list_alltest);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 150, 240);

        txt_question.setEditable(false);
        txt_question.setColumns(20);
        txt_question.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_question.setRows(2);
        jScrollPane3.setViewportView(txt_question);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 300, 770, 88);

        rd_a.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rd_a.setText("jRadioButton1");
        rd_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_aMouseClicked(evt);
            }
        });
        rd_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_aActionPerformed(evt);
            }
        });

        rd_b.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rd_b.setText("jRadioButton2");
        rd_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_bMouseClicked(evt);
            }
        });
        rd_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_bActionPerformed(evt);
            }
        });

        rd_e.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rd_e.setText("jRadioButton3");
        rd_e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_eMouseClicked(evt);
            }
        });
        rd_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_eActionPerformed(evt);
            }
        });

        rd_d.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rd_d.setText("jRadioButton4");
        rd_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_dMouseClicked(evt);
            }
        });
        rd_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_dActionPerformed(evt);
            }
        });

        rd_c.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rd_c.setText("jRadioButton5");
        rd_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_cMouseClicked(evt);
            }
        });
        rd_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_cActionPerformed(evt);
            }
        });

        hide_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hide_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout variant_panelLayout = new javax.swing.GroupLayout(variant_panel);
        variant_panel.setLayout(variant_panelLayout);
        variant_panelLayout.setHorizontalGroup(
            variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variant_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_a)
                    .addComponent(rd_d))
                .addGap(76, 76, 76)
                .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_b)
                    .addComponent(rd_e))
                .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(variant_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hide_btn)
                        .addGap(194, 194, 194))
                    .addGroup(variant_panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(rd_c)
                        .addContainerGap(72, Short.MAX_VALUE))))
        );
        variant_panelLayout.setVerticalGroup(
            variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(variant_panelLayout.createSequentialGroup()
                .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(variant_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_d))
                    .addGroup(variant_panelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(variant_panelLayout.createSequentialGroup()
                                .addGroup(variant_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rd_b)
                                    .addComponent(rd_c))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rd_e))
                            .addGroup(variant_panelLayout.createSequentialGroup()
                                .addComponent(rd_a)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hide_btn)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel1.add(variant_panel);
        variant_panel.setBounds(10, 400, 770, 80);

        btn_full.setBackground(new java.awt.Color(255, 255, 255));
        btn_full.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btn_full.setForeground(new java.awt.Color(153, 51, 255));
        btn_full.setText("Full Screen");
        btn_full.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        btn_full.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fullActionPerformed(evt);
            }
        });
        jPanel1.add(btn_full);
        btn_full.setBounds(640, 210, 140, 40);

        lbl_details1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_details1.setForeground(new java.awt.Color(153, 51, 255));
        lbl_details1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_details1);
        lbl_details1.setBounds(10, 260, 770, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(815, 30));
        jPanel3.setLayout(null);

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(102, 0, 153));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("Easy Test Maker");
        lblTime.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblTime.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel3.add(lblTime);
        lblTime.setBounds(420, 0, 360, 30);

        lblUserDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblUserDetails.setForeground(new java.awt.Color(102, 0, 153));
        lblUserDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserDetails.setText("Easy Test Maker");
        lblUserDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        lblUserDetails.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel3.add(lblUserDetails);
        lblUserDetails.setBounds(10, 0, 417, 30);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioisntselected() {
        hide_btn.setSelected(true);
    }
    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        radioisntselected();
        list_alltest.setSelectedIndex(list_alltest.getSelectedIndex() + 1);
        list_alltestMouseClicked(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        radioisntselected();
        list_alltest.setSelectedIndex(list_alltest.getSelectedIndex() - 1);
        list_alltestMouseClicked(null);// TODO add your handling code here:
    }//GEN-LAST:event_btn_prevActionPerformed
    public void finish() {
        btn_overActionPerformed(null);
    }
    private void btn_overActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overActionPerformed
        if (pacientdied) {
            EasyTestMaker operations = new EasyTestMaker(pojo.getUsername());
            this.dispose();
            this.setVisible(false);
            operations.show();
        } else {
            testover();
            pacientdied = true;
            btn_over.setText("Return Main Menu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_overActionPerformed
    private void insertDetails(TestsPojo pojoe) {
        Vector<String> details = new Vector<>();
        details.add("Language 1 : " + AllLanguage.getLanguage(pojoe.getLang1()));
        details.add("Language 2 : " + AllLanguage.getLanguage(pojoe.getLang2()));
        details.add("Level : " + az.shahin.tests.Level.getLevel(pojoe.getLevel()));
        details.add("Rating : " + az.shahin.tests.Rate.getRating(pojoe.getRating()));
        details.add("Score : " + pojoe.getScore());
        details.add("Date : " + pojoe.getDate().toGMTString());
        list_testdetails.setListData(details.toArray());
    }

    private void saveData() {
        List<TestPojo> forXML = new ArrayList<>();
        for (int i = 0; i < alltest.size(); i++) {
            System.out.println(i);
            TestPojo XMLPojo = alltest.get(i);
            XMLPojo.setTestId(list_myelements.get(i).getId());
            if (answers.get(i) == null) {
                XMLPojo.setMyselected(5);
            } else {
                XMLPojo.setMyselected(answers.get(i));
            }
            forXML.add(XMLPojo);
        }
        try {
            XMLContinue conti = new XMLContinue(pojo.getId());
            conti.setSeconds(seconds);
            conti.createXML(forXML, pojo.getId());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void list_alltestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_alltestMouseClicked
        if (list_alltest.getSelectedIndex() > -1) {
            //list_alltest.setSelectionBackground(Color.YELLOW);
            TestsPojo pojotest = list_myelements.get(list_alltest.getSelectedIndex());
            setPictureIcon(pojotest.getPicture());
            insertDetails(pojotest);
            buttonsetting();
            startTest();
            radioisntselected();
            if (answers.get(list_alltest.getSelectedIndex()) != null && answers.get(list_alltest.getSelectedIndex()) != 5) {
                switch (answers.get(list_alltest.getSelectedIndex())) {
                    case 0:
                        rd_a.setSelected(true);
                        break;
                    case 1:
                        rd_b.setSelected(true);
                        break;
                    case 2:
                        rd_c.setSelected(true);
                        break;
                    case 3:
                        rd_d.setSelected(true);
                        break;
                    case 4:
                        rd_e.setSelected(true);
                        break;
                }
            }
        }
    }//GEN-LAST:event_list_alltestMouseClicked
    private void startTest() {
        TestPojo pojoe = alltest.get(list_alltest.getSelectedIndex());
        pic_panel.setVisible(false);
        lbl_pic.setVisible(true);
        List<String> icons = pojoe.getAnswers();
        if (pojoe.getMode() == 2) {
            setPictureIcon2(tg_a, icons.get(0));
            setPictureIcon2(tg_b, icons.get(1));
            setPictureIcon2(tg_c, icons.get(2));
            setPictureIcon2(tg_d, icons.get(3));
            setPictureIcon2(tg_e, icons.get(4));
        }
        switch (pojoe.getMode()) {
            case 0:
                txt_question.setText("Translate this word : " + list_myelements.get(list_alltest.getSelectedIndex()).getQuestion() + "\nFrom " + AllLanguage.getLanguage(list_myelements.get(list_alltest.getSelectedIndex()).getLang1()) + " to " + AllLanguage.getLanguage(list_myelements.get(list_alltest.getSelectedIndex()).getLang2()));
                break;
            case 1:
                txt_question.setText("Translate this word : " + list_myelements.get(list_alltest.getSelectedIndex()).getAnswer() + "\nFrom " + AllLanguage.getLanguage(list_myelements.get(list_alltest.getSelectedIndex()).getLang2()) + " to " + AllLanguage.getLanguage(list_myelements.get(list_alltest.getSelectedIndex()).getLang1()));
                break;
            case 2:
                lbl_pic.setVisible(false);
                pic_panel.setVisible(true);
                txt_question.setText("Select picture : " + list_myelements.get(list_alltest.getSelectedIndex()).getAnswer() + " ( in " + AllLanguage.getLanguage(list_myelements.get(list_alltest.getSelectedIndex()).getLang2()) + ")");
                break;
        }
        for (int i = 0; i < pojoe.getAnswers().size(); i++) {
            switch (i) {
                case 0:
                    rd_a.setText("A)" + (pojoe.getMode() != 2 ? pojoe.getAnswers().get(i) : (" " + String.valueOf(i + 1))));
                    break;
                case 1:
                    rd_b.setText("B)" + (pojoe.getMode() != 2 ? pojoe.getAnswers().get(i) : (" " + String.valueOf(i + 1))));
                case 2:
                    rd_c.setText("C)" + (pojoe.getMode() != 2 ? pojoe.getAnswers().get(i) : (" " + String.valueOf(i + 1))));
                    break;
                case 3:
                    rd_d.setText("D)" + (pojoe.getMode() != 2 ? pojoe.getAnswers().get(i) : (" " + String.valueOf(i + 1))));
                    break;
                case 4:
                    rd_e.setText("E)" + (pojoe.getMode() != 2 ? pojoe.getAnswers().get(i) : (" " + String.valueOf(i + 1))));
                    break;
            }
        }
    }

    private void slideshow() {
        Thread slideshow = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 300;
                while (true) {
                    if (i == 1800) {
                        list_testdetails.setSelectedIndex(5);

                        i = 0;
                    } else if (i == 1500) {
                        list_testdetails.setSelectedIndex(4);

                    } else if (i == 1200) {
                        list_testdetails.setSelectedIndex(3);

                    } else if (i == 900) {
                        list_testdetails.setSelectedIndex(2);

                    } else if (i == 600) {
                        list_testdetails.setSelectedIndex(1);

                    } else if (i == 300) {
                        list_testdetails.setSelectedIndex(0);
                    }

                    try {
                        lbl_details1.setText(list_testdetails.getSelectedValue().toString());
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException ex) {
                        i = 299;
// Logger.getLogger(TestStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        });
        slideshow.start();
    }

    private void buttonsetting() {
        if (list_alltest.getSelectedIndex() == 0) {
            btn_prev.setEnabled(false);
            btn_next.setEnabled(true);
        } else if (list_alltest.getSelectedIndex() == list_myelements.size() - 1) {
            btn_prev.setEnabled(true);
            btn_next.setEnabled(false);
        } else {
            btn_prev.setEnabled(true);
            btn_next.setEnabled(true);
        }

        if (path.length() < 2) {
            btn_full.setEnabled(false);
        } else {
            btn_full.setEnabled(true);
        }
    }
    private void btn_fullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fullActionPerformed
        OpenFile.openFile(new File("img/" + (path.endsWith(".jpg") ? path : path + ".jpg")));
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fullActionPerformed

    private void list_testdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_testdetailsMouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_list_testdetailsMouseClicked

    private void rd_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_aMouseClicked
        answers.put(list_alltest.getSelectedIndex(), 0);        // TODO add your handling code here:
    }//GEN-LAST:event_rd_aMouseClicked

    private void rd_bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_bMouseClicked
        answers.put(list_alltest.getSelectedIndex(), 1);         // TODO add your handling code here:
    }//GEN-LAST:event_rd_bMouseClicked

    private void rd_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_cMouseClicked
        answers.put(list_alltest.getSelectedIndex(), 2);         // TODO add your handling code here:
    }//GEN-LAST:event_rd_cMouseClicked

    private void rd_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_dMouseClicked
        answers.put(list_alltest.getSelectedIndex(), 3);         // TODO add your handling code here:
    }//GEN-LAST:event_rd_dMouseClicked

    private void rd_eMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_eMouseClicked
        answers.put(list_alltest.getSelectedIndex(), 4);         // TODO add your handling code here:
    }//GEN-LAST:event_rd_eMouseClicked

    private void rd_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_eActionPerformed
        // TODO add your handling code here:
        answers.put(list_alltest.getSelectedIndex(), 4);
        saveData();
    }//GEN-LAST:event_rd_eActionPerformed

    private void rd_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_bActionPerformed
        // TODO add your handling code here:
        answers.put(list_alltest.getSelectedIndex(), 1);
        saveData();
    }//GEN-LAST:event_rd_bActionPerformed

    private void rd_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_aActionPerformed
        answers.put(list_alltest.getSelectedIndex(), 0);
        saveData();// TODO add your handling code here:
    }//GEN-LAST:event_rd_aActionPerformed

    private void rd_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_cActionPerformed
        answers.put(list_alltest.getSelectedIndex(), 2);
        saveData();// TODO add your handling code here:
    }//GEN-LAST:event_rd_cActionPerformed

    private void rd_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_dActionPerformed
        // TODO add your handling code here:
        answers.put(list_alltest.getSelectedIndex(), 3);
        saveData();
    }//GEN-LAST:event_rd_dActionPerformed

    private void tg_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tg_aActionPerformed
        this.path = alltest.get(list_alltest.getSelectedIndex()).getAnswers().get(0);
        rd_a.setSelected(true);
        rd_aActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_tg_aActionPerformed

    private void tg_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tg_bActionPerformed
        this.path = alltest.get(list_alltest.getSelectedIndex()).getAnswers().get(1);
        rd_b.setSelected(true);// TODO add your handling code here:
        rd_bActionPerformed(evt);
    }//GEN-LAST:event_tg_bActionPerformed

    private void tg_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tg_cActionPerformed
        rd_c.setSelected(true);
        rd_cActionPerformed(evt);
        this.path = alltest.get(list_alltest.getSelectedIndex()).getAnswers().get(2);        // TODO add your handling code here:
    }//GEN-LAST:event_tg_cActionPerformed

    private void tg_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tg_dActionPerformed
        rd_d.setSelected(true);
        rd_dActionPerformed(evt);
        this.path = alltest.get(list_alltest.getSelectedIndex()).getAnswers().get(3);        // TODO add your handling code here:
    }//GEN-LAST:event_tg_dActionPerformed

    private void tg_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tg_eActionPerformed

        rd_e.setSelected(true);
        rd_eActionPerformed(evt);
        this.path = alltest.get(list_alltest.getSelectedIndex()).getAnswers().get(4);        // TODO add your handling code here:
    }//GEN-LAST:event_tg_eActionPerformed

    private void hide_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hide_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hide_btnActionPerformed
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
            java.util.logging.Logger.getLogger(TestStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new TestStart("Admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_full;
    public javax.swing.JButton btn_next;
    public javax.swing.JButton btn_over;
    public javax.swing.JButton btn_prev;
    public javax.swing.JRadioButton hide_btn;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblTime;
    public javax.swing.JLabel lblUserDetails;
    public javax.swing.JLabel lbl_details1;
    public javax.swing.JLabel lbl_pic;
    public javax.swing.JList list_alltest;
    public javax.swing.JList list_testdetails;
    public javax.swing.JPanel pic_panel;
    public javax.swing.JRadioButton rd_a;
    public javax.swing.JRadioButton rd_b;
    public javax.swing.JRadioButton rd_c;
    public javax.swing.JRadioButton rd_d;
    public javax.swing.JRadioButton rd_e;
    public javax.swing.ButtonGroup rdgroup;
    public javax.swing.JToggleButton tg_a;
    public javax.swing.JToggleButton tg_b;
    public javax.swing.JToggleButton tg_c;
    public javax.swing.JToggleButton tg_d;
    public javax.swing.JToggleButton tg_e;
    public javax.swing.JToggleButton tg_h;
    public javax.swing.ButtonGroup tgbutton;
    public javax.swing.JTextArea txt_question;
    public javax.swing.JPanel variant_panel;
    // End of variables declaration//GEN-END:variables
}
