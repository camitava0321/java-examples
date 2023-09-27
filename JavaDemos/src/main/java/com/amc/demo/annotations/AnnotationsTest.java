/**
 * 
 */
package com.amc.demo.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Amitava Chakraborty(ibm) - IT Architect IBM India
 * Aug 31, 2013 
 */

@ClassPreamble(author="Amitava Chakraborty", date="31/08/2013", reviewers={"Reviewer1","Reviewer2"})
public class AnnotationsTest {

	@FieldAnnotation(description="This is a property")
	public int testField;
	
	@ConstructorAnnotation(description="This is the constructor")
	public AnnotationsTest() {
		// TODO Auto-generated constructor stub
	}
	
	@MethodAnnotation(description="This is the main method")
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//Access Annotations
		Class<AnnotationsTest> claz = AnnotationsTest.class;
		
		System.out.println("Class Annotations : "+claz.getName()+" : "+claz.getAnnotation(ClassPreamble.class));
		
		Package pkg = claz.getPackage();
		System.out.println("Package Annotation : "+pkg.getName()+" : "+Arrays.toString(pkg.getAnnotations()));
		
		Constructor<AnnotationsTest> constructor = claz.getConstructor(null);
		System.out.println("Constructor Annotation : "+constructor.getName()+" : "+Arrays.toString(constructor.getAnnotations()));
		
		Field []fields = claz.getFields();
		for (Field field2 : fields) {
			System.out.println("Field Annotation : "+field2.getName()+" : "+Arrays.deepToString(field2.getAnnotations()));
		}

		Method []method = claz.getMethods();
		for (Method method2 : method) {
			System.out.println("Method Annotation : "+method2.getName()+" : "+Arrays.toString(method2.getAnnotations()));
		}
		
	}
	
	@MethodAnnotation(description="This is a test method")
	public void testMethod() {
		
	}
}