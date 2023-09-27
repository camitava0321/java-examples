Factory pattern
One of the best ways to create an object.
1. Create object without exposing the creation logic to the client
2. Refer to newly created object using a common interface.

Implementation
We shall create 
a Shape interface
concrete classes implementing the Shape interface 
A factory class ShapeFactory

FactoryPatternDemo, the demo class will use ShapeFactory to get a Shape object. 
It will pass information (CIRCLE / RECTANGLE / SQUARE) to ShapeFactory to get the type of object it needs.

Step 1
Create an interface - Shape.java

Step 2
Create concrete classes implementing the same interface.
Rectangle.java
Square.java
Circle.java

Step 3
Create a Factory - ShapeFactory.java - to generate object of concrete class based on given information.

Step 4
Use the Factory to get object of concrete class by passing an information such as type.
Run - FactoryPatternDemo.java
