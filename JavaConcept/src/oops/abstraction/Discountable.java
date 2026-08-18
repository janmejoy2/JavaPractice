package oops.abstraction;

/**
 * Discountable - Interface (100% Abstraction)
 *
 * WHAT IS AN INTERFACE?
 *   An interface is a PURE CONTRACT — it only declares WHAT must be done,
 *   with zero implementation details. Every method is implicitly:
 *     - public
 *     - abstract
 *   Interfaces represent 100% abstraction in Java.
 *
 * WHY USE AN INTERFACE HERE (not abstract class)?
 *   - Not every PaymentGateway supports discounts (UPI, Card don't).
 *   - Only FestivePayment needs discount capability.
 *   - Interface lets us add this capability selectively via 'implements'.
 *   - Java does NOT allow multiple class inheritance, but a class CAN
 *     implement multiple interfaces — so interfaces enable flexible design.
 *
 * USAGE:
 *   Discountable d = new FestivePayment(); // Interface reference — valid!
 *   d.applyDiscount(1500, 20);             // Only Discountable methods visible
 */
public interface Discountable {

	/**
	 * Contract method: Calculate and return the price after applying discount.
	 * Formula: amount - (amount * discountPercent / 100)
	 *
	 * @param amount          the original price in ₹
	 * @param discountPercent the discount to apply (e.g., 20 for 20%)
	 * @return the final discounted amount
	 */
	public double applyDiscount(double amount, double discountPercent);

	/**
	 * Contract method: Display the current discount offer details.
	 * Each implementing class decides how to present the discount info.
	 */
	public void showDiscountDetails();

}
