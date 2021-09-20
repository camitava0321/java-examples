package com.amc.raagmala.data;
import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;
import com.amc.raagmala.vo.Thaat;

public interface RaagData
{

  public Thaat[] getAllThaats() throws RaagDataException;

  public Raag[] getAllRaags() throws RaagDataException;

  public Raag[] getAllRaags(Thaat thaat) throws RaagDataException;

  public Thaat getThaatDetails(String thaatName);

  public Raag getRaagDetails(String raagName);

  public boolean ifRaagExist(Raag raagName);
}
