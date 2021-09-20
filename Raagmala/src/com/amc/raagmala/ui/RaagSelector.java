package com.amc.raagmala.ui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionListener;

import com.amc.raagmala.data.RaagDataImplDBX;
import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;
import com.amc.raagmala.vo.Thaat;

public class RaagSelector extends JComponent
{
EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED);

    private JComboBox cboThaats = new JComboBox();

    private JList lstRaags = new JList();
    private JScrollPane scrollList = new JScrollPane(lstRaags);

  private RaagDataImplDBX data;
  public Raag raag;
  public Raag []raags;
  public boolean fExternalData;

  public RaagSelector() throws RaagDataException
  {
    cboThaats.setBorder(BorderFactory.createCompoundBorder(
                      BorderFactory.createTitledBorder("Thaats"),
                      BorderFactory.createEmptyBorder(2,1,2,1)));

    lstRaags.setBorder(BorderFactory.createCompoundBorder(
                      BorderFactory.createTitledBorder("Raags"),
                      BorderFactory.createEmptyBorder(2,1,2,1)));

    setLayout(new BorderLayout());
    add(cboThaats,BorderLayout.NORTH);
    add(scrollList);

    data = new RaagDataImplDBX();
    refresh();

    cboThaats.addItemListener(
      new ItemListener()
      {
        public void itemStateChanged(ItemEvent e)
        {
          if(e.getStateChange()==ItemEvent.SELECTED)
            {
              try
              {
              populateRaags();
              }catch(RaagDataException ex)
              {
                System.out.println(ex.getMessage());
              }
            }
        }
      });

  }

  public void refresh() throws RaagDataException 
  {
    populateThaats();
    populateRaags();
  }

  public void populateThaats() throws RaagDataException
  {
  Thaat []thaats = data.getAllThaats(); 
  if(thaats!=null)
    {
      for(int i=0;i<thaats.length;i++)
      {
        cboThaats.addItem(thaats[i]);
      }
    }
  }

  public void populateRaags() throws RaagDataException
  {
  Thaat thaat = (Thaat)cboThaats.getSelectedItem();

    raags = data.getAllRaags(thaat);

    if(raags!=null)
      {
      Arrays.sort(raags, new Raag());
      lstRaags.setCellRenderer(new DefaultListCellRenderer());
      lstRaags.setListData(raags);
      fExternalData=false;
      }
  }

  public void displayAllRaags() throws RaagDataException
  {
  raags = data.getAllRaags();
    if(raags!=null)
      {
      Arrays.sort(raags, new Raag());
      lstRaags.setCellRenderer(new AllRaagListCellRenderer());
      lstRaags.setListData(raags);
      fExternalData=false;
      }
  }

  public Raag getSelectedRaag()
  {
    if (isSelected())
    {
    raag = (Raag)lstRaags.getSelectedValue();
    }
    else
    {
      raag=null;
    }
  return(raag);
  }

  public Thaat getSelectedThaat()
  {
  Thaat thaat = (Thaat)cboThaats.getSelectedItem();
  return(thaat);
  }

  public boolean isSelected()
  {
    boolean fReturn=false;
    if (lstRaags.getSelectedIndex()>-1)
    {
      fReturn=true;
    }
    return(fReturn);
  }

  public void addListSelectionListener(ListSelectionListener ll)
  {
    lstRaags.addListSelectionListener(ll);
  }

  public void setRaags(Raag []rs)
  {
    raags=rs;
    if (raags!=null)
      {
      Arrays.sort(raags, new Raag());
      }
    lstRaags.setCellRenderer(new AllRaagListCellRenderer());
    lstRaags.setListData(raags);
    fExternalData=true;
  }
  
  public boolean isExternalData()
  {
  return(fExternalData);
  }

  public Raag[] getRaags()
  {
  return(raags);
  }
}
