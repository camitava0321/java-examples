/**
 * Common XML Client program to read any XML file using SAX Parser
 */
package com.amc.xml.client.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.amc.xml.client.MyXMLHandler;

/**
 * @author Amitava Chakraborty
 *
 */
public class SAXClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XMLReader myXMLReader = null;
		
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = spfactory.newSAXParser();
			
			spfactory.setNamespaceAware(true);
			spfactory.setValidating(true);
			
			myXMLReader = parser.getXMLReader();
			
			parser.parse("XMLExamples/01-errors/error.xml", new MyXMLHandler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}