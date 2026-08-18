package oops.abstraction;

/**
 * PaymentGateway - Abstract Class (Partial Abstraction)
 *
 * WHAT IS ABSTRACTION?
 *   Abstraction = hiding the HOW, exposing only the WHAT.
 *   The caller knows WHAT a payment gateway does (processPayment, refund),
 *   but doesn't need to know HOW each gateway does it internally.
 *
 * WHY ABSTRACT CLASS (not interface)?
 *   - We need a shared field: 'bankName' (interfaces cannot have instance fields)
 *   - We need a constructor to initialize 'bankName'
 *   - We have a concrete shared method: printReceipt() — same for all gateways
 *   - Abstract class = PARTIAL abstraction (mix of abstract + concrete)
 *
 * RULE:
 *   - Abstract class CANNOT be instantiated directly.
 *       new PaymentGateway(...) // ❌ Compile Error
 *   - Any subclass MUST implement all abstract methods, or itself be abstract.
 */
public abstract class PaymentGateway {

	/**
	 * Shared field: stores the name of the bank/payment provider.
	 * 'protected' — accessible by this class and all subclasses,
	 * but NOT from outside the package (encapsulation preserved).
	 */
	protected String bankName;

	/**
	 * Constructor: Abstract classes CAN have constructors.
	 * Called via super(bankName) from each subclass constructor.
	 * Ensures bankName is always initialized before use.
	 *
	 * @param bankName name of the payment provider (e.g., "UPI - PhonePe")
	 */
	public PaymentGateway(String bankName) {
		this.bankName = bankName; // 'this' distinguishes field from parameter
	}

	/**
	 * Abstract method: HOW payment is processed differs per gateway.
	 * Subclasses (UPIPayment, CardPayment, FestivePayment) MUST override this.
	 *
	 * @param amount the amount to be paid in ₹
	 */
	public abstract void processPayment(double amount);

	/**
	 * Abstract method: HOW refunds work differs per gateway.
	 * e.g., UPI refunds go to UPI ID, Card refunds take 5-7 business days.
	 *
	 * @param amount the amount to be refunded in ₹
	 */
	public abstract void refund(double amount);

	/**
	 * Concrete method: Receipt format is the SAME for all gateways.
	 * Defined once here — all subclasses INHERIT this without overriding.
	 * This avoids code duplication (DRY principle).
	 *
	 * @param amount the payment amount to print on the receipt
	 */
	public void printReceipt(double amount) {
		// Use + amount + and + bankName + to inject actual variable values into the string
		System.out.println("Receipt: Payment of ₹" + amount + " processed via " + bankName);
	}

	/**
	 * Concrete getter: Returns the bank/provider name.
	 * Useful when the caller only has a PaymentGateway reference
	 * and needs to identify which provider it is.
	 *
	 * @return bankName the payment provider name
	 */
	public String getBankName() {
		return bankName;
	}

}
