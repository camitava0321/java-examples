/**
 * 
 */
package com.amc.lambdaexpr;

/**
 * @author Amitava Chakraborty 2023
 *
 */
public class LambdaExpressions {

	public void execute() {
		//We can create object this way
		ATypicalFunctionalInterface obj1 = new ATypicalFunctionalInterfaceImpl();
		obj1.onlyOneMethod();
		
		//But if the IMPL is needed only once, why should I create an implementation class?
		//I can create an anonymous class just for a single use.
		ATypicalFunctionalInterface obj2 = new ATypicalFunctionalInterface() {
			
			@Override
			public void onlyOneMethod() {
				System.out.println("Anonymous Implementation");
			}
		};
		obj2.onlyOneMethod();
		
		//Ok, so now I need to implement this interface only once, and
		//I need to focus only on the logic that goes inside the only method of the functional interface
		//Hence I will write only that
		ATypicalFunctionalInterface obj3 = () -> {
			System.out.println("Lambda Expression Implementation");
		};
		obj3.onlyOneMethod();
		
		//Now we will use Lambda Expression for FunctionalInterface2
		//And since we are using only one line in the logic, 
		//we will omit the curly braces as well
		FunctionalInterface2 obj4 = (int param1, String param2) -> 
			System.out.println("Dummy Implementation for "+FunctionalInterface2.class+
			" "+param1+","+param2);
		
		obj4.onlyOneMethod(4, "ABC");

		//Now we will use Lambda Expression for FunctionalInterface3
		FunctionalInterface3 obj5 = (int param1, String param2) -> {
			System.out.println("Dummy Implementation for "+FunctionalInterface3.class+
			" "+param1+","+param2);
			return 5;			
		};
		System.out.println(obj5.onlyOneMethod(6, "DEF"));
	}
}
