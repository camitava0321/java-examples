package com.amc.app.jexplorer;
import java.awt.Color;
/**
 * The class is used for the data in each cell of the JFileTable. The class
 * JFileTableCellRenderer uses this class to display each cell in its own way.
 * @see JFileTableCellRenderer
 * @see FileData
 */
public class CellData
{
private String szData;
private Color foregroundColor=Color.black;

/** Constructor for CellData. One have to use the constructor to set the data in
 *  the cell. Once the cell has a data it cannot be modified. It can only be
 *  accessed.
 */
public CellData(String s)
{
    szData = s;
}

/** Obtain the data in the cell in the form of a String object
 */
public String getData()
{
    return szData;
}

/** Obtain the foreground color for the data in the cell in the 
 *  form of a Color object
 */
public Color getForegroundColor()
{
return foregroundColor;
}

/** Set the foreground color for the data in the cell in the 
 *  form of a Color object
 */
public void setForegroundColor(Color fc)
{
foregroundColor=fc;
}

/** To obtain the data from the cell use getData() method. This method
 *  deliberately returns an empty string
 */
public String toString()
{
return "";
}
}
