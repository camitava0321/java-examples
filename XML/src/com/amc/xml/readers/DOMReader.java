/**
 * An example how a DOM parser works. DOMClient.java calls this DOMReader to read an 
 * example xml file and gets a Document object corresponding to the xml back.
 */
package com.amc.xml.readers;
import java.io.*;             // For reading the input file
import org.w3c.dom.*;         // W3C DOM classes for traversing the document
import org.xml.sax.*;         // SAX classes used for error handling by JAXP
import javax.xml.parsers.*;   // JAXP classes for parsing
import javax.xml.transform.*; // For transforming a DOM tree to an XML file.
/**
 * @author Amitava Chakraborty
 *
 */
/**
 * The DOMReader is a wrapper around a DOM tree for an xml file.  
 * The methods of the class use the DOM API to work with the tree in various ways.
 **/
public class DOMReader {
	
    private org.w3c.dom.Document document;  // This field holds the parsed DOM tree

	/**
     * This constructor method is passed an XML file.  It uses the JAXP API to
     * obtain a DOM parser, and to parse the file into a DOM Document object,
     * which is used by the remaining methods of the class.
     **/
    public DOMReader(File xmlFile)
        throws IOException, SAXException, ParserConfigurationException
    {
        // Get a JAXP parser factory object
        javax.xml.parsers.DocumentBuilderFactory dbf =
            DocumentBuilderFactory.newInstance( );
        // Tell the factory what kind of parser we want 
        dbf.setValidating(false);
        // Use the factory to get a JAXP parser object
        javax.xml.parsers.DocumentBuilder parser = dbf.newDocumentBuilder( );

        // Tell the parser how to handle errors.  Note that in the JAXP API,
        // DOM parsers rely on the SAX API for error handling
        parser.setErrorHandler(new org.xml.sax.ErrorHandler( ) {
                public void warning(SAXParseException e) {
                    System.err.println("WARNING: " + e.getMessage( ));
                }
                public void error(SAXParseException e) {
                    System.err.println("ERROR: " + e.getMessage( ));
                }
                public void fatalError(SAXParseException e)
                    throws SAXException {
                    System.err.println("FATAL: " + e.getMessage( ));
                    throw e;   // re-throw the error
                }
            });

        // Finally, use the JAXP parser to parse the file.  This call returns
        // a Document object.  Once the client has this object, the class can use
        // the DOM API to work with it; JAXP is no longer required.
        document = parser.parse(xmlFile);
    }

    public org.w3c.dom.Document getDocument() {
		return document;
	}

	public void setDocument(org.w3c.dom.Document document) {
		this.document = document;
	}


} //End-Of-Class