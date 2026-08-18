package oops.polymorphism;

/**
 * ElectricCar - Concrete Subclass of Vehicle
 *
 * PURPOSE:
 *   Represents a battery-powered electric vehicle.
 *   Overrides abstract methods from Vehicle with EV-specific behavior.
 *
 * KEY POINT — Polymorphism flexibility:
 *   Even though ElectricCar is very different from a Car (no combustion engine),
 *   both share the same Vehicle contract. This means they can be treated
 *   UNIFORMLY through a Vehicle reference, while behaving DIFFERENTLY.
 *   That is the power of Runtime Polymorphism.
 *
 * BEST PRACTICE:
 *   - Subclasses should override ALL abstract methods of the parent.
 *     Failing to do so makes the subclass abstract too (compile error).
 */
public class ElectricCar extends Vehicle {

	/**
	 * Overrides Vehicle.start()
	 * ElectricCar starts silently — no combustion, just battery power.
	 *
	 * This demonstrates DIFFERENT behavior for the same method name,
	 * resolved at runtime based on the actual object type.
	 */
	@Override
	public void start() {
		System.out.println("Electric Car started silently with battery power.");
	}

	/**
	 * Overrides Vehicle.fuelType()
	 * ElectricCar does not use traditional fuel — it runs on electric energy.
	 */
	@Override
	public void fuelType() {
		System.out.println("Fuel: Electric (Battery)");
	}

}
