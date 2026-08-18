package oops.abstraction;

/**
 * UPIPayment - Concrete Subclass of PaymentGateway
 *
 * PURPOSE:
 *   Represents a UPI-based payment method (e.g., PhonePe).
 *   Provides concrete implementation of the abstract methods declared
 *   in PaymentGateway, making abstraction complete for this type.
 *
 * ABSTRACTION in action:
 *   The caller only interacts via PaymentGateway reference:
 *       PaymentGateway pg = new UPIPayment();
 *       pg.processPayment(500); // Caller doesn't know it's UPI internally
 *
 * NOTE on Constructor:
 *   UPIPayment has NO parameter in its constructor — the bank name
 *   "UPI - PhonePe" is hardcoded and passed up to PaymentGateway via super().
 *   This encapsulates the provider name within the class.
 */
public class UPIPayment extends PaymentGateway {

	/**
	 * Constructor: Initializes this payment gateway as "UPI - PhonePe".
	 * Calls super(bankName) to set the inherited 'bankName' field
	 * in the PaymentGateway abstract class.
	 */
	public UPIPayment() {
		super("UPI - PhonePe"); // Passes provider name to the abstract parent
	}

	/**
	 * Overrides PaymentGateway.processPayment()
	 * UPI-specific: payment is sent directly to the recipient's UPI ID.
	 * Uses string concatenation (+ amount +) to embed the actual amount value.
	 *
	 * @param amount the payment amount in ₹
	 */
	@Override
	public void processPayment(double amount) {
		System.out.println("UPI Payment of ₹" + amount + " sent via PhonePe");
	}

	/**
	 * Overrides PaymentGateway.refund()
	 * UPI refunds are instant and go back to the sender's UPI ID.
	 *
	 * @param amount the refund amount in ₹
	 */
	@Override
	public void refund(double amount) {
		System.out.println("UPI Refund of ₹" + amount + " initiated to your UPI ID");
	}

}
