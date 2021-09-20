package com.amc.app.jexplorer;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.swing.table.*;


/** JFileTable is a class that represents the directories and the files under 
 *  any directory fed into it. It has its own listener interface implemented 
 *  already into it so that the user need not have to implement them by themselves.
 *  It defaults to '\' (root) of the current drive but any path may be fed into it 
 *  by either creating a new object,<br>
 *  <pre>
 *  dirTable = new JFileTable(szPath);
 *  </pre>
 *  where szPath is a string representing the path        ,<br>
 *  or the following method may be used to refresh the contents of an existing
 *  JFileTable object.<br>
 *  <pre>
 *  dirTable.refresh(szPath);
 *  </pre>
 */
public class JFileTable extends JTable
{

/** The name of the path the JFileTable is representing */
protected String szPath;


    /** Create a new instance of the JFileTable which represents the directory
     *  structure of the specified path letter.
     *  @param char a valid path letter
     */
    public JFileTable(String path)
    {
    super();
    szPath = path;

    	/* Enable tool tips for the table, without this tool tips will not
    	   be picked up. */
    	ToolTipManager.sharedInstance().registerComponent(this);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        refresh();
    
/*****************************************************************************/
/* Setting up MouseListeners                                                 */
/*****************************************************************************/


    }

    /** Default constructor: Creates an instance of JFileTable which represents
     *  the default path '\'.
     */
    public JFileTable()
    {
//      this("\\");
        this(File.separator);
    }


    public void refresh()
    {
    FileTableModel model = new FileTableModel(szPath);
    int sColumns = getColumnCount();

//      if(table!=null)
//      {
//          getViewport().remove(table);
//          table=null;
//      }
        setAutoCreateColumnsFromModel(false);

        for (int k = 0; k < sColumns; k++)
        {
          TableColumn column = getColumn(FileTableModel.m_colIDs[k]);
          removeColumn(column);   
        }
        for (int k = 0; k < FileTableModel.m_columns.length; k++)
        {
          JFileTableCellRenderer renderer = new 
            JFileTableCellRenderer();

          renderer.setHorizontalAlignment(
            FileTableModel.m_columns[k].m_alignment);
          TableColumn column = new TableColumn(k, 
          FileTableModel.m_columns[k].m_width, renderer, null);
          column.setIdentifier(FileTableModel.m_colIDs[k]);
          addColumn(column);   
        }

        setModel(model);

//      getViewport().add(table);
        setBackground(GlobalProperties.COLOR_BACKGROUND_FILETABLE);
        repaint();
    }

    public void refresh(String path)
    {
    szPath = path;
    File file = new File(szPath+File.separator);
//  File file = new File(szPath+"\\");
    refresh();
    }

    /** Returns the underlying JTable component
     */
    public JTable getJTable()
    {
        return this;
    }

}

