package com.amc.demo.gui;
/* Applet3 : Use of Label and TextArea Control in swing
 *
 * The following code is to view the class in AppletViewer


   <applet code=Applet3 width=350 height=300>
   </applet>

 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Applet3 extends JApplet {

  /* Getting reference of the controls */
  JButton
    cmdTo = new JButton("To Area2"), 
    cmdFrom = new JButton("To Area1");

  JLabel
    lblArea1 = new JLabel("Text Area 1"),
    lblArea2 = new JLabel("Text Area 2");
  JTextArea 
    txtArea1 = new JTextArea("t1", 2, 30),
    txtArea2 = new JTextArea("t2", 6, 30);


  /*Implementation of actionlisteners
   * The actionlisteners are implemented as anonymous class
   * Reason being we don't need more than one instance of the
   * actionlisteners */
  ActionListener alToArea2 = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      getAppletContext().showStatus("Copying " + txtArea1.getText() + " to TextArea2");
      txtArea2.setText(txtArea1.getText());
    }
  };
  ActionListener alToArea1 = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      getAppletContext().showStatus("Copying " + txtArea2.getText() + " to TextArea1");
      txtArea1.setText(txtArea2.getText());
      //t2.append(": " + t1.getText());
    }
  };

  /* Init Method of the Applet */
  public void init() {

    /* Making the controls able to handle the events */
    cmdTo.addActionListener(alToArea2);
    cmdFrom.addActionListener(alToArea1);

    try {
          UIManager.setLookAndFeel(UIManager.
            getSystemLookAndFeelClassName());
        } catch (Exception ex) { }

    /* A new container */
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());

    /* Adding controls to the container */
    cp.add(lblArea1);
    cp.add(txtArea1);
    cp.add(lblArea2);
    cp.add(txtArea2);
    cp.add(cmdTo);
    cp.add(cmdFrom);

  }
}
