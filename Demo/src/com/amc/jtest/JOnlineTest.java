package com.amc.jtest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JOnlineTest extends JFrame {
    
    public JOnlineTest() {
        initComponents();
    }
    
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        jSplitPane1 = new JSplitPane();
        pnl_0 = new JPanel();
        pnl_0_1 = new JPanel();
        jLabel1 = new JLabel();
        cbProject = new JComboBox();
        pnl_0_2 = new JPanel();
        jLabel2 = new JLabel();
        cbSubject = new JComboBox();
        pnl_0_3 = new JPanel();
        btnGo = new JButton();
        jPanel5 = new JPanel();
        jLabel7 = new JLabel();
        pnl_1 = new JPanel();
        pnl_1_1 = new JPanel();
        jLabel3 = new JLabel();
        txtAssociateID = new JTextField(5);
        jLabel4 = new JLabel();
        txtName = new JTextField(10);
        pnl_1_2 = new JPanel();
        txtAreaQuestion = new JTextArea();
        jLabel5 = new JLabel();
        pnl_1_3 = new JPanel();
        pnl_1_3_2 = new JPanel();
        rdBtnChoice1 = new JRadioButton();
        rdBtnChoice2 = new JRadioButton();
        rdBtnChoice3 = new JRadioButton();
        rdBtnChoice4 = new JRadioButton();
        pnl_1_3_3 = new JPanel();
        btnNext = new JButton();
        btnMark = new JButton();

        getContentPane().setLayout(new GridLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Online Test");
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setContinuousLayout(true);
        jSplitPane1.setOneTouchExpandable(true);
        pnl_0.setLayout(new GridBagLayout());

        pnl_0.setBorder(new CompoundBorder(new SoftBevelBorder(BevelBorder.RAISED), 
			                   new EmptyBorder(new Insets(5, 5, 5, 5))));
        pnl_0_1.setLayout(new GridLayout(2, 1));

        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel1.setText("Project");
        jLabel1.setHorizontalTextPosition(SwingConstants.LEFT);
        pnl_0_1.add(jLabel1);

        pnl_0_1.add(cbProject);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = -12;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(2, 2, 0, 0);
        pnl_0.add(pnl_0_1, gridBagConstraints);

        pnl_0_2.setLayout(new GridLayout(2, 1));

        jLabel2.setText("Subject");
        pnl_0_2.add(jLabel2);

        pnl_0_2.add(cbSubject);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = -12;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(2, 2, 0, 0);
        pnl_0.add(pnl_0_2, gridBagConstraints);

        pnl_0_3.setLayout(new FlowLayout(FlowLayout.LEFT));

        btnGo.setMnemonic('G');
        btnGo.setText("Go");
        pnl_0_3.add(btnGo);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new Insets(2, 2, 0, 0);
        pnl_0.add(pnl_0_3, gridBagConstraints);

        jPanel5.add(jLabel7);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new Insets(2, 2, 55, 0);
        pnl_0.add(jPanel5, gridBagConstraints);

        jSplitPane1.setLeftComponent(pnl_0);

        pnl_1.setLayout(new BoxLayout(pnl_1, BoxLayout.Y_AXIS));

        pnl_1.setBorder(new CompoundBorder(new SoftBevelBorder(BevelBorder.RAISED), 
			                   new EmptyBorder(new Insets(5, 5, 5, 5))));
        pnl_1_1.setLayout(new FlowLayout(FlowLayout.LEFT));

        jLabel3.setText("Associate ID");
        pnl_1_1.add(jLabel3);

        txtAssociateID.setText("");
        pnl_1_1.add(txtAssociateID);

        jLabel4.setText("Name");
        pnl_1_1.add(jLabel4);

        txtName.setText("");
        pnl_1_1.add(txtName);

        pnl_1.add(pnl_1_1);

        pnl_1_2.setLayout(new BorderLayout());

        txtAreaQuestion.setEditable(false);
        txtAreaQuestion.setLineWrap(true);
        txtAreaQuestion.setRows(5);
        txtAreaQuestion.setWrapStyleWord(true);
        txtAreaQuestion.setEnabled(false);
        pnl_1_2.add(txtAreaQuestion, BorderLayout.CENTER);

        jLabel5.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel5.setText("Question");
        jLabel5.setVerticalAlignment(SwingConstants.BOTTOM);
        pnl_1_2.add(jLabel5, BorderLayout.NORTH);

        pnl_1.add(pnl_1_2);

        pnl_1_3.setLayout(new GridLayout(3, 1));

        pnl_1_3_2.setLayout(new GridLayout(2, 2));

        pnl_1_3_2.setBorder(new TitledBorder("Answer"));
        rdBtnChoice1.setText("Choice1");
        pnl_1_3_2.add(rdBtnChoice1);

        rdBtnChoice2.setText("Choice2");
        pnl_1_3_2.add(rdBtnChoice2);

        rdBtnChoice3.setText("Choice3");
        pnl_1_3_2.add(rdBtnChoice3);

        rdBtnChoice4.setText("Choice4");
        pnl_1_3_2.add(rdBtnChoice4);

        pnl_1_3.add(pnl_1_3_2);

        pnl_1_3_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        btnNext.setMnemonic('N');
        btnNext.setText("Next");

        pnl_1_3_3.add(btnNext);

        btnMark.setMnemonic('M');
        btnMark.setText("Mark");
        pnl_1_3_3.add(btnMark);

        pnl_1_3.add(pnl_1_3_3);

        pnl_1.add(pnl_1_3);

        jSplitPane1.setRightComponent(pnl_1);

        getContentPane().add(jSplitPane1);

        pack();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JOnlineTest().setVisible(true);
            }
        });
    }
    
    private JButton btnGo;
    private JButton btnMark;
    private JButton btnNext;
    private JComboBox cbProject;
    private JComboBox cbSubject;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JPanel jPanel5;
    private JSplitPane jSplitPane1;
    private JPanel pnl_0;
    private JPanel pnl_0_1;
    private JPanel pnl_0_2;
    private JPanel pnl_0_3;
    private JPanel pnl_1;
    private JPanel pnl_1_1;
    private JPanel pnl_1_2;
    private JPanel pnl_1_3;
    private JPanel pnl_1_3_2;
    private JPanel pnl_1_3_3;
    private JRadioButton rdBtnChoice1;
    private JRadioButton rdBtnChoice2;
    private JRadioButton rdBtnChoice3;
    private JRadioButton rdBtnChoice4;
    private JTextArea txtAreaQuestion;
    private JTextField txtAssociateID;
    private JTextField txtName;
    
}
