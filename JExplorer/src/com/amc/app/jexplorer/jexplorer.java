package com.amc.app.jexplorer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import utility.datetime.JTimerLabel;
import utility.filesystem.FileManagerDialog;

import com.amc.swing.components.JFileSystemRootBox;
import com.amc.swing.components.JFileTree;
import com.amc.swing.components.Splash;

/** The application class. This class encapsulates all the components that the
 *  user interacts with. To run the class run
 *  <code>
 *  java jexplorer
 *  </code>
 *  This class does not expect any runtime command-line parameter(s).
 */
public class jexplorer extends JFrame
{
/** Image for the splash screen */
public static final ImageIcon SPLASH_IMAGE = new ImageIcon("resources/splashImage.jpg");
public static final String SPLASH_DATA_FILE = "resources/splashText.txt";
/** Principal menus in the menubar
 */
public static final String menuNames[]=       /* Menu Names                  */
    {
    "File",                                   /* 0th Menu                    */
    "Edit",                                   /* 1st Menu                    */
    "Options",                                /* 2nd Menu                    */
    "Help"                                    /* 3rd Menu                    */
    };

/** Submenus appearing under the principal menus
 */
public static final String menuItemNames[][]= /* Menu Item Names             */
    {
    {"New","Exit"},                           /* Under 0th Menu              */
    /* Under 1st Menu              */
    {"Copy", "Move" ,"Rename" ,"Rename Sequence" ,"Delete","Create Directory"},           
    /* Under 2nd Menu              */
    {"Configuration",
      "Refresh Associations",
      "Compare Directories"},
    {"Help"}                                  /* Under 3rd Menu              */
    };

/** Instance of the jexplorer */
public static Splash splash = new Splash(
  getVersion(),
  SPLASH_IMAGE,
  SPLASH_DATA_FILE,
  true,
  "Cancel",
  null,
  null,
  new Dimension(400,400),
  true
  );
public static jexplorer jexplorer;

/*****************************************************************************/
/* Declaration and Initialisation of All the components in jexplorer         */
/*****************************************************************************/

// Menus
JMenuBar menubar;
    JMenu menus[] = new JMenu[menuNames.length];
        JMenuItem menuItems[][] = new JMenuItem[menuItemNames.length][30] ;

// Border
EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED);

// Main Panel
JPanel mainPanel;

    //Toolbar
    JToolBar toolBar;
        JButton cmdHome;
        JButton cmdBack;
        JButton cmdDelete;
        JButton cmdFind;
        JButton cmdPageSetup;
        JButton cmdPrint;
        JButton cmdPrintPreview;
        JButton cmdRefresh;
        JButton cmdStop;

    // SubPanel
    JPanel subPanel;
        JPanel leftPanel;
          JFileSystemRootBox cboDrives;
          JFileTree fTree;
        JPanel rightPanel;
            JFileTable  fTable;
            JScrollPane scrollTable;
            JBrowser  fBrowser;
            JSplitPane split2;
        JSplitPane split1;
    
JPanel bottomPanel;
    JPanel panel1;
        JLabel lblStatus;
    JPanel panel2;
        JProgressBar progressBar;
        JPanel panel2a;
            JTimerLabel lblDateTime;


private JPanel pane = new JPanel();
private CardLayout cards = new CardLayout();
private boolean fBrowseFullScreen=false;
//Listener for the Drive Combobox
DriveListener drvListener = new DriveListener();

//MouseListener for the table
JFileTableMouseListener tableL = new JFileTableMouseListener();

