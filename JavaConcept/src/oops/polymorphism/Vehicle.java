package oops.polymorphism;

/**
 * Vehicle - Abstract Base Class (Superclass)
 *
 * PURPOSE:
 *   Acts as a blueprint/contract for all vehicle types.
 *   Defines WHAT every vehicle must do (start, fuelType, stop)
 *   but leaves HOW to the subclasses — this is Abstraction.
 *
 * BEST PRACTICE:
 *   - Abstract classes CAN have both abstract and concrete methods.
 *   - Use 'abstract' when subclasses MUST provide their own implementation.
 *   - Use concrete methods (non-abstract) for shared default behavior.
 *   - Abstract classes cannot be instantiated directly:
 *       Vehicle v = new Vehicle(); // ❌ Compile Error
 *       Vehicle v = new Car();     // ✅ Valid (Upcasting)
 */
public abstract class Vehicle {

	/**
	 * Abstract method: Each vehicle starts differently.
	 * Subclasses (Car, ElectricCar, Truck) MUST override this.
	 * This is the foundation of RUNTIME POLYMORPHISM.
	 */
	public abstract void start();

	/**
	 * Abstract method: Each vehicle uses a different fuel.
	 * Forces every subclass to declare its own fuel type explicitly.
	 */
	public abstract void fuelType();

	/**
	 * Concrete method: Shared behavior for ALL vehicles.
	 * Since stopping is the same for every vehicle, it is defined here once.
	 * Subclasses INHERIT this automatically — no need to override.
	 *
	 * BEST PRACTICE: Define common, reusable behavior in the parent class
	 *                to avoid code duplication (DRY principle).
	 */
	public void stop() {
		System.out.println("Vehicle stopped.");
	}

}
