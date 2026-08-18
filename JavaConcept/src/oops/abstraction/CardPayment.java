package oops.abstraction;

/**
 * CardPayment - Concrete Subclass of PaymentGateway
 *
 * PURPOSE:
 *   Represents a Credit/Debit card payment method.
 *   Provides the card-specific implementation of abstract methods
 *   from PaymentGateway.
 *
 * KEY DIFFERENCE from UPIPayment:
 *   - Card payments charge a physical card ending in a specific number.
 *   - Card refunds take 5-7 business days (bank processing time),
 *     unlike UPI which is instant.
 *   This shows how abstraction hides these differences from the caller.
 *
 * BEST PRACTICE:
 *   - Remove auto-generated TODO comments once a constructor body is complete.
 *   - Keep the constructor minimal — only call super() if no extra setup needed.
 */
public class CardPayment extends PaymentGateway {

	/**
	 * Constructor: Initializes this gateway as "Credit/Debit Card".
	 * Delegates bankName initialization to PaymentGateway via super().
	 */
	public CardPayment() {
		super("Credit/Debit Card"); // Passes provider name to abstract parent
	}

	/**
	 * Overrides PaymentGateway.processPayment()
	 * Card-specific: the amount is charged to the card ending in ****1234.
	 * The masked card number (****1234) simulates real-world security practice.
	 *
	 * @param amount the payment amount in ₹
	 */
	@Override
	public void processPayment(double amount) {
		System.out.println("Card Payment of ₹" + amount + " charged to your card ending ****1234");
	}

	/**
	 * Overrides PaymentGateway.refund()
	 * Card refunds are NOT instant — they go through the bank's processing pipeline.
	 *
	 * @param amount the refund amount in ₹
	 */
	@Override
	public void refund(double amount) {
		System.out.println("Card Refund of ₹" + amount + " will reflect in 5-7 business days");
	}

}