char chCurrentDrive='C';                      /* Active Drive                */
String szCurrentDirectory="";                 /* Active Directory            */


    public jexplorer()
    {
    //initialize and laying of components and setting their attributes
    GlobalProperties.read (GlobalProperties.JEXPLORER_PROPERTIES);
    initialize();        
    //setup of the listeners to the components
    setupListeners();
    }

    public void initialize()
    {
    //set the title
    setTitle(getVersion());

    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    mainPanel = new JPanel(new BorderLayout());
      
    Splash.setValue(30); //30 percent work done
      //initialize the toolbar
      toolBar = new JToolBar();
        cmdBack = new JButton();
        cmdHome = new JButton();       
        cmdDelete = new JButton();     
        cmdFind = new JButton();       
        cmdPageSetup = new JButton();  
        cmdPrint = new JButton();      
        cmdPrintPreview = new JButton();
        cmdRefresh = new JButton();    
        cmdStop = new JButton();       

        cmdBack.setIcon(new ImageIcon("resources\\export24.gif"));
        cmdHome.setIcon(new ImageIcon("resources\\home24.gif"));
        cmdDelete.setIcon(new ImageIcon("resources\\delete24.gif"));
        cmdFind.setIcon(new ImageIcon("resources\\find24.gif"));
        cmdPageSetup.setIcon(new ImageIcon("resources\\pagesetup24.gif"));
        cmdPrint.setIcon(new ImageIcon("resources\\print24.gif"));
        cmdPrintPreview.setIcon(new ImageIcon("resources\\printpreview24.gif"));
        cmdRefresh.setIcon(new ImageIcon("resources\\refresh24.gif"));
        cmdStop.setIcon(new ImageIcon("resources\\stop24.gif"));

        cmdBack.setToolTipText("Up One Directory");
        cmdHome.setToolTipText("Go to Home Directory");       
        cmdDelete.setToolTipText("Delete Selected File(s) or Directory");     
        cmdFind.setToolTipText("Find File(s) or Directory");       
        cmdPageSetup.setToolTipText("Page Setup");  
        cmdPrint.setToolTipText("Print Selected File");      
        cmdPrintPreview.setToolTipText("Print Preview");      
        cmdRefresh.setToolTipText("Refresh Directory");    
        cmdStop.setToolTipText("Stop the Active Function");       

        toolBar.add(cmdBack);
        toolBar.add(cmdHome);       
        toolBar.add(cmdDelete);     
        toolBar.add(cmdFind);       
        toolBar.add(cmdPageSetup);  
        toolBar.add(cmdPrint);      
        toolBar.add(cmdPrintPreview);
        toolBar.add(cmdRefresh);    
        toolBar.add(cmdStop);       

        toolBar.setFloatable(false);

    subPanel = new JPanel(new BorderLayout());
        leftPanel = new JPanel(new BorderLayout());
          cboDrives = new JFileSystemRootBox();
        rightPanel = new JPanel(new BorderLayout());
            fTable = new JFileTable();
            scrollTable = new JScrollPane(fTable);
            fBrowser = new JBrowser();
            split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                scrollTable,fBrowser);
        split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    bottomPanel = new JPanel(new BorderLayout());
        panel1 = new JPanel(new GridLayout(1,1));
            lblStatus = new JLabel("Default Status");
        panel2 = new JPanel(new BorderLayout());
            progressBar = new JProgressBar();
            panel2a = new JPanel(new GridLayout(1,1));
                lblDateTime = new JTimerLabel();
/*****************************************************************************/
/* Setting up the components                                                 */
/*****************************************************************************/

        Splash.setValue(60);  //60 percent work done
        fTree = new JFileTree();
        setCurrentDirectory("C:"+File.separator);
        fTree.setBorder(
          BorderFactory.createCompoundBorder(
          BorderFactory.createTitledBorder("Directories"),
          border));

        leftPanel.add(cboDrives,BorderLayout.NORTH);
        leftPanel.add(fTree);
        split1.setLeftComponent(leftPanel);
        split1.setRightComponent(rightPanel);

        mainPanel.add(toolBar,BorderLayout.NORTH);
        

       scrollTable.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Details"),
        border));

        split2.setOneTouchExpandable(true);

        rightPanel.add(split2);
        subPanel.add(split1);
        mainPanel.add(subPanel,BorderLayout.WEST);
        mainPanel.add(rightPanel,BorderLayout.CENTER);

        lblStatus.setBorder(border);
        progressBar.setBorder(border);
        lblDateTime.setBorder(border);
        lblDateTime.setToolTipText("Date and Time");

                panel1.add(lblStatus);
            bottomPanel.add(panel1);

                panel2.add(progressBar);
                    panel2a.add(lblDateTime);
                panel2.add(panel2a);
            bottomPanel.add(panel2,BorderLayout.EAST);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

       pane.setLayout(cards);
       pane.add(mainPanel,"main");
       getContentPane().add(pane);
       cards.show(pane,"main");

       cboDrives.addItemListener(drvListener);
       cboDrives.setToolTipText("Select a drive");
       fBrowser.setToolTipText("Default Viewer");

