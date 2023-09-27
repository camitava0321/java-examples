/**
 * An example how a DOM parser works. The code reads a sample web.xml and prints a servlet class
 * and the xml.
 */
package com.amc.xml.client;
import java.io.*;             // For reading the input file
import org.w3c.dom.*;         // W3C DOM classes for traversing the document
import org.xml.sax.*;         // SAX classes used for error handling by JAXP

import com.amc.xml.readers.DOMReader;

import javax.xml.parsers.*;   // JAXP classes for parsing
import javax.xml.transform.*; // For transforming a DOM tree to an XML file.
/**
 * @author Amitava Chakraborty
 *
 */
/**
 * A WebAppConfig object is a wrapper around a DOM tree for a web.xml
 * file.  The methods of the class use the DOM API to work with the
 * tree in various ways.
 **/
public class DOMClient {
	
	//The example xml file.
	public final static String webXMLFileName = "xmlFiles/web.xml";
	//The Class corresponding to this servlet name will be printed.
	public final static String servletName = "action";
    
	private static org.w3c.dom.Document document;  // This field holds the parsed DOM tree

    
    /**
     * 
     **/
    public DOMClient()
    {
    	super();
    }

    /**
     * This method looks for specific Element nodes in the DOM tree in order
     * to figure out the classname associated with the specified servlet name
     **/
    public String getServletClass(String servletName) {
        // Find all <servlet> elements and loop through them.
        NodeList servletnodes = document.getElementsByTagName("servlet");
        int numservlets = servletnodes.getLength( );
        for(int i = 0; i < numservlets; i++) {
            Element servletTag = (Element)servletnodes.item(i);
            // Get the first <servlet-name> tag within the <servlet> tag
            Element nameTag = (Element)
                servletTag.getElementsByTagName("servlet-name").item(0);
            if (nameTag == null) continue;

            // The <servlet-name> tag should have a single child of type
            // Text.  Get that child, and extract its text.  Use trim( )
            // to strip whitespace from the beginning and end of it.
            String name =((Text)nameTag.getFirstChild( )).getData( ).trim( );
           
            // If this <servlet-name> tag has the right name
            if (servletName.equals(name)) {
                // Get the matching <servlet-class> tag
                Element classTag = (Element)
                    servletTag.getElementsByTagName("servlet-class").item(0);
                if (classTag != null) {
                    // Extract the tag's text as above, and return it
                    Text classTagContent = (Text)classTag.getFirstChild( );
                    return classTagContent.getNodeValue( ).trim( );
                }
            }
        }

        // If we get here, no matching servlet name was found
        return null;
    }

    /**
     * This method adds a new name-to-class mapping in in the form of
     * a <servlet> sub-tree to the document.
     **/
    public void addServlet(String servletName, String className) {
        // Create the <servlet> tag
        Element newNode = document.createElement("servlet");
        // Create the <servlet-name> and <servlet-class> tags
        Element nameNode = document.createElement("servlet-name");
        Element classNode = document.createElement("servlet-class");
        // Add the name and classname text to those tags
        nameNode.appendChild(document.createTextNode(servletName));
        classNode.appendChild(document.createTextNode(className));
        // And add those tags to the servlet tag
        newNode.appendChild(nameNode);
        newNode.appendChild(classNode);
        
        // Now that we've created the new sub-tree, figure out where to put
        // it.  This code looks for another servlet tag and inserts the new
        // one right before it. Note that this code will fail if the document
        // does not already contain at least one <servlet> tag.
        NodeList servletnodes = document.getElementsByTagName("servlet");
        Element firstServlet = (Element)servletnodes.item(0);

        // Insert the new node before the first servlet node
        firstServlet.getParentNode( ).insertBefore(newNode, firstServlet);
    }

    /**
     * Output the DOM tree to the specified stream as an XML document.
     * See the XMLDocumentWriter example for the details.
     **/
    public void output(PrintWriter out)
        throws TransformerConfigurationException, TransformerException
    {
        TransformerFactory factory = TransformerFactory.newInstance( );
        Transformer transformer = factory.newTransformer( );

        transformer.transform(new javax.xml.transform.dom.DOMSource(document),
                              new javax.xml.transform.stream.StreamResult(out));
    }
    /** The main method creates and demonstrates a WebAppConfig object */
    public static void main(String[  ] args)
        throws IOException, SAXException, ParserConfigurationException,
               TransformerConfigurationException, TransformerException
    {
    	DOMClient client = new DOMClient();
        // Create a new WebAppConfig object that represents the web.xml
        // file specified by the first command-line argument
        DOMReader domReader = new DOMReader(new File(webXMLFileName));
        // Query the tree for the class name associated with the specified
        // servlet name
        document = domReader.getDocument();
        System.out.println("Class for servlet " + servletName + " is " +
                           client.getServletClass(servletName));
        // Add a new servlet name-to-class mapping to the DOM tree
        client.addServlet("amitava", "com.amc.client.DOMClient");
        // And write out an XML version of the DOM tree to standard out
        client.output(new PrintWriter(System.out));
    }


} //End-Of-Class