package com.amc.app.jexplorer;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utility.search.*;

public class FindDialog extends JDialog
{
  FindAndReplace fr;
  long []lOffsets=null;

  JPanel pnlCmd = new JPanel();
    JButton cmdOk = new JButton("Ok");
    JButton cmdCancel = new JButton("Cancel");

  public FindDialog()
  {
  super();
  initialize();
  setupListeners();
  }

  public FindDialog(Frame owner,String title)
  {
  super(owner,title);
  initialize();
  setupListeners();
  }

  private void initialize()
  {
  getContentPane().setLayout(new BorderLayout());

  fr = new FindAndReplace(null,null,false);

  pnlCmd.add(cmdOk);
  pnlCmd.add(cmdCancel);
  
  getContentPane().add(fr);
  getContentPane().add(pnlCmd,BorderLayout.SOUTH);
  }

  private void setupListeners()
  {
  cmdOk.addActionListener(
    new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      setAccepted(true);
      }
    }
  );

  cmdCancel.addActionListener(
    new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      setAccepted(false);
      }
    }
  );

  }

  private void setAccepted(boolean f)
  {
  if(f)                                       /* Ok is pressed               */
    {
//  lOffsets = fr.performSearch();
    }
  else
    {
    lOffsets=null;
    }
  dispose();
  }

  public long[] getOffsets()
  {
  return(lOffsets);
  }
}
