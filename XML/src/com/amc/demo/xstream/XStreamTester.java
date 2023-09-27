/**
 * A student object is created and then serialized to an XML String. 
 * Then deserialize the same XML String to obtain the student object back.
 */
package com.amc.demo.xstream;

/**
 * @author Amitava Chakraborty 2009 (ibm)
 *
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.amc.demo.entities.Address;
import com.amc.demo.entities.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XStreamTester {

	
	public static void main(String args[]){
      XStreamTester tester = new XStreamTester();
      
      //Create XStream object by passing it a StaxDriver. 
      //StaxDriver uses Stax pull parser (very fast xml parser).
      XStream xstream = new XStream(new StaxDriver());

      Student student = tester.getStudentDetails();
      
      //Object to XML Conversion
	  //Serialize Object to XML : Use toXML() method to get the XML string representation of Object.
      String xml = xstream.toXML(student);
      System.out.println(formatXml(xml));

      //XML to Object Conversion
      //DeSerialize XML to get Object : Use fromXML() method to get the Object from the XML.
      Student student1 = (Student)xstream.fromXML(xml);
      System.out.println(student1);
   }	

   private Student getStudentDetails(){
      Student student = new Student();
      student.setFirstName("Mahesh");
      student.setLastName("Parashar");
      student.setRollNo(1);
      student.setClassName("1st");

      Address address = new Address();
      address.setArea("H.No. 16/3, Preet Vihar.");
      address.setCity("Delhi");
      address.setState("Delhi");
      address.setCountry("India");
      address.setPincode(110012);

      student.setAddress(address);
      return student;
   }

   public static String formatXml(String xml){
      try{
         Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
         serializer.setOutputProperty(OutputKeys.INDENT, "yes");
         serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
         Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
         StreamResult res =  new StreamResult(new ByteArrayOutputStream());            
         serializer.transform(xmlSource, res);
         return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
      }catch(Exception e){         
         return xml;
      }
   }
}