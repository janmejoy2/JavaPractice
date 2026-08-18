package oops.encapulation;

/**
 * EncapulationDemo - Main class to demonstrate Encapsulation in Java.
 *
 * TWO CLASSES demonstrated:
 *   1. BankAccount → Encapsulation with business logic protection
 *   2. Employee    → Encapsulation with setter validation (gatekeeper pattern)
 */
public class EncapulationDemo {

	public static void main(String[] args) {

		// =====================================================================
		// PART 1: BankAccount — Encapsulation with business logic
		// =====================================================================
		System.out.println("=========================================");
		System.out.println("  BankAccount Encapsulation Demo");
		System.out.println("=========================================\n");

		/*
		 * Fields are private — we CANNOT do this from outside:
		 *   account.balance = 99999;  // ❌ Compile Error — private field
		 *   account.pin = 0000;       // ❌ Compile Error — private field
		 *
		 * We MUST go through the constructor and controlled methods.
		 */
		BankAccount account = new BankAccount("Janmejoy", "OKI90890", 90000, 5153);
		System.out.println("Account Holder : " + account.getAccountHolder());
		System.out.println("Account Number : " + account.getAccountNumber());
		System.out.println("Opening Balance: ₹" + account.getBalance());
		System.out.println();

		// Valid deposit — balance should increase
		System.out.println("-- Depositing ₹5000 --");
		account.deposit(5000);

		// Invalid deposit — negative amount rejected by encapsulated validation
		System.out.println("\n-- Depositing ₹-1000 (invalid) --");
		account.deposit(-1000);

		// Withdraw with WRONG PIN — encapsulation blocks the action
		System.out.println("\n-- Withdrawing ₹2000 with WRONG PIN (9999) --");
		account.withdraw(2000, 9999);

		// Withdraw with CORRECT PIN — succeeds and balance is updated
		System.out.println("\n-- Withdrawing ₹2000 with CORRECT PIN (5153) --");
		account.withdraw(2000, 5153);

		// Withdraw more than available balance — rejected by encapsulated rule
		System.out.println("\n-- Withdrawing ₹99999 (exceeds balance) --");
		account.withdraw(99999, 5153);

		// Change PIN with wrong old PIN — rejected
		System.out.println("\n-- Changing PIN with wrong old PIN --");
		account.changePin(0000, 1234);

		// Change PIN with correct old PIN — succeeds
		System.out.println("\n-- Changing PIN with correct old PIN --");
		account.changePin(5153, 9876);

		// =====================================================================
		// PART 2: Employee — Encapsulation with setter validation
		// =====================================================================
		System.out.println("\n=========================================");
		System.out.println("  Employee Encapsulation Demo");
		System.out.println("=========================================\n");

		// Valid employee — all values pass validation inside setters via constructor
		Employee emp = new Employee("Janmejoy", 25, 75000.0, "Engineering");
		System.out.println("Name       : " + emp.getName());
		System.out.println("Age        : " + emp.getAge());
		System.out.println("Salary     : ₹" + emp.getSalary());
		System.out.println("Department : " + emp.getDepartment());

		// Try setting an invalid age — setter's gatekeeper rejects it, field stays unchanged
		System.out.println("\n-- Setting invalid age (15) --");
		emp.setAge(15); // Rejected: < 18
		System.out.println("Age after invalid set: " + emp.getAge()); // Should still be 25

		// Try setting a negative salary — setter rejects it
		System.out.println("\n-- Setting negative salary (-5000) --");
		emp.setSalary(-5000); // Rejected: < 0
		System.out.println("Salary after invalid set: ₹" + emp.getSalary()); // Should still be 75000.0

		// Try setting an empty department — setter rejects it
		System.out.println("\n-- Setting empty department --");
		emp.setDepartment(""); // Rejected: blank
		System.out.println("Department after invalid set: " + emp.getDepartment()); // Should still be Engineering
	}

}
