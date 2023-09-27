Pattern Definition

Define an object that encapsulates details how other objects interact with such object. The relationships are loosely decoupled.
An object A needs to interact with an object B. A can do that in two ways .. 
a) A can directly interact with B.
b) A can use an object C as a mediator to interact with B

Implementation of the second one is the Mediator Pattern. 
 
Where to use & benefits

    Partition a system into pieces or small objects.
    Centralize control to manipulate participating objects(a.k.a colleagues)
    Clarify the complex relationship by providing a board committee.
    Limit subclasses.
    Improve objects reusabilities.
    Simplify object protocols.
    The relationship between the control class and other participating classes is multidirectional.
    Related patterns include
        Facade, which abstracts a subsystem to provide a more convenient interface, and its protocol is unidirectional, whereas a mediator enables cooperative behavior and its protocol is multidirectional.
        Command, which is used to coordinate functionality.
        Observer, which is used in mediator pattern to enhance communication. 

When a program is made up of a number of classes, the logic and computation is divided logically among these classes. 
However, as more of these isolated classes are developed in a program, the problem of communication between these classes become more complex. 
The more each class needs to know about the methods of another class, the more tangled the class structure can become. 
This makes the program harder to read and harder to maintain. 
Further, it can become difficult to change the program, since any change may affect code in several other classes. 
The Mediator pattern addresses this problem by promoting looser coupling between these classes.
Mediators accomplish this by being the only class that has detailed knowledge of the methods of other classes. 
Classes send inform the mediator when changes occur and the Mediator passes them on to any other classes that need to be informed.
