/*
 * BookException.java
 *
 * Created on February 9, 2006, 9:27 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package exception;

/**
 *
 * @author 109365
 */
public class BookException extends java.lang.Exception
{
  
  /** Creates a new instance of BookException */
  public BookException ()
  {
  }
  public BookException(String msg) 
  {
  super(msg);
  }
}
