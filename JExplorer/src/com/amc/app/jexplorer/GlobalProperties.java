package com.amc.app.jexplorer;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * GlobalProperties.java
 *
 * Created on October 30, 2006, 5:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author 109365
 */
public class GlobalProperties
{
  public static final String VERSION = "JExplorer 4.0.0";
  public static final Color COLOR_BACKGROUND_FILETABLE=new Color(230,235,255);
  public static final String JEXPLORER_PROPERTIES="properties"+File.separator+"jexplorer.properties";
  public static String EDITOR="";
  public static int TREE=1;
  public static String SORT="name";
  public static String FONT="Verdana";
  public static int TABS=1;
  
  /** Creates a new instance of GlobalProperties */
  public GlobalProperties ()
  {
  }
  
  public static void read(String propertyFile)
  {
    try
    {
     Properties properties = new Properties() ;
     properties.load (new FileInputStream(JEXPLORER_PROPERTIES));
     EDITOR=properties.getProperty ("EDITOR");
     TREE=Integer.parseInt (properties.getProperty ("TREE"));
     SORT=properties.getProperty ("SORT");
     FONT=properties.getProperty ("FONT");
     TABS=Integer.parseInt (properties.getProperty ("TABS"));
    }catch(IOException exc)
    {
      createPropertyFile();
    }
  }

  public static void createPropertyFile()
  {
    //write property file
    System.out.println ("Could not find default properties file. Creating...");
  }
}
