package com.amc.demo.gui;
/* Applet4 : Use of CheckBox and RadioButton Control in swing
 *
 * The following code is to view the class in AppletViewer


   <applet code=Applet4 width=350 height=300>
   </applet>

 */

import javax.swing.*;                        /* For Windows 95-98            */
import java.awt.event.*;
import java.awt.*;

public class Applet4 extends JApplet {

  /* Getting reference of the controls */
  JButton
    cmdClear = new JButton("Clear"); 

  JButton
    cmdRate = new JButton("Rate"); 

  JLabel
    lblArea = new JLabel("Happennings");

  JTextArea 
    txtArea = new JTextArea("", 10, 30);

  JLabel
    lblProduct = new JLabel("Products");

  JCheckBox
    cb1 = new JCheckBox("MS Windows"),
    cb2 = new JCheckBox("OS2"),
    cb3 = new JCheckBox("Solaris");

  JLabel
    lblRating = new JLabel("Ratings");

  ButtonGroup g = new ButtonGroup();
  JRadioButton
    rb1 = new JRadioButton("Excellent"),
    rb2 = new JRadioButton("Average"),
    rb3 = new JRadioButton("Down the gutter");

  String szProduct = new String();
  String szQualifier = new String();
  String szRate = new String();


  /*Implementation of actionlisteners
   * The actionlisteners are implemented as anonymous class
   * Reason being we don't need more than one instance of the
   * actionlisteners */
  ActionListener alClear = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      getAppletContext().showStatus("Clearing Happenings...");

      szProduct="";
      szQualifier="";
      szRate="Excellent";

      txtArea.setText("");

      cb1.setSelected(false);
      cb2.setSelected(false);
      cb3.setSelected(false);

      rb1.setSelected(true);

      
    }
  };

  ActionListener alRate = new ActionListener() {
    public void actionPerformed(ActionEvent e){

      if (szProduct!="")
      {
        getAppletContext().showStatus("Rated " + szProduct);
        txtArea.append(szProduct + szQualifier + szRate + "\n");
      }
    }
  };

  ActionListener alProduct = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      trace ((JCheckBox)e.getSource());
      szProduct = (((JCheckBox)e.getSource()).getText());
    }
  };

  ActionListener alRating = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      szRate = ((JRadioButton)e.getSource()).getText();
    }
  };


  /* Init Method of the Applet */
  public void init() {

    /* Making the controls able to handle the events */

    cmdClear.addActionListener(alClear);
    cmdRate.addActionListener(alRate);
    cb1.addActionListener(alProduct);
    cb2.addActionListener(alProduct);
    cb3.addActionListener(alProduct);

    rb1.addActionListener(alRating);
    rb2.addActionListener(alRating);
    rb3.addActionListener(alRating);

    try {
          UIManager.setLookAndFeel(UIManager.
            getSystemLookAndFeelClassName());
        } catch (Exception ex) { }

    /* A new container */
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());

    /* Adding controls to the container */
    cp.add(lblProduct);
    cp.add(cb1);
    cp.add(cb2);
    cp.add(cb3);

    cp.add(lblRating);
    g.add(rb1);
    g.add(rb2);
    g.add(rb3);
    cp.add(rb1);
    cp.add(rb2);
    cp.add(rb3);

    cp.add(lblArea);
    cp.add(txtArea);
    txtArea.setEditable(false);

    cp.add(cmdClear);
    cp.add(cmdRate);


    cmdClear.doClick();
    }


  void trace (JCheckBox cb){

      if (cb.isSelected()){
        szQualifier = " is ";
      }
      else {
        szQualifier = " is not ";
      }

  }

}
