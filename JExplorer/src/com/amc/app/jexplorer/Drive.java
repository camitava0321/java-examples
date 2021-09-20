package com.amc.app.jexplorer;

public class Drive
{
private char chDrive;
private String szNetName;
private String szAlias;
private String szDriveLabel;
private boolean fLocal;

  public Drive(char name,String label,boolean local)
  {
    chDrive=name;
    szDriveLabel = label;
    fLocal=local;
  }

  public Drive(char name,String label,String local)
  {
    chDrive=name;
    szDriveLabel = label;
    fLocal=Boolean.getBoolean(local);
  }

  public String getNetName()
  {
  return szNetName;
  }

  public String getAlias()
  {
  return szAlias;
  }

  public void setNetName(String name)
  {
  szNetName=name;
  }

  public void setAlias(String alias)
  {
  szAlias=alias;
  }

  public char getDriveLetter()
  {
  return chDrive;
  }

  public String toString()
  {
  return String.valueOf(chDrive);
  }


}
