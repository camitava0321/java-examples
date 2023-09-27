package com.amc.demo.data.db2;
import java.sql.*;

public class DBTest
{

   static
   {
      try
      {
      System.out.println("Loading driver...");
      Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
      System.out.println("Done!");
      } catch (Exception e)
      {
      System.out.println("Error loading jdbc driver!");
      System.out.println("Message: " + e.getMessage());
      }
   }

   public static void main(String argv[])
   {
   Connection con = null;

   // URL = jdbc:db2:dbname
   String url = "jdbc:db2:ibis";

   try
     {
     if (argv.length == 0)
       {
       // connect with default id/password
       System.out.println("Connecting...");
       con = DriverManager.getConnection(url);
       }
     else if (argv.length == 2)
       {
       String userid = argv[0];
       String passwd = argv[1];
  
       // connect with username and password
       System.out.println("Connecting...");
       con = DriverManager.getConnection(url, userid, passwd);
       }
     else
       {
       System.out.println("\nUsage: java DBTest [username password]\n");
       System.exit(0);
       }


       // retrieve data from the database
       System.out.println("Retrieve data...");
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * from SYSIBM.SYSTABLES");
       
       System.out.println("Received results:");

       // display the result set
       // rs.next() returns false when there are no more rows
       ResultSetMetaData rm = rs.getMetaData();
       for(int i=1;i<=rm.getColumnCount();i++)
        {
        System.out.println(
          rm.getCatalogName(i)+"  "+
//        rm.getColumnClassName(i)+"  "+
          rm.getColumnDisplaySize(i)+"  "+
          rm.getColumnLabel(i)+"  "+
          rm.getColumnName(i)+"  "+
          rm.getColumnType(i)+"  "+
          rm.getColumnTypeName(i));
          
        }
       while (rs.next())
         {
         String a = rs.getString(1);

         System.out.println(a);
         }

       rs.close();
       stmt.close();

       /*
       // update the database
       System.out.println("\n\nUpdate the database... ");
       stmt = con.createStatement();
       int rowsUpdated = stmt.executeUpdate("UPDATE employee set firstnme = 'SHILI' where empno = '000010'");

       System.out.print("Changed "+rowsUpdated);

       if (1 == rowsUpdated)
          System.out.println(" row.");
       else
          System.out.println(" rows.");
       */
       con.close();

     } catch( Exception e )
       {
       e.printStackTrace();
       }
   }
}
