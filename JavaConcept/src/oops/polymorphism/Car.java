package oops.polymorphism;

/**
 * Car - Concrete Subclass of Vehicle
 *
 * PURPOSE:
 *   Represents a petrol-powered car.
 *   Demonstrates RUNTIME POLYMORPHISM by overriding abstract methods
 *   from the Vehicle superclass with Car-specific behavior.
 *
 * IS-A RELATIONSHIP (Inheritance):
 *   Car IS-A Vehicle → so a Car object can be stored in a Vehicle reference.
 *   Example:  Vehicle v = new Car();  // Valid — Upcasting
 *
 * BEST PRACTICE:
 *   - Always use @Override annotation when overriding a method.
 *     This lets the compiler catch typos and incorrect signatures.
 *   - Override methods should be 'public' if the parent declares them public.
 */
public class Car extends Vehicle {

	/**
	 * Overrides Vehicle.start()
	 * Car-specific startup behaviour: petrol ignition.
	 *
	 * RUNTIME POLYMORPHISM in action:
	 *   When called via a Vehicle reference (Vehicle v = new Car()),
	 *   the JVM looks at the actual object type (Car) at runtime
	 *   and dispatches THIS method — not Vehicle's abstract placeholder.
	 */
	@Override
	public void start() {
		System.out.println("Car started with petrol ignition.");
	}

	/**
	 * Overrides Vehicle.fuelType()
	 * Car runs on Petrol — declared explicitly to satisfy the abstract contract.
	 */
	@Override
	public void fuelType() {
		System.out.println("Fuel: Petrol");
	}

}
