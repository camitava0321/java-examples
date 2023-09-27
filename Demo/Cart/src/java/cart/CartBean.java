package cart;
import exception.BookException;
import java.util.Vector;
import javax.ejb.CreateException;
import util.IdVerifier;

/**
 * This is the bean class for the CartBean enterprise bean.
 * Created Feb 9, 2006 9:23:49 PM
 * @author 109365
 */
public class CartBean implements javax.ejb.SessionBean, cart.CartRemoteBusiness
{
  private javax.ejb.SessionContext context;
  private String customerName;
  private String customerId;
  private Vector contents;
  
  // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">
  // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
  // TODO Add business methods or web service operations
  /**
   * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
   */
  public void setSessionContext (javax.ejb.SessionContext aContext)
  {
    context = aContext;
  }
  
  /**
   * @see javax.ejb.SessionBean#ejbActivate()
   */
  public void ejbActivate ()
  {
    
  }
  
  /**
   * @see javax.ejb.SessionBean#ejbPassivate()
   */
  public void ejbPassivate ()
  {
    
  }
  
  /**
   * @see javax.ejb.SessionBean#ejbRemove()
   */
  public void ejbRemove ()
  {
    
  }
  // </editor-fold>
  
  /**
   * See section 7.10.3 of the EJB 2.0 specification
   * See section 7.11.3 of the EJB 2.1 specification
   */
  public void ejbCreate ()
  {
    // TODO implement ejbCreate if necessary, acquire resources
    // This method has access to the JNDI context so resource aquisition
    // spanning all methods can be performed here such as home interfaces
    // and data sources.
  }
  
  
  
  // Add business logic below. (Right-click in editor and choose
  // "EJB Methods > Add Business Method" or "Web Service > Add Operation")

  public void ejbCreate (java.lang.String person) throws javax.ejb.CreateException
  {
  if (person == null) 
  {
  throw new CreateException(
  "Null person not allowed.");
  } 
  else 
  {
  customerName = person;
  }
  customerId = "0";
  contents = new Vector();  
  }

  public void ejbCreate (java.lang.String person, java.lang.String id) throws javax.ejb.CreateException
  {
  if (person == null) 
  {
  throw new CreateException(
  "Null person not allowed.");
  } 
  else 
  {
  customerName = person;
  }
  customerId = "0";
  contents = new Vector();
  IdVerifier idChecker = new IdVerifier();
  if (idChecker.validate(id)) 
  {
  customerId = id;
  } 
  else 
  {
  throw new CreateException("Invalid id: "+ id);
  }
  contents = new Vector();
  }

  public void addBook (java.lang.String title)
  {
  contents.add(title);
  }

  public void removeBook (java.lang.String title) throws BookException, java.rmi.RemoteException
  {
  boolean result = contents.remove(title);
    if (result == false) 
    {
    throw new BookException(title + "not in cart.");
    }
  }

  public Vector getContents ()
  {
  return contents;
  }



}
