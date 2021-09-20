package com.amc.app.jexplorer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import utility.StringFormatter;

import com.amc.swing.components.FontChooser;
import com.amc.swing.components.HTMLViewer;
import com.amc.swing.components.HexViewer;
import com.amc.swing.components.TextViewer;


public class JBrowser extends JComponent
{
  public static final Font shortFont=new Font("Tahoma",Font.PLAIN,9);
  public static final Font normalFont=new Font("Tahoma",Font.PLAIN,10);
  public static final Font fixedWidthFont=new Font("Courier",Font.PLAIN,12);

  public static final int NO_ASSOCIATION=0;
  public static final int LOCAL_ASSOCIATION=1;
  public static final int EXTERNAL_ASSOCIATION=2;

  public static final String viewerAssociations[][]=
  {
  {"gif","image"},
  {"jpg","image"},

  {"exe","exec"},
  {"cmd","exec"},

  {"html","html"},
  {"htm","html"},

  {"txt","text"},

  {"dll","hex"}
  };

  private JToolBar pnlTop = new JToolBar();
    private JCheckBox chkProperties = new JCheckBox("Properties Only",true);
    private JCheckBox chkDefault = new JCheckBox("Default Browser",false);
    private JCheckBox chkIgnore = new JCheckBox("Ignore Asscociation",false);
    private JButton cmdOpenInEditor = new JButton("Open In Editor");
    private JButton cmdChooseFont = new JButton("Fonts..");
    private JButton cmdPrint = new JButton("Print");

  private TextViewer txtBrowser = new TextViewer();

  private JScrollPane scrollLabel = new JScrollPane();
  private JLabel lblBrowser = new JLabel("");

  private HTMLViewer htmBrowser = new HTMLViewer();

  private HexViewer hexBrowser = new HexViewer();

  private JPanel pane = new JPanel();
  private CardLayout cards = new CardLayout();
  private String currentCardId="";

  private Properties defaultProperties = new Properties();
  private Properties userProperties;
  private Enumeration enums;
  private File file;
  private String szEditorName="vs.exe";
  private String title="Browser : ";


    public JBrowser(String filename) throws IOException
    {
       this();
       setFile(filename);
    }

