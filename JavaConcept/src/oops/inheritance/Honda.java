package oops.inheritance;

/**
 * Subclass (Child Class):
 * Demonstrates Inheritance ('extends Engine') and Method Overriding.
 */
public class Honda extends Engine {

	/**
	 * METHOD OVERRIDING (Polymorphism):
	 * Honda specializes the V4 engine with its own technology (i-VTEC).
	 */
	@Override
	public String engineTypeV4() {
		return "Honda i-VTEC V4 Engine: Four Wheelers with high fuel efficiency";
	}

	public static void main(String[] args) {
		// Create an object of the child class
		Honda honda = new Honda();

		System.out.println("=== Demonstrating Inheritance in Java ===");

		// 1. INHERITED METHOD (Code Reuse):
		// engineTypeV8() is defined in Engine, not Honda, but Honda can use it directly!
		System.out.println("Inherited Method (V8):  " + honda.engineTypeV8());

		// 2. OVERRIDDEN METHOD (Specialization):
		// engineTypeV4() calls Honda's specialized version instead of Engine's default.
		System.out.println("Overridden Method (V4): " + honda.engineTypeV4());

		// 3. CALLING PARENT IMPLEMENTATION USING SUPER (Optional):
		// If you ever need the original parent version, you can invoke it with super inside an instance method.
	}

}


