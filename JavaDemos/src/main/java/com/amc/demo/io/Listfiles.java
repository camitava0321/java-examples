package com.amc.demo.io;
import java.io.*;


public class Listfiles
{

    public static void main (String [] args)
    {
    String []files;

    File file = new File(args[0]);

        files = file.list(new MyFilter());

        if(files!=null)
        {
            for(int i=0;i<files.length;i++)
            {
                System.out.println(files[i]);
            }
        }
        else
        {
            System.out.println("No files");
        }
    }
    
}


class MyFilter implements FilenameFilter
{

    public boolean accept(File dir,String name)
    {
    return true;
    }
}
