package com.amc.app.jexplorer;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.io.File;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import utility.*;

public class FileData
{
public static final ImageIcon ICON_DIR = new ImageIcon("Directory.gif");
public static final ImageIcon ICON_FILE = new ImageIcon("File.gif");

public static final int COL_NAME = 0;
public static final int COL_SIZE = 1;
public static final int COL_LASTMODIFIED = 2;
public static final int COL_ATTRIBUTES = 3;

private File file;
private Icon icon;

    public FileData(String szFilename)
    {
        file = new File(szFilename);
        if(file.isDirectory())
          {
            setIcon(ICON_DIR);
          }
        else
          {
            setIcon(ICON_FILE);
          }
    }

    public File getValue()
    {
    return file;
    }

    public Icon getIcon()
    {
    return icon;
    }

    public void setIcon(Icon v)
    {
    icon = v;
    }

    public String getName()
    {
    return file.getName();
    }

    public String getAbsoluteName()
    {
    return file.getAbsolutePath();
    }

    public CellData getColumnData(int colID)
    {
    CellData data = null;

        switch(colID)
        {
            case COL_NAME:
                data = new CellData(getAbsoluteName());
                break;
            case COL_SIZE:
                long len = file.length();
                data = new CellData(String.valueOf(len));
                break;
            case COL_LASTMODIFIED:
                Date date = new Date(file.lastModified());
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                String szYear = String.valueOf(calendar.get(Calendar.YEAR));
                String szDate = new String(
                  szYear+"-"+
                  StringFormatter.format(String.valueOf(calendar.get(Calendar.MONTH)+1),2,StringFormatter.RIGHT_JUSTIFY,false,'0')+"-"+
                  StringFormatter.format(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),2,StringFormatter.RIGHT_JUSTIFY,false,'0')
                  );
                data = new CellData(szDate);
                break;
            case COL_ATTRIBUTES:
                String temp = file.canRead()?"r":"";
                temp = temp+(file.canWrite()?"w":"");
                temp = temp+(file.isHidden()?"H":"");
                data=new CellData(temp);
                if (!file.canWrite())
                  {
                  data.setForegroundColor(Color.red);
                  }
                break;
        }
    return data;
    }

    public String toString()
    {
    return file.getAbsolutePath();
    }
}
