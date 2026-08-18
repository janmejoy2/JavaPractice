package oops.polymorphism;

/**
 * Calculator - Demonstrates COMPILE-TIME Polymorphism (Method Overloading)
 *
 * WHAT IS METHOD OVERLOADING?
 *   Multiple methods share the SAME name but differ in:
 *     1. Number of parameters   — e.g. calculate(a, b) vs calculate(a, b, c)
 *     2. Type of parameters     — e.g. calculate(int, int) vs calculate(double, double)
 *     3. Order of parameters    — e.g. calculate(int, double) vs calculate(double, int)
 *
 * WHY "Compile-Time"?
 *   The Java COMPILER looks at the argument types/count at compile time
 *   and binds the call to the correct method — this is called EARLY BINDING.
 *   No runtime decision is needed, unlike method overriding.
 *
 * BEST PRACTICE:
 *   - Method names should clearly describe the action (calculate is appropriate).
 *   - Each overload should have a Javadoc comment explaining WHAT it does differently.
 *   - Maintain consistent formatting: spaces around operators (a + b, not a+b).
 *   - Return type alone cannot distinguish overloads — param list must differ.
 */
public class Calculator {

	/**
	 * Overload 1: Adds two integers.
	 *
	 * @param a first integer
	 * @param b second integer
	 * @return sum of a and b
	 *
	 * COMPILE-TIME binding: Compiler picks this when two int args are passed.
	 */
	public int calculate(int a, int b) {
		return a + b; // Integer addition
	}

	/**
	 * Overload 2: Multiplies two doubles.
	 * (Note: could also be addition — kept as multiplication to show
	 *  how the same method name can perform different operations per type)
	 *
	 * @param a first double
	 * @param b second double
	 * @return product of a and b
	 *
	 * COMPILE-TIME binding: Compiler picks this when two double args are passed.
	 */
	public double calculate(double a, double b) {
		return a * b; // Double multiplication
	}

	/**
	 * Overload 3: Concatenates two Strings.
	 *
	 * @param a first String
	 * @param b second String
	 * @return concatenated result of a and b
	 *
	 * COMPILE-TIME binding: Compiler picks this when two String args are passed.
	 * NOTE: '+' on Strings does concatenation, not arithmetic addition.
	 */
	public String calculate(String a, String b) {
		return a + b; // String concatenation
	}

	/**
	 * Overload 4: Adds three integers.
	 *
	 * @param a first integer
	 * @param b second integer
	 * @param c third integer
	 * @return sum of a, b, and c
	 *
	 * COMPILE-TIME binding: Compiler picks this when THREE int args are passed.
	 * Distinguished from Overload 1 by the NUMBER of parameters.
	 */
	public int calculate(int a, int b, int c) {
		return a + b + c; // Sum of three integers
	}

}
