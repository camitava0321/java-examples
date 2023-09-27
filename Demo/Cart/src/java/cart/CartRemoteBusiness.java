
package cart;

import java.util.Vector;


/**
 * This is the business interface for Cart enterprise bean.
 */
public interface CartRemoteBusiness
{
  void addBook (java.lang.String title) throws java.rmi.RemoteException;

  void removeBook (java.lang.String title) throws java.rmi.RemoteException, exception.BookException;

  Vector getContents () throws java.rmi.RemoteException;
  
}
