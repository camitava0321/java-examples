package com.amc.raagmala.vo;
import java.io.*;
import java.util.Comparator;

public class Raag implements Comparator
{
public final String [][]jatis =
  {
  {"0","UNKNOWN"},
  {"11","SAMPOORNA-SAMPOORNA"},
  {"12","SAMPOORNA-SHADAVA"},
  {"13","SAMPOORNA-AUDAVA"},
  {"22","SHADAVA-SHADAVA"},
  {"23","SHADAVA-AUDAVA"},
  {"33","AUDAVA-AUDAVA"},
  {"32","AUDAVA-SHADAVA"},
  {"31","AUDAVA-SAMPOORNA"},
  {"21","SHADAVA-SAMPOORNA"}
  };
  private String name;
  private Thaat []thaats;
  private int sJati;
  private String aroha;
  private String aboroha;
  private String vadi;
  private String samvadi;
  private String pakad;
  private String chalan;
  private String ras;
  private String prokriti;
  private String time;
  private String remarks;


  public Raag(String szName)
  {
    this();
    name = szName.toUpperCase();
  }

  public Raag()
  {
      name = "";
      thaats = new Thaat[10];
      for (int i=0;i<10;i++)
        {
        thaats[i]=new Thaat();
        }
      sJati = 0;
      aroha = "";   
      aboroha = ""; 
      vadi = "";    
      samvadi = ""; 
      pakad = "";   
      chalan = "";  
      ras = "";     
      prokriti = "";
      time = "";    
      remarks="";
  }

  public Thaat getThaat()
  {
  return(thaats[0]);
  }

  public void setThaat(Thaat th)
  {
    thaats[0]=th;
  }

  public String getJatiDescription()
  {
  boolean fFound=false;
  String szJati = "NOT FOUND";

    for(int i=0;i<jatis.length;i++)
    {
      if(sJati == Integer.valueOf(jatis[i][0]).intValue())
        {
          szJati=jatis[i][1];
          break;
        }

    }
  return szJati;
  }

  public void setJati(int n)
  {
    sJati = n;
  }

  public void setJati(String s)
  {
  boolean fFound=false;

    for(int i=0;i<jatis.length;i++)
    {
      if(s.equals(jatis[i][1]))
        {
          setJati(Integer.valueOf(jatis[i][0]).intValue());
          fFound=true;
          break;
        }

    }

    if(!fFound)
      {
        setJati(0);
      }
  }

  public void setAroha(String s)
  {
    aroha = s;
  }

  public String getAroha()
  {
  return(aroha);
  }

  public void setAboroha(String s)
  {
    aboroha = s;
  }
  public String getAboroha()
  {
  return(aboroha);
  }


  public void setVadi(String s)
  {
    vadi = s;
  }
  public String getVadi()
  {
  return(vadi);
  }

  public void setSamvadi(String s)
  {
    samvadi = s;
  }
  public String getSamvadi()
  {
  return(samvadi);
  }

  public void setPakad(String s)
  {
    pakad = s;
  }

  public String getPakad()
  {
  return(pakad);
  }

  public void setChalan(String s)
  {
    chalan = s;
  }

  public String getChalan()
  {
  return(chalan);
  }


  public void setRas(String s)
  {
    ras = s;
  }
  public String getRas()
  {
  return(ras);
  }


  public void setProkriti(String s)
  {
    prokriti = s;
  }
  public String getProkriti()
  {
  return(prokriti);
  }


  public void setTime(String s)
  {
    time = s;
  }
  public String getTime()
  {
  return(time);
  }


  public void setRemarks(String s)
  {
    remarks = s;
  }
  public String getRemarks()
  {
  return(remarks);
  }


  public String getDetails()
  {
      String szBuffer;

      szBuffer = "JATI    : " + getJatiDescription() + "\n" +
                 "AROHA   : " + aroha+ "\n" +
                 "ABOROHA : " + aboroha + "\n" +
                 "VADI    : " + vadi + "\n" +
                 "SAMVADI : " + samvadi + "\n" +
                 "PAKAD   : " + pakad + "\n" +
                 "CHALAN  : " + chalan + "\n" +
                 "RAS     : " + ras + "\n" +
                 "PROKRITI: " + prokriti + "\n" +
                 "TIME    : " + time     + "\n" +
                 "REMARKS : " + remarks ;

      return szBuffer;
  }

  public String toString()
  {
  return name;
  }

  public int compare(Object raag1, Object raag2)
  {
    int retValue=0;
    if (raag1!=null && raag2!=null &&
        raag1 instanceof Raag && raag2 instanceof Raag)
    {
    retValue=raag1.toString().compareTo(raag2.toString());
    }
  return(retValue);
  }

}


