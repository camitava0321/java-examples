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
@Target(ElementType.TYPE)  //Meta-Annotation : Annotation ClassPreamble is applicable to a TYPE (Class,Interface etc) only
@Retention(RetentionPolicy.RUNTIME)  //Meta-Annotation : The annotation to a target class is available at runtime
public @interface ClassPreamble {
	String author();
	String date();
	int currentRevision() default 1;
	String lastModified() default "N/A";
	String lastModifiedBy() default "N/A";
	// Note use of array
	String[] reviewers();
}
