
package converter;
import java.math.BigDecimal;

/**
 * This is the business interface for Converter enterprise bean.
 */
public interface ConverterRemoteBusiness
{
  BigDecimal dollarToYen (BigDecimal dollars) throws java.rmi.RemoteException;
  
  BigDecimal yenToEuro (BigDecimal yen) throws java.rmi.RemoteException;
  
}
