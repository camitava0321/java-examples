Flyweight pattern
Primarily used 
to reduce the number of objects created
to decrease memory footprint and increase performance.
It is a structural pattern as it provides ways to decrease objects thereby 
improving application performance.

The pattern advocates reusing already existing similar kind of objects 
by storing them and creates new object only when no matching object is found. 

Demonstration:
I shall draw 20 circle at different locations 
but in the process I shall create only 5 objects of 5 different colors.

Implementation:
Circle is the concrete class implementing a Shape interface.
A factory class ShapeFactory has a HashMap of Circles having key as color of the Circle.
Whenever a request comes to create a circle of particular color to ShapeFactory;
ShapeFactory checks the circle object in its HashMap, 
if object of Circle found, that object is returned otherwise a new object is created.
This new circle object is stored in hashmap for future use and returned to client.

Main is actual demo class which uses ShapeFactory to get a Shape object. 
It will pass information (red / green / blue/ black / white) to ShapeFactory 
to get the circle of desired color it needs.