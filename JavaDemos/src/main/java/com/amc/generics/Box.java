/**
 * 
 */
package com.amc.generics;

/**
 * @author Amitava Chakraborty 2010
 *
 */
public class Box<T> {

	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));

		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());

		// RAW Type - when the type argument is omitted
		Box rawBox = new Box();

		// assigning a parameterized type to its raw type is allowed:
		rawBox = stringBox; // OK

		// But assigning a raw type to a parameterized type, you get a warning:
		integerBox = rawBox; // warning: unchecked conversion

		// using a raw type to invoke generic methods
		// defined in the corresponding generic type: - also warning
		rawBox = stringBox; // allowed
		rawBox.add(8); // warning: unchecked invocation to set(T)
		// raw types bypass generic type checks,
		// deferring the catch of unsafe code to runtime.
		// Therefore, using raw types must be avoided
	}

}