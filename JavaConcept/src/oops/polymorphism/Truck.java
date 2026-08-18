package oops.polymorphism;

/**
 * Truck - Concrete Subclass of Vehicle
 *
 * PURPOSE:
 *   Represents a heavy-duty diesel-powered truck.
 *   Completes the set of Vehicle subclasses used in the polymorphism demo.
 *
 * NOTE on IS-A relationship:
 *   A Truck IS-A Vehicle → it can be stored in a Vehicle[] array.
 *   When the loop calls v.start() on a Truck element,
 *   the JVM dispatches Truck's version of start() at RUNTIME.
 *
 * BEST PRACTICE:
 *   - Consistent spacing after 'extends ClassName {' — leave a space before '{'
 *   - Keep method body indentation uniform (use tabs, not spaces).
 */
public class Truck extends Vehicle {

	/**
	 * Overrides Vehicle.start()
	 * Trucks use heavy diesel engines that produce a distinct loud start.
	 */
	@Override
	public void start() {
		System.out.println("Truck started with diesel engine.");
	}

	/**
	 * Overrides Vehicle.fuelType()
	 * Trucks are powered by diesel — heavier fuel for heavier loads.
	 */
	@Override
	public void fuelType() {
		System.out.println("Fuel: Diesel");
	}

}
