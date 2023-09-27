package com.amc.demo.lang;
/** A treatise on Abstract Class and Methods
 *  Only Class and Method names NOT VARIABLES, may have modifier abstract
 *  @author Amitava Chakraborty
 *  @version 1.0.0
 */

/*****************************************************************************/
/* The main class which has the main function                                */
/*****************************************************************************/
public class Abstract
{

/*****************************************************************************/
/* The main function                                                         */
/*****************************************************************************/
  public static void main (String [] args)
  {
    /* The class AnAbstract is declared as an abstract class
     * Hence it cannot be instantiated
     * The following line if uncommented will generate compilation error
     */
    //AnAbstract abs1 = new AnAbstract();

    /* The class AgainAbstract is a sub-class of class AnAbstract. But since it
     * does not define all the abstract methods of AnAbstract class it is also
     * to be declared as an abstract class
     * hence AgainAbstract class also cannot be instantiated
     * The following line if uncommented will generate compilation error
     */
    //AgainAbstract abs2 = new AgainAbstract();


    /* The class Other is sub-classed from abstract class AnAbstract
     * and this can be instantiated
     * SO CLASSES SUB-CLASSED FROM AN ABSTRACT CLASS CAN BE INSTANTIATED, PROVIDED
     * THAT THE SUBCLASS ITSELF IS NOT ANOTHER ABSTRACT CLASS
     */
    Other oth = new Other();


  }// End of main

}//End of class Abstract


/** This is the main Abstract Class
 *  A CLASS HAS TO BE DECLARED ABSTRACT IF IT CONTAINS ATLEAST ONE ABSTRACT METHOD
 */
abstract class AnAbstract
{
  //abstract int some;                        /* Variables cannot be abstract */

/*****************************************************************************/
/* some properly defined abstract method                                     */
/*****************************************************************************/
  abstract void anAbstractMethod();           /* Abstract Method may be public*/
  public abstract int abstractMethod2();      /* not private         ...      */


/*****************************************************************************/
/* Some improperly defined abstract methods                                  */
/* The lines if uncommented will generate comilation error                   */
/*****************************************************************************/
  //abstract void anCannotAbstractMethod()    /* abstract method cannot have */
  //{                                         /* a method-body               */
  //}

  //static abstract void abstractMethod4();   /* Static methods cannot be    */
                                              /* abstract                    */
  //final abstract void abstractMethod4();    /* Final methods cannot be     */
                                              /* declared as abstract because*/
                                              /* final methods cannot be     */
                                              /* Overridden                  */
  //private abstract int abstractMethod3();

/*****************************************************************************/
/* An abstract class may contain other non-abstract methods                  */
/*****************************************************************************/
  void doNothing()                            /* Non-abstract methods may have*/
  {                                           /* any access parameters(public */
  System.out.println("abc");                  /* private,..)                 */
  }

  private void doNothing(double d)
  {
  System.out.println("abc");
  }

  static void doNothing(int i)                /* non-abstract methods may be */
  {                                           /* static                      */
  }

  final void doNothing(float f)               /* non-abstract methods may be */
  {                                           /* final                       */
  }

}// End of class AnAbstract



/** AgainAbstract is another abstract class directly sub-classes from AnAbstract
 *  This is an abstract class because it does not defines other abstract methods
 *  of the Parent abstract class, ie class AnAbstract
 */
abstract class AgainAbstract extends AnAbstract
{

/*****************************************************************************/
/* It overloads an abstract method of the Parent class                       */
/* A sub-class may overload a Parent's method and the overloaded method may be*/
/* more private than the Parent's method, can even return different type     */
/*****************************************************************************/
  abstract int abstractMethod2(int i);
  abstract float abstractMethod2(float f);


/*****************************************************************************/
/* It overrides an normal   method of the Parent class                       */
/* A sub-class may override a Parent's method but the overridden method should*/
/* not be more private than the Parent's method                              */
/*****************************************************************************/
  //private static void doNothing(int i)
  static void doNothing(int i)
  {
      System.out.println("Overridden");
  }

/*****************************************************************************/
/* It overrides a normal method of Parent class, but declares it abstract    */
/*****************************************************************************/
  abstract void doNothing();


}// End of class AgainAbstract


/** The class Other is a sub-class of main abstract class AnAbstract
 */
class Other extends AnAbstract
{

/*****************************************************************************/
/* Overriddes parent's normal method                                         */
/*****************************************************************************/
  void doNothing()
  {
  }

/*****************************************************************************/
/* Defines Parent's abstract method                                          */
/* To be able to become a normal class which may be sub-classed, a class has */
/* to define all the abstract methods of the Parent class                    */
/*****************************************************************************/
  void anAbstractMethod()                     /* One can override the method */
  {                                           /* defined as abstract in the  */
  System.out.println("doSomething");          /* parent abstract class as    */
  }                                           /* abstract                    */

  public int abstractMethod2()
  {
  return 1;
  }

  int abstractMethod3()
  {
  return 1;
  }

  static void abstractMethod4()
  {
  }

}
