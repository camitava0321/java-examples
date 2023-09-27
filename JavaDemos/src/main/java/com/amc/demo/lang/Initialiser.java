package com.amc.demo.lang;
public class Initialiser {
   final int i;
   final static int c;

   Initialiser() {
   }

   Initialiser(char x) {
      // This assignment statement would cause a compiler error
      // since i was already initialized in the instance
      // initializer.
      // i = x;  // compiler error
   }

   static {
      System.out.println("static init 1");
      // This assignment statement would cause a compiler error
      // since c has not yet been initiaized and therefore,
      // cannot be referred to.
      // System.out.println("c=" + c);  // compiler error
   }

   static {
      System.out.println("static init 2");
      c = 1;
   }

   static {
      // Now, it's safe to refer to c since it's been initialized
      // in the previous static initializer.
      System.out.println("static init 3, c=" + c);
   }

   {
      System.out.println("instance initializer 1");
      // Referring to i here would cause a compiler error since
      // i has not been initialized:
      // System.out.println("i=" + i); // compiler error
   }

   {
      System.out.println("instance initializer 2");
      // This is where i gets initialized. Remember, all instance initializers
      // are executed *before* the first statement in any constructor.
      i = 12;
   }

   public static void main(String[] args)
   {
      new Initialiser();
   } // main()
}
