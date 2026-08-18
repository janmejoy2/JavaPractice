package oops.inheritance;

/**
 * EngineImpl Interface demonstrates OOP Abstraction / Contract:
 * 1. Interface: Defines a contract of abstract methods that implementing classes must fulfill.
 * 2. Abstraction: Hides implementation details and specifies "what" needs to be done, not "how".
 * 3. All methods in an interface are implicitly 'public abstract'.
 */
public interface EngineImpl {
	
	/**
	 * Abstract method specification for a 2-cylinder engine.
	 * @return Engine description
	 */
	public String engineTypeV2();

	/**
	 * Abstract method specification for a 4-cylinder engine.
	 * @return Engine description
	 */
	public String engineTypeV4();

	/**
	 * Abstract method specification for an 8-cylinder engine.
	 * @return Engine description
	 */
	public String engineTypeV8();
}

