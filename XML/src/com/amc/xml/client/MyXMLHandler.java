/**
 * This is the SAX Eventhandler used by the SAX Client program.
 */
package com.amc.xml.client;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Amitava Chakraborty
 *
 */
public class MyXMLHandler extends DefaultHandler{

	private int entityIndent=0;
	private String parameterIndent="   ";
	private String tagValueIndent="   ";
	
	public MyXMLHandler()
	{
	super();	
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("\nEOF");
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("Document Start");
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		entityIndent--;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.print("\n"+getIndent()+qName);
		printAttributesForAnElement(attributes);
		entityIndent++;
	}
	
	private void printAttributesForAnElement(Attributes attributes)
	{
		int numAttributes = attributes.getLength();
		String attributeValue="";
		if (numAttributes>0) {
			System.out.print(parameterIndent);
		}
		for (int i = 0; i < numAttributes; i++) {
			if (attributes.getValue(i)==null ||
					attributes.getValue(i).length()==0) {
				attributeValue="<null>";
			}
			else
			{
				attributeValue=attributes.getValue(i);
			}
			System.out.print(attributes.getQName(i)+"="+
					attributeValue+"\t");
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	String data = new String(ch, start, length);
	if (data.trim().length()>0) {
		System.out.print("="+data);
	}
	}

	private String getIndent()
	{
		StringBuffer strBuffer = new StringBuffer();
		if (entityIndent>0) {
			for (int i = 0; i < entityIndent; i++) {
				strBuffer.append(" ");
			}
		}
		return(strBuffer.toString());
	}
}
