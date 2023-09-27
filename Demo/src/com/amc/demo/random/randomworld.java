package com.amc.demo.random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class randomworld extends JFrame implements Runnable
{
private JPanel pnlInput = new JPanel();
private JLabel lblSeed = new JLabel("Seed(Any Long Integer): ");
private JTextField txtSeed = new JTextField(10);
private JButton cmdGo = new JButton("Set Seed");
private JButton cmdStopStart = new JButton("Stop");
private JPanel pnlDisplay = new JPanel(new GridLayout(1,2,5,5));
private JTextArea txtResults = new JTextArea();
private Canvas canvas = new Canvas();
private int x=0,y=0;
private int r=255,g=255,b=255;
private int radius=0;
private boolean fStopThread=true;
private Thread thread=null;
private   Graphics grph;

private Random random = new Random(0L);

  public randomworld()
  {
  getContentPane().setLayout(new BorderLayout());
  pnlInput.add(lblSeed);
  pnlInput.add(txtSeed);
  pnlInput.add(cmdGo);
  pnlInput.add(cmdStopStart);
  getContentPane().add(pnlInput,BorderLayout.NORTH);

  pnlDisplay.add(txtResults);
  pnlDisplay.add(canvas);
  getContentPane().add(pnlDisplay);
  setSize(700,300);
  grph=canvas.getGraphics();
  thread = new Thread(this);

  cmdGo.addActionListener(
    new ActionListener()
      {
      public void actionPerformed(ActionEvent evt)
        {
        setSeed();
        }
      }
    );
  cmdStopStart.addActionListener(
    new ActionListener()
      {
      public void actionPerformed(ActionEvent evt)
        {
        manageThread();
        }
      }
    );
  addWindowListener(
    new WindowAdapter()
      {
      public void windowClosing(WindowEvent evt)
      {
      System.exit(0);
      }
      }
  );
  }

  public void manageThread()
  {
  fStopThread=!fStopThread;
  if(fStopThread)
    {
    cmdStopStart.setText("Start");
    }
  else
    {
    cmdStopStart.setText("Stop");
    thread = new Thread(this);
    thread.start();
    }
  }

  public void setSeed()
  {
  long seed=0L;
  try
  {
  seed = Long.parseLong(txtSeed.getText());
  }catch(NumberFormatException exc)
  {
  seed=0L;
  }
  if(seed!=0L)
    {
    random.setSeed(seed);
    }

  manageThread();
  }

  public void run()
  {
  grph=canvas.getGraphics();
  while(!fStopThread)
    {
    try
      {
      displayData();
      Thread.sleep(1000);
      }catch(InterruptedException exc)
      {
      }
    }
  }

  public void displayData()
  {
  String data=null;
  if(random!=null)
    {
    data = "Next Boolean : "+random.nextBoolean()+
      "\nNext Double : "+random.nextDouble()+
      "\nNext Float  : "+random.nextFloat()+
      "\nNext Gaussian : "+random.nextGaussian()+
      "\nNext Int : "+random.nextInt(32767)+
      "\nNext Long : "+random.nextLong();

    Rectangle rect = canvas.getBounds();
    int l=rect.x;
    int m=rect.y+rect.height;

    x=random.nextInt((l<1)?1:l);
    y=random.nextInt((m<1)?1:m);
//  if(x<rect.x)
//    {
//    x=rect.x;
//    }
    data = data+
      "\nNext X : "+x+
      "\nNext Y : "+y;
    txtResults.setText(data);

    r=random.nextInt(255);
    g=random.nextInt(255);
    b=random.nextInt(255);
    radius=random.nextInt(20);
    grph.setColor(new Color(r,g,b));
    grph.fillOval(x,y,radius,radius);
    }
  }

  public static void main (String [] args)
  {
  randomworld randomworld = new randomworld();
  randomworld.setVisible(true);
  }
  
}
