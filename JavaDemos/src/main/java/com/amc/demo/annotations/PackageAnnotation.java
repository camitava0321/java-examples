/**
 * 
 */
package com.amc.demo.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Amitava Chakraborty 2013
 *
 */
@Documented //Meta-Annotation : Annotation ClassPreamble will be made available to Javadocs of a class where this annotation is used
@Target(ElementType.PACKAGE)  //Meta-Annotation : Annotation is applicable to a PACKAGE
@Retention(RetentionPolicy.RUNTIME)  //Meta-Annotation : The annotation to a target class is available at runtime
public @interface PackageAnnotation {
	String description() default "";

}
