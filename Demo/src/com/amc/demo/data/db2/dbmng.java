package com.amc.demo.data.db2;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class dbmng extends JFrame
{
public static final String DB="ibis";
private JMenuBar menubar;
  private JMenu mnu1;
  private JMenu mnu2;
  private JMenu mnu3;

private JPanel mainPanel;

private JPanel panel1;
  private JScrollPane scroll1;
  private JList listTables;

private JPanel panel2;
  private JScrollPane scroll2;
  private JTextArea txtDetails;
  private JButton cmdBack;

private DB2Table []tables;

CardLayout cards;

  public dbmng()
  {
  initialize();
  }

  public void initialize()
  {
  DB2Error error = new DB2Error();

  System.out.println("Connecting to "+DB);
  if(!DB2SystemManager.connect(DB,error))
    {
    JOptionPane.showMessageDialog(this,error.getError());
    }
  System.out.println("Connected");
  System.out.println("Getting List of Tables");

  tables = DB2SystemManager.listTables("USERID",error);

  panel1 = new JPanel(new BorderLayout());
  listTables = new JList(tables);
  scroll1 = new JScrollPane(listTables);
  panel1.add(scroll1);

  panel2 = new JPanel(new BorderLayout());
  txtDetails = new JTextArea();
  scroll2 = new JScrollPane(txtDetails);
  cmdBack = new JButton("Back");
  panel2.add(scroll2);
  panel2.add(cmdBack,BorderLayout.SOUTH);


  cards = new CardLayout();
  mainPanel = new JPanel();
  mainPanel.setLayout(cards);

  mainPanel.add(panel1,"list");
  mainPanel.add(panel2,"detail");
  getContentPane().add(mainPanel);

  setupListeners();
  }

  public void setupListeners()
  {
  addWindowListener(
    new WindowAdapter()
      {
      public void windowClosing(WindowEvent e)
        {
        exit();
        }
      }
    );

  listTables.addMouseListener(
    new MouseAdapter()
      {
      public void mouseClicked(MouseEvent e)
        {
        if(e.getClickCount()==2)
          {
          txtDetails.setText(tables[listTables.getSelectedIndex()].getDetails());
          cards.show(mainPanel,"detail");
          }
        }
      });
  cmdBack.addActionListener(
    new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
        cards.show(mainPanel,"list");
        }
      });
  }

  public void exit()
  {
  DB2Error error = new DB2Error();
  DB2SystemManager.reset(error);
  System.exit(0);
  }

  public static void main (String [] args)
  {
  dbmng dbmng = new dbmng();
  dbmng.setSize(400,400);
  dbmng.setVisible(true);
  }
  
}
