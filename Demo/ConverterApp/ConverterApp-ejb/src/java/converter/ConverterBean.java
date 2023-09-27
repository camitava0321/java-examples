package converter;

import javax.ejb.*;
import java.math.BigDecimal;
/**
 * This is the bean class for the ConverterBean enterprise bean.
 * Created Feb 9, 2006 7:29:05 PM
 * @author 109365
 */
public class ConverterBean implements javax.ejb.SessionBean, converter.ConverterRemoteBusiness
{
  private javax.ejb.SessionContext context;
  BigDecimal yenRate = new BigDecimal ("121.6000");
  BigDecimal euroRate = new BigDecimal ("0.0077");
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
  
  public BigDecimal dollarToYen(BigDecimal dollars) {
  BigDecimal result = dollars.multiply(yenRate);
  return result.setScale(2, BigDecimal.ROUND_UP);
  }
  public BigDecimal yenToEuro(BigDecimal yen) {
  BigDecimal result = yen.multiply(euroRate);
  return result.setScale(2, BigDecimal.ROUND_UP);
  }
  
  
  
}