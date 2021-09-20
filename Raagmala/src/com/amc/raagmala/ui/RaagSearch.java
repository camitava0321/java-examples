package com.amc.raagmala.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.amc.raagmala.data.RaagDataImplDBX;
import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;

public class RaagSearch extends JDialog 
{
  public static final String []ITEMS = 
  {
    "Name","Jati","Aroha","Aboroha","Vadi","Samvadi",
    "Ras","Prokriti","Time"
  };

  Box boxItem = new Box(BoxLayout.X_AXIS);
  JLabel lblItem = new JLabel("Select Item");
  JComboBox cboItem = new JComboBox();
  JTextField txtItem = new JTextField(10);
  JButton cmdSearch = new JButton("Search");
  public Raag []resultRaags;
  Vector vecResult;
  public boolean fSearch=false;

  public RaagSearch(Frame owner)
  {
    super(owner);
    boxItem.add(lblItem);
    boxItem.createRigidArea(new Dimension(5,0));
    boxItem.add(cboItem);
    boxItem.createHorizontalStrut(5);
    boxItem.add(txtItem);
    boxItem.createHorizontalGlue();
    boxItem.add(cmdSearch);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(boxItem);

          cmdSearch.addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  fSearch=search();
                  dispose();
              };
          }
      );
    
    setSize(500,55);
    setModal(true);
    setResizable(false);
    setTitle("Search Panel");
    setLocation(50,50);
    
    populateItemCombo();
  }

  private void populateItemCombo()
  {
    for (int i=0;i<ITEMS.length ;i++ )
    {
      cboItem.addItem(ITEMS[i]);
    }
  }

  private boolean search()
  {
    boolean fReturn=false;
    String searchString=txtItem.getText();
    if (searchString.length()>0)
      {
      try
      {
      Raag []raags = new RaagDataImplDBX().getAllRaags();
      vecResult = new Vector();
      int index=cboItem.getSelectedIndex();

      switch(index)
        {
        case 0:
          searchString=searchString.toUpperCase();
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].toString().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 1:
          searchString=searchString.toUpperCase();
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getJatiDescription().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 2:
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getAroha().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 3:
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getAboroha().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 4:
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getVadi().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 5:
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getSamvadi().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 6:
          searchString=searchString.toUpperCase();
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getRas().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 7:
          searchString=searchString.toUpperCase();
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getProkriti().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        case 8:
          searchString=searchString.toUpperCase();
          for (int i=0;i<raags.length ;i++ )
            {
            if (raags[i].getTime().indexOf(searchString)>=0)
              {
              vecResult.add(raags[i]);
              }
            }
          break;
        }
      }catch(RaagDataException exc)
        {
        fReturn=false;
        vecResult=null;
        exc.printStackTrace();
        }
      }
  return(fReturn);
  }
  
  public Raag[] getResultRaags()
  {
    if (vecResult!=null && vecResult.size()>0)
    {
    resultRaags = new Raag[vecResult.size()];
      for (int i=0;i<vecResult.size() ;i++ )
      {
      resultRaags[i] = (Raag)vecResult.elementAt(i);
      }
    }
  return(resultRaags);
  }

}
