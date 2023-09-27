Filter pattern or Criteria pattern
A design pattern that enables developers to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations. 
Structural pattern as this pattern combines multiple criteria to obtain single criteria.

Implementation
We create a Person object, Criteria interface and concrete classes implementing this interface to filter list of Person objects. 
CriteriaPatternDemo, - demo class uses Criteria objects to filter List of Person objects based on various criteria and their combinations.

Step 1
Create a class on which criteria is to be applied.
Person.java

Step 2
Create an interface for Criteria.
Criteria.java

Step 3
Create concrete classes implementing the Criteria interface.
CriteriaMale.java
CriteriaFemale.java
CriteriaSingle.java
AndCriteria.java
OrCriteria.java

Step4
Use different Criteria and their combination to filter out persons.
CriteriaPatternDemo.java