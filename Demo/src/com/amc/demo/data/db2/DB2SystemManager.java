package com.amc.demo.data.db2;
import java.sql.*;
import java.util.*;

public class DB2SystemManager
{
private static Connection connection;
private static Statement statement;

  static
  {
     try
     {
     Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
     } catch (Exception e)
     {
     System.out.println("Error loading jdbc driver!");
     System.out.println(e.getMessage());
     }
  }

  public static boolean connect(String connectionURL,DB2Error error)
  {
  boolean fReturn=true;
  String url = "jdbc:db2:"+connectionURL;
    try
      {
      connection = DriverManager.getConnection(url);
      statement = connection.createStatement();
      }catch(Exception e)
      {
      error.setError(e.getMessage());
      fReturn=false;
      }
  return(fReturn);
  }

  public static DB2Table[] listTables(String qualifier, DB2Error error)
  {
  DB2Table []tables=null;
  String sql =
    "SELECT name,creator,type,ctime,remarks,colcount "+
    "FROM SYSIBM.SYSTABLES WHERE CREATOR='"+
    qualifier+"'";
    try
      {
      ResultSet rs = statement.executeQuery(sql);
      Vector vec = new Vector();
      DB2Table table;
      System.out.println(System.currentTimeMillis());
      while(rs.next())
        {
        table = new DB2Table(rs.getString(1));
//      table.creator=rs.getString(2);
//      table.type=rs.getString(3);
//      table.ctime=rs.getString(4);
//      table.colcount=rs.getString(5);
        vec.addElement(table);
        }
      System.out.println(System.currentTimeMillis());
      rs.close();
    
      tables = new DB2Table[vec.size()];
      for(int i=0;i<vec.size();i++)
        {
        tables[i] = (DB2Table)vec.elementAt(i);
        }
      }catch(Exception e)
      {
      error.setError(e.getMessage());
      }
  return(tables);
  }

  public static boolean reset(DB2Error error)
  {
  boolean fReturn=true;
    try
      {
      statement.close();
      connection.close();
      }catch(Exception e)
      {
      error.setError(e.getMessage());
      fReturn=false;
      }
  return(fReturn);
  }
}

