package com.amc.demo.lang;
/** This is an example how loading of class happend in Java
 *  Inheritence Diagram of the classes
 *  Parent <- Child <- ClassLoader
 *
 *  
 *  @author Amitava Chakraborty
 */
public class ClassLoader extends Child
{

    /** Static variable initialization happens once when the class loads
     *  not for every object creation
     */
    public static int staticClassLoader = sysout("Initializing ClassLoader.staticClassLoader",72);
    public int otherClassLoader = sysout("Initializing ClassLoader.otherClassLoader",1);


    public ClassLoader()
    {
        System.out.println("Now Constructing ClassLoader");
    }



    /** As soon as the JVM starts to run main method of this class
     *  it will start to load the class.
     *  While doing so it finds that this class extends Child and it attempts to load the class Child
     *  While loading Child it finds that Child extends Parent and it attempts to load Parent
     *  During loading of Parent it excutes all the static part first, so
     *  the initialisation of staticParent happens; even if the variable staticOtherParent is also static
     *  since it is appearing inside a non-static block it does not get executed
     *  Then the class Child loads and all its static variables are initialized and the static blocks executed
     *  So staticChild gets initialized and the static block gets executed
     *  The the class ClassLoader gets loaded and staticClassLoader variable is initialized
     *  The the first statement inside the main is executed
     */
    public static void main(String [] args)
    {

        System.out.println("Now came in main");

        /* As cl is created it executes the constructor of the root class(Parent)
         * Then it executes the constructor of Child
         * Since all the static variables are initialized and the static blocks have been
         * executed already they are not repeated again
         */
        ClassLoader cl = new ClassLoader();

        ClassLoader cl2 = new ClassLoader();

        System.out.println("End of Main");
    }

}

class Parent
{
    public static int staticParent = sysout("Initializing Parent.staticParent",24);
    public static int staticOtherParent;

    public Parent()
    {
        System.out.println("Constructing Parent");
    }

    {
        staticOtherParent = sysout("Initializing Parent.staticOtherParent",50);
        System.out.println("Doing some stuff in Parent Normal block");
    }

    public static int sysout(String arg,int intValue)
    {
        System.out.println(arg);
        return intValue;
    }
}

class Child extends Parent
{

    public static int staticChild = sysout("Initializing Child.staticChild",48);

    static
    {
        System.out.println("Doing some stuff in Child static block");
    }

    public Child()
    {
        System.out.println("Constructing Child");
    }
}
