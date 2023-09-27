/**
 * Aliasing is a technique to customize the generated XML or to use a particular formatted XML using XStream.
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

import com.amc.demo.entities.Note;
import com.amc.demo.entities.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XStreamAliasTester {
   public static void main(String args[]){
	  XStreamAliasTester tester = new XStreamAliasTester();
      XStream xstream = new XStream(new StaxDriver());
      Student student = tester.getStudentDetails();
      //Object to XML Conversion
      String xml = xstream.toXML(student);
      System.out.println(formatXml(xml));		
      
      //Now assigning aliases the XStream object
      xstream.alias("student", Student.class);
      xstream.alias("note", Note.class);
      xstream.aliasField("name", Student.class, "firstName");
      xstream.addImplicitCollection(Student.class, "notes");
      
      //No need to Read again
      //Recreate the XML from the entity Student
      xml = xstream.toXML(student);
      System.out.println(formatXml(xml));		
      
      
   }	

   private Student getStudentDetails(){
      Student student = new Student("Mahesh");
      student.addNote(new Note("first","My first assignment."));
      student.addNote(new Note("second","My Second assignment."));
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