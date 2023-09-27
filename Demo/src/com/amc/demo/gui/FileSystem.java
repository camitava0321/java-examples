package com.amc.demo.gui;
import javax.swing.filechooser.*;
import java.io.*;

public class FileSystem
{

  public static void main (String [] args)
  {
    FileSystemView fileSys = FileSystemView.getFileSystemView();
    File []roots = fileSys.getRoots();

    for(int i=0;i<roots.length;i++)
    {
      System.out.println(roots[i]);
    }
  }
  
}
