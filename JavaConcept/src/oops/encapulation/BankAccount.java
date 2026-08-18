package oops.encapulation;

/**
 * BankAccount - Demonstrates Encapsulation in Java.
 *
 * WHAT IS ENCAPSULATION?
 *   Encapsulation = bundling FIELDS (data) + METHODS (behavior) into one class,
 *   and RESTRICTING direct access to fields using access modifiers.
 *   The outside world interacts with the data ONLY through controlled methods.
 *
 * HOW IT'S ACHIEVED HERE:
 *   - All fields are 'private' → no direct access from outside this class
 *   - Public getters  → allow READ access in a controlled way
 *   - NO setter for 'accountNumber' → it is IMMUTABLE after creation
 *   - NO setter for 'balance'       → balance only changes via deposit/withdraw
 *   - NO setter for 'pin'           → pin only changes via changePin() with validation
 *   - Business methods (deposit, withdraw, changePin) → protect data with rules
 *
 * REAL-WORLD ANALOGY:
 *   A bank ATM is a perfect encapsulation example.
 *   You cannot directly touch the cash inside — you go through the machine's
 *   controlled interface (PIN → withdraw), which enforces all the rules.
 */
public class BankAccount {

	// =========================================================================
	// PRIVATE FIELDS — The data is hidden from the outside world
	// =========================================================================

	private String accountHolder; // Name of the account owner
	private String accountNumber; // Unique account ID — IMMUTABLE (no setter)
	private double balance;       // Current balance — ONLY changed via deposit/withdraw
	private int pin;              // Security PIN — ONLY changed via changePin()

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Constructor: Initializes all fields at the time of account creation.
	 * Direct assignment here is safe because this is the object's own constructor.
	 *
	 * @param accountHolder  name of the account holder
	 * @param accountNumber  unique account number (immutable after this)
	 * @param initialBalance opening balance (should be >= 0)
	 * @param pin            4-digit security PIN
	 */
	public BankAccount(String accountHolder, String accountNumber, double initialBalance, int pin) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
		this.pin = pin;
	}

	// =========================================================================
	// GETTERS — Controlled READ access (no direct field exposure)
	// =========================================================================

	/**
	 * @return the account holder's name
	 */
	public String getAccountHolder() {
		return accountHolder;
	}

	/**
	 * Setter for accountHolder — name CAN be updated (e.g., after marriage).
	 * @param accountHolder new name of the account holder
	 */
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * @return the account number
	 * NO SETTER — accountNumber is immutable once the account is created.
	 *             Allowing it to change would break banking integrity.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the current account balance
	 * NO SETTER — balance must only change through deposit() or withdraw().
	 *             A direct setter would bypass all business validation rules.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * NOTE: Exposing the PIN via a getter is a security anti-pattern in real systems.
	 * Included here only for learning purposes to show the field exists.
	 * In production, PINs are hashed and never returned in plain text.
	 *
	 * @return the PIN (for demo purposes only)
	 */
	public int getPin() {
		return pin;
	}

	// =========================================================================
	// BUSINESS METHODS — Encapsulated logic that protects the data
	// =========================================================================

	/**
	 * Deposits money into the account after validating the amount.
	 *
	 * BUG FIXED: Original code printed (this.balance + amount) but did NOT
	 *            update the balance field — the actual balance never changed!
	 *            Fix: this.balance += amount; to actually update the field.
	 *
	 * @param amount the amount to deposit (must be > 0)
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount; // ✅ Actually update the balance field
			System.out.println("₹" + amount + " deposited successfully. New balance: ₹" + this.balance);
		} else {
			// Encapsulation enforces this rule — outside code cannot bypass it
			System.out.println("Invalid deposit amount. Amount must be greater than 0.");
		}
	}

	/**
	 * Withdraws money from the account after validating PIN and sufficient balance.
	 *
	 * BUG FIXED #1: Original only checked PIN but never checked if balance was sufficient.
	 * BUG FIXED #2: Original returned true/false but never deducted the amount from balance.
	 *
	 * @param amount      the amount to withdraw (must be > 0 and <= balance)
	 * @param enteredPin  the PIN entered by the user for verification
	 * @return true if withdrawal was successful, false otherwise
	 */
	public boolean withdraw(double amount, int enteredPin) {
		// Step 1: Validate PIN first — authentication before action
		if (enteredPin != this.pin) {
			System.out.println("Withdrawal failed: Incorrect PIN.");
			return false;
		}

		// Step 2: Check if sufficient balance is available
		if (amount > this.balance) {
			System.out.println("Withdrawal failed: Insufficient balance. Available: ₹" + this.balance);
			return false;
		}

		// Step 3: Both checks passed — safely deduct the amount
		this.balance -= amount; // ✅ Actually deduct from balance
		System.out.println("₹" + amount + " withdrawn successfully. Remaining balance: ₹" + this.balance);
		return true;
	}

	/**
	 * Changes the account PIN after validating the old PIN.
	 *
	 * BUG FIXED: Original compared oldPin == newPin (wrong logic!).
	 *            The correct check is oldPin == this.pin (validate against the stored PIN).
	 *            If old PIN matches → update this.pin to newPin.
	 *
	 * @param oldPin the current PIN (must match stored PIN)
	 * @param newPin the new PIN to set
	 */
	public void changePin(int oldPin, int newPin) {
		// Validate that the provided old PIN matches the stored PIN
		if (oldPin == this.pin) {
			this.pin = newPin; // ✅ Update the stored PIN
			System.out.println("PIN changed successfully.");
		} else {
			System.out.println("PIN change failed: Incorrect old PIN.");
		}
	}

}
