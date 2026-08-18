package oops.abstraction;

/**
 * FestivePayment - Concrete Subclass implementing BOTH abstract class + interface
 *
 * PURPOSE:
 *   Represents a festive-season payment gateway with bonus rewards and discounts.
 *   This class demonstrates the most advanced form of abstraction in Java:
 *
 *   1. Extends PaymentGateway   → Fulfills the abstract class contract
 *                                  (must implement processPayment + refund)
 *   2. Implements Discountable  → Fulfills the interface contract
 *                                  (must implement applyDiscount + showDiscountDetails)
 *
 * JAVA RULE — Order of extends vs implements:
 *   Always: class X extends Y implements Z   ✅
 *   NOT:    class X implements Z extends Y   ❌ (Compile Error)
 *
 * DUAL REFERENCE capability:
 *   PaymentGateway pg = new FestivePayment(); // Abstract class reference
 *   Discountable   d  = new FestivePayment(); // Interface reference
 *   Both are valid — FestivePayment IS-A PaymentGateway AND IS-A Discountable.
 */
public class FestivePayment extends PaymentGateway implements Discountable {

	/**
	 * Constructor: Initializes this gateway as "Festive Pay".
	 * No-argument constructor — bank name is fixed for festive payments.
	 * Calls super() to pass the name up to PaymentGateway.
	 */
	public FestivePayment() {
		super("Festive Pay"); // Sets the inherited bankName field
	}

	// =========================================================================
	// Methods from PaymentGateway (Abstract Class Contract)
	// =========================================================================

	/**
	 * Overrides PaymentGateway.processPayment()
	 * Festive payments come with bonus reward points — a value-add over regular gateways.
	 *
	 * @param amount the payment amount in ₹
	 */
	@Override
	public void processPayment(double amount) {
		System.out.println("Festive Payment of ₹" + amount + " processed with bonus rewards!");
	}

	/**
	 * Overrides PaymentGateway.refund()
	 * Festive refunds are returned as reward points, not cash — platform-specific behavior.
	 *
	 * @param amount the refund amount in ₹
	 */
	@Override
	public void refund(double amount) {
		System.out.println("Festive Refund of ₹" + amount + " credited as reward points");
	}

	// =========================================================================
	// Methods from Discountable (Interface Contract)
	// =========================================================================

	/**
	 * Implements Discountable.applyDiscount()
	 * Calculates the final price after applying the given discount percentage.
	 *
	 * Formula: discountedPrice = amount - (amount * discountPercent / 100)
	 * Example: applyDiscount(1500, 20) → 1500 - (1500 * 20 / 100) = 1500 - 300 = 1200.0
	 *
	 * @param amount          original price in ₹
	 * @param discountPercent discount to apply (e.g., 20 for 20%)
	 * @return the discounted final amount
	 */
	@Override
	public double applyDiscount(double amount, double discountPercent) {
		return amount - (amount * discountPercent / 100); // Standard discount formula
	}

	/**
	 * Implements Discountable.showDiscountDetails()
	 * Prints the active festive discount offer details.
	 */
	@Override
	public void showDiscountDetails() {
		System.out.println("Festive discount active: Up to 20% off on all payments!");
	}

}
