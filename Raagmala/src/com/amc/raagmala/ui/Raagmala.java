package com.amc.raagmala.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;

public class Raagmala extends JFrame
{
public static final String APP_ID="Raagmala 3.0.0";
public static final int MAX_WINDOWS=10;
public static final String menuNames[]=       /* Menu Names                  */
    {
    "File",                                   /* 0th Menu                    */
    "View",                                   /* 1st Menu                    */
    "Mode",                                   /* 2nd Menu                    */
    "Data",                                   /* 3rd Menu                    */
    "Help"                                    /* 4th Menu                    */
    };
public static final String menuItemNames[][]= /* Menu Item Names             */
    {
    {"Search","Close","Close All","Exit"},    /* Under 0th Menu              */
    /* Under 1st Menu              */
    {"All Raags"},           
    /* Under 2nd Menu              */
    {"Compare","Individual"},           
    /* Under 3rd Menu              */
    {"Report"},           
    /* Under 4th Menu              */
    {"Help"}                                  
    };

  RaagSelector selector;
  RaagPanel raag ; 
  private JSplitPane splitPane;
  Box bottomPanel = new Box(BoxLayout.X_AXIS);
    JLabel lblStatus = new JLabel();
    JProgressBar progressBar = new JProgressBar(0,100);
  CloseButton closeButton = new CloseButton();

private JTabbedPane tab = new JTabbedPane(SwingConstants.RIGHT);

// Menus
JMenuBar menubar = new JMenuBar();
    JMenu menus[] = new JMenu[menuNames.length];
        JMenuItem menuItems[][] = new JMenuItem[menuItemNames.length][30] ;

  public Raagmala()
  {
    try
    {
    selector = new RaagSelector();
    splitPane = new JSplitPane(
      JSplitPane.HORIZONTAL_SPLIT,
      selector,tab);

    splitPane.setOneTouchExpandable(true);
    setTitle(APP_ID);

    bottomPanel.add(lblStatus);
    bottomPanel.add(progressBar);
    splitPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    getContentPane().add(splitPane);
    getContentPane().add(bottomPanel,BorderLayout.SOUTH);
    
/*****************************************************************************/
/* Setting up the Menus                                                      */
/*****************************************************************************/
    setupMenus();

    selector.addListSelectionListener(
      new ListSelectionListener()
      {
        public void valueChanged(ListSelectionEvent e)
        {
          if (!e.getValueIsAdjusting())
            {
            try
            {
            addNewWindow();  
            }
            catch (Exception exc)
            {
              exc.printStackTrace();
            }
            }
        }
      });
    }catch(RaagDataException e)
    {
      System.out.println(e.getMessage());
      exit();
    }

    closeButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    closeCurrentTab();
                };
            }
        );



  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



  public void setupMenus()
  {
  int i=0, j=0;
      while(i<menuNames.length)
        {
        menus[i] = new JMenu(menuNames[i]);
        menus[i].setMnemonic(menuNames[i].charAt(0));
        j=0;
        while(j<menuItemNames[i].length)
          {
          menuItems[i][j] = new JMenuItem(menuItemNames[i][j]);
          menuItems[i][j].setMnemonic(menuItemNames[i][j].charAt(0));
          menus[i].add(menuItems[i][j]);
          j++;
          }
        if (menuNames[i].equals("Help"))
          {
          menubar.add(Box.createHorizontalGlue());
          }
        menubar.add(menus[i]);
        i++;
        }

      setJMenuBar(menubar);

/*****************************************************************************/
/* Setting up Menu Actions                                                   */
/*****************************************************************************/
      menuItems[0][0].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  openSearchDialog();
              };
          }
      );

      menuItems[0][1].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  closeCurrentTab();
              };
          }
      );

      menuItems[0][2].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  closeAllTabs();
              };
          }
      );

      menuItems[0][3].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  exit();
              };
          }
      );

      menuItems[1][0].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  try
                  {
                  showAllRaags();
                  }catch(RaagDataException ex)
                  {
                    System.out.println("Exception Occurred in displaying All Raags");
                  }
              };
          }
      );
      menuItems[3][0].addActionListener(
          new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                  generateReport();
              };
          }
      );


  }

  public void closeCurrentTab()
  {
    if (tab.getSelectedIndex()>-1)
      {
      tab.removeTabAt(tab.getSelectedIndex());
      }
  }

  public void closeAllTabs()
  {
    if (tab.getSelectedIndex()>-1)
      {
      tab.removeAll();
      }
  }

  public void exit()
  {
    System.exit(0);
  }

  public void showAllRaags() throws RaagDataException
  {
    selector.displayAllRaags(); 
  }

  public void addNewWindow() throws RaagDataException
  {
  int index = tab.getTabCount();              /* Get the total no of panes   */
  if(index<MAX_WINDOWS)
    {
    if (selector.isSelected())
      {
      Raag raag = selector.getSelectedRaag();
      tab.add(                                   /* Add a new tab having a new  */
        "Raag "+String.valueOf(index),                        
        new RaagPanel(raag));
      tab.setSelectedIndex(index);                /* Select the newly added tab  */
      tab.setBackgroundAt(index,getRandomColor());/* Set a random color for the tab*/
      tab.setToolTipTextAt(
        index,
        raag.toString());/* Set a random color for the tab*/
      }
    }
  else
    {
    JOptionPane.showMessageDialog(this,
      "Cannot Open Any More Windows",
      "Max Windows",
      JOptionPane.ERROR_MESSAGE);
    }
  }

  public void openSearchDialog()
  {
    RaagSearch searchDlg = new RaagSearch(this);
    searchDlg.setVisible(true);
    if (searchDlg.getResultRaags()!=null)
    {
    selector.setRaags(searchDlg.getResultRaags());
    }
    else
    {
    JOptionPane.showMessageDialog(
      this,
      "Search Failed! \nNo Raags to display");
    }
  }

  public void generateReport()
  {
  Raag []raags = selector.getRaags();
  String printString = "";
  if (!selector.isExternalData())
    {
    printString="Thaat : "+selector.getSelectedThaat().toString()+"\n\n";
    }
  
  if (raags!=null)
    {
    for (int i=0;i<raags.length ;i++ )
      {
      printString=printString+
        raags[i].toString()+
        "    "+"Jati : "+raags[i].getJatiDescription()+
        "  Vadi : "+raags[i].getVadi()+
        "  Samvadi : "+raags[i].getSamvadi()+
        "\n    "+"Aroha : "+raags[i].getAroha()+
        "  Aboroha : "+raags[i].getAboroha()+
        "\n    "+"Ras : "+raags[i].getRas()+
        "  Prokriti : "+raags[i].getProkriti()+
        "  Time : "+raags[i].getTime()+"\n\n";
      }
    if (printString.length()>0)
      {
      try
        {
        BufferedWriter bout = new BufferedWriter (
          new FileWriter ("report.txt"));
        bout.write(printString,0,printString.length());
        bout.close();
        }catch(IOException exc)
        {
        exc.printStackTrace();
        }
      }
    }
  }

  private Color getRandomColor()
  {
  int low=150;
  double incr=105.0;

  int red = low+(int)(incr * Math.random());  
  int green = low+(int)(incr * Math.random());
  int blue = low+(int)(incr * Math.random());
  Color color = new Color(red,green,blue);
  return(color);
  }

  public static void main (String [] args)
  {
    Raagmala frame = new Raagmala();
    frame.setVisible(true);
    frame.setSize(800,800);
  }
  
}
