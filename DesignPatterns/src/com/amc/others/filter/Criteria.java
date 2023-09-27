/**
 * 
 */
package com.amc.others.filter;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

import java.util.List;

public interface Criteria {
   public List<Person> meetCriteria(List<Person> persons);
}
