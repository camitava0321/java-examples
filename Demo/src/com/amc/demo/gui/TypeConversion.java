package com.amc.demo.gui;
/**
 *  Table of Type Conversion for Objects
    NewType newType;
    OldType oldType = new OldType()
    newType = oldType;

 *  +-------------------------------------------------------------------------+
 *  |NewType is| Class    |Interface |  Array  |
 *  |OldType is|          |          |         |
 *  +-------------------------------------------------------------------------+
 *  |  Class   |   OK     |    OK    |    X    |
 *  |          |          |Only if   |         |
 *  |          |          |the class |         |
 *  |          |          |implements|         |
 *  |          |          |the       |         |
 *  |          |          |interface |         |
 *  +-------------------------------------------------------------------------+
 *  |Interface |OK if the |
 *  |          |class impl|
 *  |          |ements the|
 *  |          |interface |
 *  |          |or subclas|
 *  |          |ses such a|
 *  |          |class     |
 *  +-------------------------------------------------------------------------+
 *  |  Array   |          |
 *  +-------------------------------------------------------------------------+
 * @author Amitava Chakraborty
 */
public class TypeConversion
{
    public static void main (String [] args)
    {
    //Normal Objects
    Object object;                            /* Highest Class               */
    Object objects[];                         /* Highest Array               */
    Domesticable domestic;                    /* Interface                   */

    Animal animal = new Animal();             /* 1st level                   */
        Vertebrate vertebrate =               /* 2nd Level                   */
            new Vertebrate();
            Dog dog = new Dog();              /* 3rd Level                   */
                Poodle poodle = new Poodle(); /* 4th Level                   */
                Doberman doberman =           /* 4th Level                   */
                    new Doberman();
                Bulldog bulldog =             /* 4th Level                   */
                    new Bulldog();


    //Arrays
    Animal []animals = new Animal[2];
        Vertebrate []vertebrates = new Vertebrate[2];
            Dog []dogs = new Dog[2];
                Poodle []poodles = new Poodle[2];
                Doberman []dobermans = new Doberman[2];
                Bulldog []bulldogs = new Bulldog[2];



    //You cannot assign a sibling object to another sibling object
    //poodle = bulldog;                       /* Invalid conversion          */

    //poodle is a sub-class of dog
    dog = poodle;                             /* Valid Conversion            */

    //dog is a vertebrate
    vertebrate = dog;                         /* Valid Conversion            */

    //vertebrate is an animal
    animal = vertebrate;                      /* Valid Conversion            */

//  System.out.println(animal.sweetness);     /* Though animal has a poodle's*/
                                              /* reference one cannot access */
                                              /* poodle specific members     */
                                              /* because animal is of Animal */
                                              /* class but any members of    */
    System.out.println(animal.linkToHuman);   /* Animal overridden in Poodle */
    animal.eat();                             /* if accessed will behave as  */
                                              /* overridden                  */

    dog = (Dog)animal;                        /* Still dog actually has a    */
    dog.eat();                                /* poodle refrnce, so the      */
                                              /* poodle's overridden method  */
                                              /* is called in                */


/*****************************************************************************/
/* Interfaces                                                                */
/*****************************************************************************/
    domestic = poodle;                        /* Since dog implements the    */
    domestic = dog;                           /* interface and poodle extends*/
//  domestic = vertebrate;                    /* dog both may be converted to*/
//  domestic = animal;                        /* Domesticable                */

    vertebrate = (Vertebrate)new Dog();
    vertebrate.eat();

    object = domestic;

    dog = (Dog)object;
    dog = (Dog)domestic;
    dog.eat();


/*****************************************************************************/
/* Array Type Conversions                                                    */
/*****************************************************************************/
//  animals = animal;                         /* Can't convert Animal to Animal[]*/
//  objects = animal;                         /* Can't convert Animal to Object[]*/
//  animal = animals;                         /* Can't convert Animal[] to Animal*/
//  animal = bulldogs;                        /* Can't convert Bulldog[] to Animal*/
    object = animals;                         /* Since arrays are also derived*/
    object = bulldogs;                        /* from object they can be     */
    dogs = (Dog [])object;                    /* converted to object and back*/

    }

}

/** Parent Class - Top Level
 */
class Animal
{
    int canMove=1;
    int linkToHuman=0;

    void eat()
    {
        System.out.println("Please override me for specific animal");
    }
}

/** Sub Class of Animal 2nd Level
 */
class Vertebrate extends Animal
{
    int hasSpinalChord=1;
    int strengthOfVertebra=0;
}

/** Sub Class of Vertebrate 3rd Level
 */
class Dog extends Vertebrate implements Domesticable
{
    boolean canBark=true;
    public void domesticate()
    {
        //domesticate the dog
    }

    void eat()
    {
        System.out.println("Each dog eat its own way");
    }
}

/** Sub Class of Dog        4th Level
 */
class Poodle extends Dog
{
    int sweetness=100;
    Poodle()
    {
        linkToHuman=10;
        strengthOfVertebra=4;
    }


    void eat()
    {
        System.out.println("I eat as a Poodle eats");
    }
}

/** Sub Class of Dog        4th Level
 */
class Doberman extends Dog
{
    int strength=200;
}

/** Sub Class of Dog        4th Level
 */
class Bulldog extends Dog
{
    int reliablity=300;
}


interface Domesticable
{
    public void domesticate();
}
