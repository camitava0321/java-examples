package com.amc.demo.data.db2;

public class DB2Table
{

private String name;
//public String creator;
//public String type;
//public String ctime;
//public String colcount;
//public DB2Columns []columns;

  public DB2Table(String n)
  {
  name=n;
  }

  public String getDetails()
  {
  String s =
    "Details\n"+
    "Name          : "+name; //+
//  "Creator       : "+creator+
//  "Type          : "+type+
//  "Creation Time : "+ctime+
//  "No of Columns : "+colcount;

  return(s);
  }

  public String toString()
  {
  return(name);
  }
}
