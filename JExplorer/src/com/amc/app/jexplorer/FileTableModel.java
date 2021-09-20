package com.amc.app.jexplorer;
import javax.swing.table.*;
import javax.swing.*;
import java.util.Vector;
import java.io.File;

public class FileTableModel extends AbstractTableModel 
{
  static final public ColumnData m_columns[] = {
    new ColumnData( "Filename/Directory", 200, JLabel.LEFT ),
    new ColumnData( "Size", 20, JLabel.RIGHT ),
    new ColumnData( "Last Modified", 10, JLabel.RIGHT ),
    new ColumnData( "Attributes", 2, JLabel.RIGHT ),
  };

  static final public Integer m_colIDs[] = {
    new Integer(0),
    new Integer(1),
    new Integer(2),
    new Integer(3),
  };

  public String szPath;

  protected Vector m_vector;

  public FileTableModel(String path)
  {
    this();
    szPath = path;
    setData();
  }

  public FileTableModel()
  {
    szPath = null;
    m_vector = new Vector();

  }

  public void setData()
  {

    File dir = new File(szPath);
    String files[] = dir.list();

    m_vector.removeAllElements();
    for(int i=0;i<files.length;i++)
    {
        m_vector.addElement(new FileData(szPath+files[i]));
    }
  }

  public int getRowCount()
  {
    return m_vector==null ? 0 : m_vector.size(); 
  }

  public int getColumnCount()
  { 
    return m_columns.length; 
  } 

  public String getColumnName(int column)
  { 
    return m_columns[column].m_title; 
  }

  public boolean isCellEditable(int nRow, int nCol)
  {
  boolean fReturn=false;
  switch(nCol)
    {
    case 0:
    case 2:
    case 3:
      fReturn=false;
      break;
    case 1:
      fReturn=false;
      break;
    }
  return(fReturn);
  }

  public Object getValueAt(int nRow, int nCol)
  {
    if (nRow < 0 || nRow>=getRowCount())
      return "";
    FileData row = (FileData)m_vector.elementAt(nRow);
    return row.getColumnData(nCol);
  }

  public String getTitle()
  {
  return "Default File";
  }
}