    public JBrowser()
    {
       super(); 
       lblBrowser.setVerticalAlignment(SwingConstants.TOP);

       scrollLabel.getViewport().add(lblBrowser);

       chkProperties.setFont(shortFont);
       chkDefault.setFont(shortFont);
       chkIgnore.setFont(shortFont);
       cmdOpenInEditor.setFont(shortFont);
       cmdChooseFont.setFont(shortFont);
       cmdPrint.setFont(shortFont);

       pnlTop.add(chkProperties);
       pnlTop.add(chkDefault);
       pnlTop.add(chkIgnore);
       pnlTop.add(cmdOpenInEditor);
       pnlTop.add(cmdChooseFont);
       pnlTop.add(cmdPrint);

       txtBrowser.setFont(normalFont);
       pane.setLayout(cards);
       pane.add(txtBrowser,"text");
       pane.add(scrollLabel,"image");
       pane.add(htmBrowser,"html");
       pane.add(hexBrowser,"hex");
       setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder(title),
        BorderFactory.createEmptyBorder(2,1,2,1)));

       setLayout(new BorderLayout(0,2));
       add(pnlTop,BorderLayout.NORTH);
       add(pane);
       
       refreshAssociations();
       setupListeners();
    }

    public void refreshAssociations()
    {
       try
       {
       defaultProperties.load(new FileInputStream("associationsDefaults.properties"));
       userProperties = new Properties(defaultProperties);
       userProperties.load(new FileInputStream("associations.properties"));
       }catch(IOException e)
       {
        System.out.println(e.getMessage());
       }
    }

    public void setFile(String filename) throws IOException
    {
    int returnValue=0;
    String szFilename;

       file = new File(filename);
       szFilename = file.getAbsolutePath().toLowerCase();

       title="Browser : "+szFilename;
       setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder(title),
        BorderFactory.createEmptyBorder(2,1,2,1)));
       
       if(chkProperties.isSelected())         /* User is interested in the   */
         {                                    /* properties of the file only */
         displayFileProperties(file);
         }
       else
         {
         if(file.isDirectory())
           {
              throw new IOException("Selected File is a Directory");
           }
         else
           {
           if(chkIgnore.isSelected())
             {
             txtBrowser.setFile(file);
             selectCard("text");
             }
           else
             {
             returnValue = manageAssociation();
             if(returnValue==NO_ASSOCIATION)
               {
               if(chkDefault.isSelected())
                 {
                 txtBrowser.setFile(file);
                 selectCard("text");
                 }
               else
                 {
                 displayText("No Association for this type of file");
                 }
               }
             else if(returnValue==LOCAL_ASSOCIATION)
               {
               manageLocalAssociation();
               }
             }
           }
         }
    }

    public void displayFileProperties(File file)
    {
    StringBuffer sb = new StringBuffer();
    String temp="";
     
    temp = file.isDirectory()?"Directory":"File";
    temp = temp+" "+"Name : "+file.getName();
    sb.append(temp+"\n");
    temp = "Path : "+file.getPath();
    sb.append(temp+"\n");
    temp = "Absolute Path : "+file.getAbsolutePath();
    sb.append(temp+"\n");

    temp = "Canonical Path : ";
    try
      {
      temp = temp+file.getCanonicalPath();
      }catch(IOException e)
      {
      temp = temp+"IOException : could not obtain Canonical Path";
      }
    sb.append(temp+"\n");

    temp = "Parent : "+file.getParent();
    sb.append(temp+"\n");

    temp = file.isFile()?"Not A Normal File":"Normal File";
    sb.append(temp+"\t");
    temp = file.canRead()?"Readable":"Not Readable";
    sb.append(temp+" ");
    temp = file.canWrite()?"& Writable":"(Read Only)";
    sb.append(temp+"\t");
    temp = file.isHidden()?"Hidden":"";
    sb.append(temp+"\n");

    Date date = new Date(file.lastModified());
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    String szYear = String.valueOf(calendar.get(Calendar.YEAR));
    String szDate = new String(
      szYear+"-"+
      StringFormatter.format(String.valueOf(calendar.get(Calendar.MONTH)+1),2,StringFormatter.RIGHT_JUSTIFY,false,'0')+"-"+
      StringFormatter.format(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),2,StringFormatter.RIGHT_JUSTIFY,false,'0')
      );

    temp = "Last Modified On : "+String.valueOf(szDate);
    sb.append(temp+"\n");
    temp = "File Size : "+String.valueOf(file.length());
    sb.append(temp+"\n");

    txtBrowser.setText(sb.toString());
    selectCard("text");
    }

    public void clear()
    {
        txtBrowser.setText("");
        lblBrowser.setIcon(null);
    }

    public int manageAssociation()
    {
    int sReturn=NO_ASSOCIATION;
    String szFilename = file.getAbsolutePath().toLowerCase();
    String szFunction[]= new String[2];
    String szExtension;

       enums = userProperties.propertyNames();

        while(enums.hasMoreElements())
        {
          szExtension = (String)enums.nextElement();

          if(szFilename.endsWith("."+szExtension))
            {
            szFunction[0] = userProperties.getProperty(szExtension);
            if(szFunction[0].equals("viewer"))
              {
                sReturn=LOCAL_ASSOCIATION;
              }
            else
              {
                if(szFunction[0].equals("exec"))
                  {
                  szFunction[0]=szFilename;
                  szFunction[1]=null;
                  }
                else
                  {
                  szFunction[1]=szFilename;
                  }
                try
                {
                  System.out.println("starting new process");
                    Process p = Runtime.getRuntime().exec(szFunction);
                    sReturn=EXTERNAL_ASSOCIATION;
//                  System.out.println(p.exitValue());
                }catch(IOException e)
                {
                    System.out.println(e.getMessage());
                  System.out.println("error occurred -> Starting new process");
                }
              }
            break;
            }
        }

    return sReturn;
    }

    public void manageLocalAssociation() throws IOException
    {
    int i=0;
    String szFilename = file.getAbsolutePath().toLowerCase();
    String szFunction[]= new String[1];
    String szExtension;

        while(i<viewerAssociations.length)
        {
          szExtension = viewerAssociations[i][0];

          if(szFilename.endsWith("."+szExtension))
            {
              if(viewerAssociations[i][1]=="image")
                {
                  lblBrowser.setIcon(new ImageIcon(file.getAbsolutePath()));
                  selectCard("image");
                }

              if(viewerAssociations[i][1]=="exec")
                {
                  szFunction[0]=szFilename;
                  System.out.println("starting new process");
                    Process p = Runtime.getRuntime().exec(szFunction);
                }

              if(viewerAssociations[i][1]=="html")
                {
                  htmBrowser.setFile(file);
                  selectCard("html");
                }

              if(viewerAssociations[i][1]=="text")
                {
                txtBrowser.setFile(file);
                selectCard("text");
                }

              if(viewerAssociations[i][1]=="hex")
                {
                hexBrowser.setFile(file);
                selectCard("hex");
                }


            break;
            }
          else
            {
            txtBrowser.setFile(file);
            selectCard("text");
            }
        i++;
        }
    }
    
    public void displayText(String data)
    {
      txtBrowser.setText(data);
    }

    public void setToolTipText(String s)
    {
      txtBrowser.setToolTipText(s);
      lblBrowser.setToolTipText(s);
      htmBrowser.setToolTipText(s);
    }

    public void setupListeners()
    {
    chkProperties.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            if(chkProperties.isSelected())
              {
              chkDefault.setSelected(false);
              chkDefault.setEnabled(false);
              chkIgnore.setEnabled(false);
              }
            else
              {
              chkDefault.setSelected(true);
              chkDefault.setEnabled(true);
              chkIgnore.setEnabled(true);
              }
            };
        }
    );

    cmdOpenInEditor.addActionListener(
      new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
          {
          String szFilename = file.getAbsolutePath().toLowerCase();
          String szFunction[]= new String[2];
          szFunction[0]=szEditorName;
          szFunction[1]=szFilename;
          try
            {
            Process p = Runtime.getRuntime().exec(szFunction);
            }catch(IOException exc)
            {
            System.out.println("Cannot Start Function : "+szFunction[0]+" "+szFunction[1]);
            }
          }
        }
    );

    cmdChooseFont.addActionListener(

      new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
          {
          showFontDialog();
          }
        }
    );

    cmdPrint.addActionListener(

      new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
          {
          printFile();
          }
        }
    );
    }
    
    public void showFontDialog()
    {
    FontChooser chooser = new FontChooser(txtBrowser.getFont());
    chooser.showDialog(this);
    if(!chooser.isCancelled())
      {
      txtBrowser.setFont(chooser.getSelectedFont());
      }
    }

    public void showFindDialog()
    {
    FindDialog fd = new FindDialog();
    fd.setSize(300,300);
    fd.setVisible(true);
    }

    public void printFile()
    {
    if(currentCardId.equals("text"))
      {
      txtBrowser.print();
      }
    else if(currentCardId.equals("htm"))
      {
      htmBrowser.print(); 
      }
    else if(currentCardId.equals("hex"))
      {
      hexBrowser.print(); 
      }
    }

    public void selectCard(String id)
    {
    currentCardId=id;
    if(currentCardId.equals("text"))
      {
      cmdChooseFont.setVisible(true);
      }
    else
      {
      cmdChooseFont.setVisible(false);
      }
    cards.show(pane,currentCardId);
    }

    public void processKeyEvent(KeyEvent e)
    {
    if(e.getKeyCode()==KeyEvent.VK_SLASH)
      {
      showFindDialog();
      }
    if(e.getKeyCode()==KeyEvent.VK_N)
      {
      //search again
      }
    }
}
