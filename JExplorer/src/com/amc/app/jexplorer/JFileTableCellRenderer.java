package com.amc.app.jexplorer;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JFileTableCellRenderer extends DefaultTableCellRenderer
{

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
          boolean hasFocus, int row, int column) 
    {
    CellData data = null;
    String szText = null;

    super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
        row, column);

        data = (CellData)table.getValueAt(row,column);
        szText = data.getData();
        Color fColor = data.getForegroundColor();

        data = (CellData)table.getValueAt(row,0);
        FileData tableValue = new FileData(data.getData());
        setToolTipText(tableValue.getAbsoluteName());

        
        if(column==0)
          {
          /* Set the Icon. */
          setIcon(tableValue.getIcon());
          setText(tableValue.getName());
          }
        else
          {
          /* Set the text. */
          setIcon(null);
          setText(szText);
          }


	/* Tooltips used by the tree. */
    setFont(new Font("Courier",Font.PLAIN,12));
    setBackground(GlobalProperties.COLOR_BACKGROUND_FILETABLE);
    setForeground(fColor);
    validate();
	return this;
    }
                     
}
