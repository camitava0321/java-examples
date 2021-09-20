package com.amc.raagmala.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;
import com.amc.raagmala.vo.Thaat;

public class RaagDataImplDBX implements RaagData
{
private static Properties properties = new Properties();
private RandomAccessFile thaatFile ;
private RandomAccessFile raagFile;



  public RaagDataImplDBX() throws RaagDataException
  {
    try
    {
    properties.load(new FileInputStream("cfg\\raagmala.properties"));
    thaatFile = new RandomAccessFile(properties.getProperty("thaatfile"),"r");
    raagFile = new RandomAccessFile(properties.getProperty("raagfile"),"r");
    }catch(IOException e)
    {
    	System.out.println(thaatFile);
      throw new RaagDataException("Cannot Open Data Files");
    }
  }

  public Thaat[] getAllThaats() throws RaagDataException
  {
    String szBuffer ;
    Vector vec = new Vector();
    Thaat []thaats=null;

    try
    {
      while ((szBuffer = thaatFile.readLine())!=null)
        {
          vec.addElement(szBuffer.trim());
        }
  
      thaats = new Thaat[vec.size()];
      for(int i=0;i<vec.size();i++)
      {
        thaats[i]=new Thaat((String)vec.elementAt(i));
      }
    }catch(IOException e)
    {
      throw new RaagDataException("Error reading file "+thaatFile);
    }


  return thaats;
  }

  public Raag[] getAllRaags() throws RaagDataException
  {
  return  getAllRaags(null);
  }

  public Raag[] getAllRaags(Thaat thaat) throws RaagDataException
  {
  String szBuffer ;
  Vector vec = new Vector();
  Raag []raags = null;
  int sLineNo=0;
  RaagDataString data;

    try
    {
    raagFile.seek(0L);
      while ((szBuffer = raagFile.readLine())!=null)
        {
          sLineNo++;
          data = new RaagDataString(szBuffer);
          if(thaat!=null)
            {
            if(thaat.getName().equals(data.getThaat().getName()))
              {
              vec.addElement(data.getRaag());
              }
            }
          else
            {
            vec.addElement(data.getRaag());
            }
        }
  
      raags = new Raag[vec.size()];
      for(int i=0;i<vec.size();i++)
      {
        raags[i]=(Raag)vec.elementAt(i);
      }
    }catch(IOException e)
    {
      throw new RaagDataException("Error reading file "+raagFile);
    }catch(RaagDataException e1)
    {
      throw new RaagDataException(e1.getMessage()+" - "+raagFile+" - Line No : "+sLineNo);
    }



  return raags;
  }

  public Thaat getThaatDetails(String thaatName)
  {
  Thaat thaat = null;

  return thaat;
  }

  public Raag getRaagDetails(String raagName)
  {
  Raag raag = null;

  return raag;
  }

  public boolean ifRaagExist(Raag raagName)
  {
  boolean fExist = false;

  return fExist;
  }

  public void finalize() throws RaagDataException
  {
    try
    {
    thaatFile.close();
    raagFile.close();
    }catch(IOException e)
    {
      throw new RaagDataException("Error closing files");
    }
  }

}


class RaagDataString
{
String szBuffer;
Thaat thaat;
Raag raag;
int sCount=0;

  public RaagDataString(String s) throws RaagDataException
  {
  int i = 0;
  String szDummy=null;

    szBuffer=s;

  StringTokenizer tok = new StringTokenizer(szBuffer,",");
  sCount = tok.countTokens();

  if(sCount!=13)
    {
      throw new RaagDataException("File format Error");
    }

  while(tok.hasMoreTokens())
    {
    szDummy = tok.nextToken().trim();
      switch(i)
      {
      case 0:
        thaat = new Thaat(szDummy);
        break;
      case 1:
        raag = new Raag(szDummy);
        raag.setThaat(thaat);
        break;
      case 2:
        raag.setJati(szDummy);
        break;
      case 3:
        raag.setAroha(szDummy);
        break;
      case 4:
        raag.setAboroha(szDummy);
        break;
      case 5:
        raag.setVadi(szDummy);
        break;
      case 6:
        raag.setSamvadi(szDummy);
        break;
      case 7:
        raag.setPakad(szDummy);
        break;
      case 8:
        raag.setChalan(szDummy);
        break;
      case 9:
        raag.setRas(szDummy);
        break;
      case 10:
        raag.setProkriti(szDummy);
        break;
      case 11:
        raag.setTime(szDummy);
        break;
      case 12:
        raag.setRemarks(szDummy);
        break;
      }
    i++;
    }
  
  }

  public Thaat getThaat()
  {
  return thaat;
  }

  public Raag getRaag()
  {
  return raag;
  }

}