/*****************************************************************************/
/* Setting up the Menus                                                      */
/*****************************************************************************/
        Splash.setValue(90); //90 percent work done

        setupMenus();

        Splash.setValue(100); //100 percent work done
    }

    public void setupListeners()
    {
/*****************************************************************************/
/* Setting up Window Listener                                                */
/*****************************************************************************/
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addKeyListener(
      new KeyAdapter()
      {
        public void keyPressed(KeyEvent e)
        {
        if(e.getKeyCode()==KeyEvent.VK_F12)
          {
          fBrowseFullScreen=!fBrowseFullScreen;
          managePane();
          }
        if(e.getKeyCode()==KeyEvent.VK_SLASH)
          {
          fBrowser.processKeyEvent(e);
          }
        }
        public void keyTyped(KeyEvent e)
        {
        if(e.getKeyCode()==KeyEvent.VK_SLASH ||
           e.getKeyCode()==KeyEvent.VK_N)
          {
          fBrowser.processKeyEvent(e);
          }
        }
      }
    );

    cmdBack.addActionListener(new ToolListener());

    fTree.addMouseListener(
      new MouseAdapter()
        {
        public void mouseClicked(MouseEvent e)
          {
          int selRow = fTree.getRowForLocation(e.getX(), e.getY());
  
          if(selRow != -1)
            {
            if(e.getClickCount() == 1)
              {
              jexplorer.displayDirectory(
                  chCurrentDrive+":"+
                  fTree.getFullNodeName(selRow));
              }
            else if(e.getClickCount() == 2)
              {
  //          try
  //            {
  //            System.out.println(Dir.getDump(chCurrentDrive+":"+
  //                parsePath(selPath.getPath())));
  //            }catch(IOException ex)
  //            {
  //            System.out.println(ex.getMessage());
  //            }
              }
            else
              {
              }
            }
          else
            {
            }
          }
    
        });
    fTable.addMouseListener(tableL);
    }

    public void setupMenus()
    {
    int i=0, j=0;
    menubar = new JMenuBar();
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
        menuItems[0][1].addActionListener(
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
                displayFileCopyDialog(false);/* Move CheckBox Not Selected */
                };
            }
        );

        menuItems[1][1].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                displayFileCopyDialog(true);/* Move CheckBox     Selected */
                };
            }
        );

        menuItems[1][2].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                displayFileRenameDialog(0);/* Single File Rename */
                };
            }
        );

        menuItems[1][3].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                displayFileRenameDialog(1);/* Multiple File Rename */
                };
            }
        );

        menuItems[1][4].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                deleteSelectedFiles();
                };
            }
        );

        menuItems[1][5].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                displayFileRenameDialog(2);
                };
            }
        );

        menuItems[2][1].addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                fBrowser.refreshAssociations();
                };
            }
        );

    }

    public String[] getSelectedFilenames()
    {
    String []filenames={""};
    int noRows = fTable.getSelectedRowCount();
    if(noRows > 0)
      {
      int []rows = fTable.getSelectedRows();
      filenames = new String[rows.length];
      for(int i=0;i<rows.length;i++)
        {
        CellData data = (CellData)fTable.getValueAt(rows[i],0);
        FileData tableValue = new FileData(data.getData());
        filenames[i]=tableValue.getAbsoluteName();
        }
      }
    return(filenames);
    }

    public void displayFileCopyDialog(boolean fMove)
    {
    String szTitle=null;
      if(fMove)
        {
        szTitle = "Move Files";
        }
      else
        {
        szTitle = "Copy Files";
        }

    FileManagerDialog dlg = new FileManagerDialog
                                (
                                jexplorer,
                                szTitle,
                                FileManagerDialog.DIALOG_COPYMOVE,
                                fMove,
                                getSelectedFilenames()
                                );
        dlg.pack();
        dlg.setVisible(true);
        validate();

    }

    public void displayFileRenameDialog(int type)
    {
    String []filenames={""};
    String szTitle=null;
    boolean fDisplayDialog=false;
    int mode=FileManagerDialog.DIALOG_RENAME;

    int noRows = fTable.getSelectedRowCount();

      if(type==0)   
        {
        szTitle = "Rename To";
        mode = FileManagerDialog.DIALOG_RENAME;
        filenames=getSelectedFilenames();
        }
      else if(type==1)
        {
        szTitle = "Rename Sequence";
        mode = FileManagerDialog.DIALOG_GROUPRENAME;
        filenames=getSelectedFilenames();
        }
      else if(type==2)
        {
        szTitle = "Create Directory";
        mode = FileManagerDialog.DIALOG_CREATEDIRECTORY;
        filenames[0]=getCurrentDirectory();
        }
      
      if(noRows > 1 && type==1)
        {
        fDisplayDialog=true;
        }
      else if(noRows==1 && type==0)
        {
        fDisplayDialog=true;
        }
      else if(type==2)
        {
        fDisplayDialog=true;
        }

      if(fDisplayDialog)
        {
          
   FileManagerDialog dlg = new FileManagerDialog
                               (
                               jexplorer,
                               szTitle,
                               mode,
                               true,
                               filenames
                               );
        dlg.pack();
        dlg.setVisible(true);
        validate();
        }

    }

    public void deleteSelectedFiles()
    {
    int []rows = fTable.getSelectedRows();
    String []filenames = new String[rows.length];
    for(int i=0;i<rows.length;i++)
    {
      CellData data = (CellData)fTable.getValueAt(rows[i],0);
      FileData tableValue = new FileData(data.getData());
      filenames[i]=tableValue.getAbsoluteName();
    }

    if(filenames!=null)
      {
      for(int i=0;i<filenames.length;i++)
        {
        File file = new File(filenames[i]);
        if(file!=null)
          {
          if(!file.delete())
            {
            System.out.println("File Deletion Failed");
            }
          }
        }
      }

    }

    public void displayDirectory(String szPath)
      {
      Cursor cur = getCursor();
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      setCurrentDirectory(szPath);
      if(szPath.equals(File.separator))
        {
        }
      else
        {
        szPath = szPath+File.separator;
        }
      fTable.refresh(szPath);
      setCursor(cur);
      fBrowser.clear();
      }

    public void displayFile(String szPath)
      {
      Cursor cur = getCursor();
      try
      {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        fBrowser.setFile(szPath);
        repaint();
      }catch(IOException e)
      {
          System.out.println(e.getMessage());
      }
      setCursor(cur);
      }

    public void setCurrentDirectory(String dir)
      {
      szCurrentDirectory=dir;
      System.setProperty("user.dir",            /* Set the current directory   */
          szCurrentDirectory);
      }

    public String getCurrentDirectory()
      {
      return(szCurrentDirectory);
      }



    public static void main (String [] args)
    {
    Splash.setValue(0);
    jexplorer = new jexplorer();
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    d.width=d.width;
    d.height=d.height/2;
    jexplorer.setSize(d);
    jexplorer.pack();
    jexplorer.setVisible(true);
    }




    class DriveListener implements ItemListener
    {

        public void itemStateChanged(ItemEvent e)
        {
        if(e.getStateChange()==e.SELECTED)
          {
          String drive = (String)(e.getItem());
          chCurrentDrive = drive.charAt(0);
          Cursor cur = getCursor();
          setCursor(new Cursor(Cursor.WAIT_CURSOR));
          fTree.refresh(chCurrentDrive);
          fTable.refresh(chCurrentDrive+":"+File.separator);
          setCursor(cur);
          }
        }
    }

    class ToolListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            JButton cmd = (JButton)(e.getSource());
            if(getCurrentDirectory()!=null)
              {
                File file = new File(getCurrentDirectory());
                setCurrentDirectory( file.getParent());
                if(getCurrentDirectory()!=null)
                  {
                    displayDirectory(getCurrentDirectory());
                  }
              }
        }
    }

    class JFileTableMouseListener extends MouseAdapter
    {
    
         public JFileTableMouseListener()
         {
            super();
         }
    
         public void mouseClicked(MouseEvent e)
         {
         JTable table = ((JTable)(e.getSource()));
    
             int selRow = table.getSelectedRow();
             CellData data = (CellData)table.getValueAt(selRow,0);
             FileData tableValue = new FileData(data.getData());

             if(selRow != -1)
             {
                 if(e.getClickCount() == 1)
                 {
                    jexplorer.displayFile(tableValue.getAbsoluteName());
                 }
                 else if(e.getClickCount() == 2)
                 {
                    jexplorer.displayDirectory(tableValue.getAbsoluteName());
                 }
                 else
                 {
                 }
    
             }
             else
             {
             }
         }
    
    }

    public void managePane()
    {
    if(fBrowseFullScreen)
      {
      pane.add(fBrowser,"browser");
      cards.show(pane,"browser");
      }
    else
      {
      pane.remove(fBrowser);
      split2.setBottomComponent(fBrowser);
      cards.show(pane,"main");
      }
    }

    public static String getVersion()
    {
    return(GlobalProperties.VERSION);
    }

    public void exit()
    {
      int sResponse = Messagebox.askWarning("Do you want to exit?");
      if(sResponse==Messagebox.YES_OPTION)
        {
        System.exit(0);
        }
    }

}
