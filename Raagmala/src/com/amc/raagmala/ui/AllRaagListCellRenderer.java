package com.amc.raagmala.ui;
import java.awt.*;
import javax.swing.*;

import com.amc.raagmala.vo.Raag;

public class AllRaagListCellRenderer extends DefaultListCellRenderer 
{

  public Component getListCellRendererComponent(
         JList list,
         Object value,
         int index,
         boolean isSelected,
         boolean cellHasFocus)
     {
      JLabel lbl = 
        (JLabel)super.getListCellRendererComponent(
          list,value,index,isSelected,cellHasFocus);

         if (value instanceof Raag)
         {
         lbl.setText(value.toString()
           +" ("
           +((Raag)value).getThaat().toString()
           +")"); 
         }
         else
         {
         lbl.setText("AllRaagListCellRenderer : Not a Raag Object");
         }
         return(lbl);
     }
 
}
