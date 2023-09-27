Prototype pattern 
Create duplicate object keeping performance in mind. 
This pattern involves implementing a prototype interface which tells to create a clone of the current object. 
This pattern is used when creation of object directly is costly. 
For example, an object is to be created after a costly database operation. 
We can cache the object, returns its clone on next request and update the database as and when needed thus reducing database calls.

Implementation
Create an abstract class Shape and 
concrete classes extending the Shape class. 
A class ShapeCache is defined as a next step which stores shape objects in a Hashtable and 
returns their clone when requested.

PrototypPatternDemo - demo class will use ShapeCache class to get a Shape object.

Step 1
Create an abstract class implementing Clonable interface.
Shape.java

Step 2
Create concrete classes extending the above class.
Rectangle.java
Square.java
Circle.java

Step 3
Create a class to get concrete classes from database and store them in a Hashtable.
ShapeCache.java

Step 4
PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a Hashtable.
PrototypePatternDemo.java