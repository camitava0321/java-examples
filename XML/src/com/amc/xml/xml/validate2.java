/**
 *
 * @author  109365
 */

package com.amc.xml.xml;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
 
public class validate2 {
  static public void main(String[] argv) {
  
    if (argv.length == 0) {
     System.out.println(
        "Usage: java validate2 file:<filename> or \n"
       + "or java validate2 uri");
   }
  
    XMLReader parser = null;
    // try to activate validation
    try {
      parser = XMLReaderFactory.createXMLReader(
               "javax.xml.parsers.SAXParser");
      // these features must be set to
      // validate schemas
      parser.setFeature(
          "http://xml.org/sax/features/validation",
          true);
      parser.setFeature(
   "http://apache.org/xml/features/validation/schema",
   true);
    } catch (SAXException e) {
      System.err.println(
         "Cannot activate validation."); 
    }
 
    // parse the document
    try {
      //System.out.println(argv[0]);
      parser.parse("tij_menu.xml");
    } catch (SAXParseException e) {
         System.out.println(e.getMessage()
           + " at line " + e.getLineNumber()
           + ", column " + e.getColumnNumber());
    } catch (SAXException e) {
        System.err.println(
          "XML exception reading document.");
    } catch (IOException e) {
        System.err.println(
          "I/O exception reading XML document:\n"
          + e.getMessage());
    }
  }
}
