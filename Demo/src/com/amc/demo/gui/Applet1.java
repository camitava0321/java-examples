package com.amc.demo.gui;
//: c12:Applet1.java
// Putting buttons on an applet

// The following html tag is used so that the java file may be
// run with AppletViewer - because AppletViewer always takes out
// applet tag from any file and run the code 
// <applet code=Applet1 width=200 height=50>
// </applet>


//import com.sun.java.swing.*;                  /* For OS2                     */
import javax.swing.*;                       /* For Windows                 */
import java.awt.event.*;
import java.awt.*;

public class Applet1 extends JApplet {
  JButton 
    b1 = new JButton("Button 1"),             /* Creates references of two   */
    b2 = new JButton("Button 2");             /* JButtons - swing            */

    /** Inner Class ButtonListener implements Events */
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e){  /* an interface method */
            String szName =
                ((JButton)e.getSource()).getText();
            getAppletContext().showStatus(szName);
        }
    }

  ButtonListener blButtons = new ButtonListener();

  /* Declaration of inner class ButtonListener and subsequently
   * creating blButtons as one instance of it may be ommited by
   * declaring the inner class as an anonymous inner class
   * the following code piece illustrates that
   
    ActionListener blButtons = new ActionListener {

        public void actionPerformed(ActionEvent e){
            String szName =
                ((JButton)e.getSource()).getText();
            getAppletContext().showStatus(szName);
        }
    }

    * You cannot create an instance of such class and in this case
    * you donot require more than one instance any way
    */

  public void init() {

    b1.addActionListener(blButtons);
    b2.addActionListener(blButtons);

    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(b1);
    cp.add(b2);
  }
} ///:~
