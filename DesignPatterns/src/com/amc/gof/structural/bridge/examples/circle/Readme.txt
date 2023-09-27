Bridge Pattern
Used when we need to decouple an abstraction from its implementation so that the two can vary independently. 
So this pattern decouples implementation class and abstract class by providing a bridge structure between them.

An interface that acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes. 
Both types of classes can be altered structurally without affecting each other.

This demo displays Bridge pattern as a circle can be drawn in different colors using same abstract class method but different bridge implementer classes.

Implementation
A DrawAPI interface is acting as a bridge implementer and concrete classes RedCircle, GreenCircle implementing the DrawAPI interface. 
Shape is an abstract class and will use object of DrawAPI. 
BridgePatternDemo, - demo class will use Shape class to draw different colored circle.

Step 1
Create bridge implementer interface.
DrawAPI.java

Step 2
Create concrete bridge implementer classes implementing the DrawAPI interface.
RedCircle.java
GreenCircle.java

Step 3
Create an abstract class Shape using the DrawAPI interface.
Shape.java

Step 4
Create concrete class implementing the Shape interface.
Circle.java

Step 5
Use the Shape and DrawAPI classes to draw different colored circles.
BridgePatternDemo.java