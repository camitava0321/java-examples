package com.amc.demo.data.db2;

public class DB2Error
{
private String error;

  public DB2Error()
  {
  this(null);
  }

  public DB2Error(String s)
  {
  setError(s);
  }

  public void setError(String s)
  {
  error=s;
  }

  public String getError()
  {
  return(error);
  }
}
