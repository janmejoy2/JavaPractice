package oops.inheritance;

/**
 * Superclass (Parent Class):
 * Defines standard engine types that any child class (vehicle) can inherit and reuse.
 */
public class Engine {

	public String engineTypeV2() {
		return "V2 Engine: Can be used in Two Wheelers only";
	}

	public String engineTypeV4() {
		return "Standard V4 Engine: Can be used in Four Wheelers for standard Mileage";
	}

	public String engineTypeV8() {
		return "High Performance V8 Engine: Can be used in Sports / Performance cars";
	}

}


