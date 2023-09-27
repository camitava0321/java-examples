package com.amc.demo.gui;
/* Applet2 : Use of TextField Control in swing
 *
 * The following code is to view the class in AppletViewer


   <applet code=Applet2 width=350 height=75>
   </applet>

 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Applet2 extends JApplet {

    /* Getting reference of two button and a textfield */
    JButton cmdGetText = new JButton("Get Text");
    JButton cmdSetText = new JButton("Set Text");
    JTextField txtInput = new JTextField("Initial Text :",30);

    String szTemp = new String();

    /*Implementation of actionlisteners
     * The actionlisteners are implemented as anonymous class
     * Reason being we don't need more than one instance of the
     * actionlisteners */
    ActionListener alGetText = new ActionListener (){
        public void actionPerformed(ActionEvent e) {

            getAppletContext().showStatus(txtInput.getText());

            szTemp = txtInput.getSelectedText();
            if (szTemp==null){
                szTemp = txtInput.getText();
            }
            txtInput.setEditable(true);
        }
    };

    ActionListener alSetText = new ActionListener (){
        public void actionPerformed(ActionEvent e) {
            txtInput.setText("Inserted By Button 2 : " + szTemp );
            txtInput.setEditable(false);
        }
    };


    /* Init Method of the Applet */
    public void init(){

    /* Making the controls able to handle the events */
    cmdGetText.addActionListener(alGetText);
    cmdSetText.addActionListener(alSetText);

    /* A new container */
    Container contApplet = getContentPane();
    contApplet.setLayout(new FlowLayout());

    /* Adding controls to the container */
    contApplet.add(cmdGetText);
    contApplet.add(cmdSetText);
    contApplet.add(txtInput);

    }

}
