package oops.polymorphism;

/**
 * PolymorphismDemo - Main class to demonstrate both types of Polymorphism in Java.
 *
 * POLYMORPHISM means "many forms" — the same interface behaving differently
 * depending on the actual object or arguments involved.
 *
 * Java supports TWO types:
 * ┌──────────────────────┬──────────────────────────────────────────┐
 * │ Type                 │ Mechanism                                │
 * ├──────────────────────┼──────────────────────────────────────────┤
 * │ Compile-time (Early) │ Method Overloading — resolved by compiler│
 * │ Runtime (Late)       │ Method Overriding  — resolved by JVM     │
 * └──────────────────────┴──────────────────────────────────────────┘
 */
public class PolymorphismDemo {

	public static void main(String[] args) {

		// =====================================================================
		// PART 1: RUNTIME POLYMORPHISM (Method Overriding + Dynamic Dispatch)
		// =====================================================================
		System.out.println("=========================================");
		System.out.println("  RUNTIME POLYMORPHISM (Method Overriding)");
		System.out.println("=========================================\n");

		/*
		 * UPCASTING — storing child objects in a parent-type reference.
		 *
		 * Vehicle[] is the array type (parent), but each slot holds a
		 * child object: Car, ElectricCar, Truck.
		 *
		 * Syntax:  Vehicle v = new Car();
		 *                 ↑             ↑
		 *           Parent type     Child object  → UPCASTING (implicit, safe)
		 *
		 * Why is this useful?
		 *   We can write ONE loop that handles ALL vehicle types uniformly,
		 *   without knowing the exact subtype — this is the power of polymorphism.
		 */
		Vehicle[] vehicles = {
			new Car(),          // Vehicle ref → Car object
			new ElectricCar(),  // Vehicle ref → ElectricCar object
			new Truck()         // Vehicle ref → Truck object
		};

		/*
		 * DYNAMIC METHOD DISPATCH (Late Binding):
		 *
		 * The for-each loop iterates with type 'Vehicle'.
		 * At compile time → compiler sees Vehicle.start() (abstract)
		 * At runtime      → JVM checks the REAL object type and calls
		 *                   Car.start() / ElectricCar.start() / Truck.start()
		 *
		 * This runtime decision is called DYNAMIC DISPATCH or LATE BINDING.
		 * It is what makes runtime polymorphism work.
		 */
		for (Vehicle v : vehicles) {
			// Print the actual runtime class name for clarity
			System.out.println("--- " + v.getClass().getSimpleName() + " ---");

			v.start();    // Dispatches to the overridden start() of the actual object
			v.fuelType(); // Dispatches to the overridden fuelType() of the actual object
			v.stop();     // NOT overridden — always calls Vehicle's concrete stop()

			System.out.println(); // Blank line between vehicles for readability
		}

		// =====================================================================
		// PART 2: COMPILE-TIME POLYMORPHISM (Method Overloading)
		// =====================================================================
		System.out.println("=========================================");
		System.out.println(" COMPILE-TIME POLYMORPHISM (Overloading)");
		System.out.println("=========================================\n");

		Calculator calc = new Calculator();

		/*
		 * METHOD OVERLOADING — same method name, different signatures.
		 *
		 * The COMPILER resolves which calculate() to call by inspecting
		 * the NUMBER and TYPE of arguments at compile time (early binding).
		 *
		 * No runtime decision is involved — this is purely the compiler's job.
		 */

		// Compiler picks: calculate(int, int) → Integer addition
		System.out.println("calculate(10, 20)           -> Sum:         " + calc.calculate(10, 20));

		// Compiler picks: calculate(double, double) → Double multiplication
		System.out.println("calculate(4.5, 2.0)         -> Product:     " + calc.calculate(4.5, 2.0));

		// Compiler picks: calculate(String, String) → String concatenation
		System.out.println("calculate(\"Hello\", \"World\") -> Concat:      " + calc.calculate("Hello, ", "World!"));

		// Compiler picks: calculate(int, int, int) → Sum of three ints
		System.out.println("calculate(5, 10, 15)        -> Sum of 3:    " + calc.calculate(5, 10, 15));
	}

}
