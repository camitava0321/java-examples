package com.amc.app.jexplorer;
import javax.swing.JOptionPane;


public class Messagebox extends JOptionPane
{
public static int YES_OPTION = JOptionPane.YES_OPTION;
public static int NO_OPTION = JOptionPane.NO_OPTION;

private static String szMessage;
private static String szTitle;


  public Messagebox()
  {
    super();
  }

  public static void displayError(String message,String title)
  {
    szMessage = message;
    szTitle = title;
    display(JOptionPane.ERROR_MESSAGE);
  }

  public static void displayError(String message)
  {
    displayError(message,"JExplorer");
  }

  public static void displayInfo(String message,String title)
  {
    szMessage = message;
    szTitle = title;
    display(JOptionPane.INFORMATION_MESSAGE);
  }

  public static void displayInfo(String message)
  {
    displayInfo(message,"JExplorer");
  }

  public static void displayWarning(String message,String title)
  {
    szMessage = message;
    szTitle = title;
    display(JOptionPane.WARNING_MESSAGE);
  }

  public static void displayWarning(String message)
  {
    displayWarning(message,"JExplorer");
  }

  private static void display(int messageType)
  {
    JOptionPane.showMessageDialog(null,szMessage,szTitle,messageType);
  }





  public static int askWarning(String message,String title)
  {
    szMessage = message;
    szTitle = title;
    return (ask(JOptionPane.WARNING_MESSAGE));
  }

  public static int askWarning(String message)
  {
    return (askWarning(message,"JExplorer"));
  }

  private static int ask(int messageType)
  {
    return JOptionPane.showConfirmDialog(null,szMessage,szTitle,
        JOptionPane.YES_NO_OPTION,messageType);
  }

}
