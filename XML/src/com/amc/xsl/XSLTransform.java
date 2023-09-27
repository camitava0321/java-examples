/**
 * 
 */
package com.amc.xsl;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
/**
 * @author Amitava Chakraborty
 *
 */
/**
 * Transforms an input document to an output document using an XSLT stylesheet.
 * Usage: java XSLTransform input stylesheet output
 **/
public class XSLTransform {
	
	public static String inputXMLFileName="xmlFiles/log.xml";
	public static String stylesheetFileName="xmlFiles/simplelog.xsl";
	public static String outputXMLFileName="xmlFiles/out.txt";
    public static void main(String[  ] args) throws TransformerException {
        // Set up streams for input, stylesheet, and output.
        // These do not have to come from or go to files.  We can also use the
        // javax.xml.transform. {dom,sax} packages use DOM trees and streams of
        // SAX events as sources and sinks for documents and stylesheets.
        StreamSource input = new StreamSource(new File(inputXMLFileName));
        StreamSource stylesheet = new StreamSource(new File(stylesheetFileName));
        StreamResult output = new StreamResult(new File(outputXMLFileName));
        
        // Get a factory object, create a Transformer from it, and 
        // transform the input document to the output document.
        TransformerFactory factory = TransformerFactory.newInstance( );
        Transformer transformer = factory.newTransformer(stylesheet);
        transformer.transform(input, output);
    }
}