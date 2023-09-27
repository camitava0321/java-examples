package com.amc.demo.gui;
/*****************************************************************************/
/* QUESTION 2                                                                */
/*****************************************************************************/
/** What is wrong with the following applet
 *  Fix the problems and write the HTML File 

    public class Test2 extends Applet
    {

        public void paint(graphics g)
        {
        g.drawrect(-20,-20,50);
        }
    }

    */

/*****************************************************************************/
/* ANSWER                                                                    */
/*****************************************************************************/
/** java.applet.*; must be imported
 *  java.awt.*       must be imported
 *  grphics should be Graphics
 *  drawrect should be drawRect
 *  no of drawRect parameters are wrong, should actually be four
 *  Compilation Errors

 *  The correct program is */


    import java.applet.*;
    import java.awt.*;

    public class Test2 extends Applet
    {

        public void paint(Graphics g)
        {
        g.drawRect(-20,-20,50, 50);
        }
    }

/* Following is the HTML
   <HTML>
   <APPLET CODE=Test2 HEIGHT=200 WIDTH=200>
   </APPLET>
   </HTML>
*/
 

