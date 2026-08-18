package oops.abstraction;

/**
 * AbstractionDemo - Main entry point to demonstrate Abstraction in Java.
 *
 * TWO TYPES OF ABSTRACTION demonstrated here:
 * ┌──────────────────────┬─────────────────────────────────────────────────┐
 * │ Type                 │ How                                             │
 * ├──────────────────────┼─────────────────────────────────────────────────┤
 * │ Abstract Class       │ PaymentGateway[] array — partial abstraction    │
 * │ Interface            │ Discountable reference — 100% abstraction       │
 * └──────────────────────┴─────────────────────────────────────────────────┘
 */
public class AbstractionDemo {

	public static void main(String[] args) {

		// =====================================================================
		// PART 1: Abstract Class — PaymentGateway[] array (Upcasting)
		// =====================================================================
		System.out.println("=========================================");
		System.out.println("  ABSTRACTION via Abstract Class");
		System.out.println("=========================================\n");

		/*
		 * UPCASTING with Abstract Class:
		 *   PaymentGateway is abstract — cannot be instantiated directly.
		 *   But we CAN use it as a reference type to hold concrete subclass objects.
		 *
		 *   PaymentGateway pg = new UPIPayment();    // ✅ Valid — Upcasting
		 *   PaymentGateway pg = new PaymentGateway(); // ❌ Compile Error — abstract
		 *
		 * The array stores all three payment types uniformly via the abstract type.
		 * The caller (this loop) doesn't know or care which gateway is which —
		 * that's abstraction hiding the implementation details.
		 */
		PaymentGateway[] gateways = {
			new UPIPayment(),      // Upcast: PaymentGateway ref → UPIPayment object
			new CardPayment(),     // Upcast: PaymentGateway ref → CardPayment object
			new FestivePayment()   // Upcast: PaymentGateway ref → FestivePayment object
		};

		/*
		 * Loop through all gateways UNIFORMLY using the abstract type reference.
		 * The JVM resolves the correct processPayment() / refund() at RUNTIME
		 * based on the actual object type — this is Runtime Polymorphism working
		 * hand-in-hand with Abstraction.
		 */
		for (PaymentGateway pg : gateways) {
			System.out.println("--- " + pg.getClass().getSimpleName() + " ---");
			pg.processPayment(1500.0); // Calls the overridden version of the actual object
			pg.printReceipt(1500.0);   // Concrete method — same for all, defined in parent
			pg.refund(500.0);          // Calls the overridden refund() of the actual object
			System.out.println();
		}

		// =====================================================================
		// PART 2: Interface — Discountable reference (100% Abstraction)
		// =====================================================================
		System.out.println("=========================================");
		System.out.println("  ABSTRACTION via Interface (Discountable)");
		System.out.println("=========================================\n");

		/*
		 * INTERFACE REFERENCE:
		 *   Discountable d = new FestivePayment();
		 *
		 *   Through 'd', ONLY the methods declared in Discountable are accessible.
		 *   processPayment(), refund(), printReceipt() are HIDDEN — even though
		 *   FestivePayment has them. This is pure abstraction — the interface
		 *   exposes only what it contracts.
		 *
		 * This is useful when you want to pass FestivePayment to a method
		 * that only cares about discount behavior, not payment behavior.
		 */
		Discountable d = new FestivePayment(); // Interface reference — only Discountable methods visible

		// Show the active discount offer
		d.showDiscountDetails();

		// Apply 20% discount on ₹1500 — formula: 1500 - (1500 * 20 / 100) = ₹1200.0
		double discountedPrice = d.applyDiscount(1500.0, 20);
		System.out.println("Original Price  : ₹1500.0");
		System.out.println("Discount Applied: 20%");
		System.out.println("Final Price     : ₹" + discountedPrice);
	}

}
