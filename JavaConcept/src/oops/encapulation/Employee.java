package oops.encapulation;

/**
 * Employee - Demonstrates Encapsulation with Input Validation in Setters.
 *
 * PURPOSE:
 *   Shows that encapsulation is not just about making fields private —
 *   it's about controlling WHAT values are allowed into those fields.
 *   Setters act as "gatekeepers" that reject bad data before it pollutes the object.
 *
 * KEY DESIGN DECISIONS:
 *   - All fields are 'private' — zero direct access from outside
 *   - Every setter VALIDATES before assigning — invalid data is rejected
 *   - Constructor calls setters (not direct assignment) so validation runs
 *     even at object creation time
 *
 * BEST PRACTICE — 'return' after printing error:
 *   After printing an invalid message, we 'return' to stop the assignment.
 *   Without return, the invalid value would still be set to the field!
 */
public class Employee {

	// =========================================================================
	// PRIVATE FIELDS
	// =========================================================================

	private String name;       // Employee's full name
	private int age;           // Age must be between 18 and 65
	private double salary;     // Salary must be non-negative
	private String department; // Department name must not be empty

	// =========================================================================
	// CONSTRUCTOR — Uses setters to enforce validation from the start
	// =========================================================================

	/**
	 * Constructor: Delegates field assignment to setters (not direct assignment).
	 * This ensures all validation rules run even at object construction time.
	 *
	 * BEST PRACTICE: If a setter has validation, the constructor should call
	 * the setter — not assign directly — to avoid duplicating validation logic.
	 *
	 * @param name       employee's name (non-null, non-empty)
	 * @param age        employee's age (18–65)
	 * @param salary     employee's salary (>= 0)
	 * @param department employee's department (non-null, non-empty)
	 */
	public Employee(String name, int age, double salary, String department) {
		setName(name);           // Runs name validation
		setAge(age);             // Runs age validation
		setSalary(salary);       // Runs salary validation
		setDepartment(department); // Runs department validation
	}

	// =========================================================================
	// GETTERS — Read-only access to private fields
	// =========================================================================

	/** @return the employee's name */
	public String getName() {
		return name;
	}

	/** @return the employee's age */
	public int getAge() {
		return age;
	}

	/** @return the employee's salary */
	public double getSalary() {
		return salary;
	}

	/** @return the employee's department */
	public String getDepartment() {
		return department;
	}

	// =========================================================================
	// SETTERS WITH VALIDATION — The "gatekeepers" of the data
	// =========================================================================

	/**
	 * Sets the employee name after validating it is not null or blank.
	 *
	 * BEST PRACTICE: Use 'return' after printing the error to stop assignment.
	 * Without return, this.name = name would still execute with bad data!
	 *
	 * @param name the name to set (must not be null or empty)
	 */
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			System.out.println("Invalid Name: Name cannot be null or empty.");
			return; // ✅ Stop here — do NOT assign the invalid value
		}
		this.name = name;
	}

	/**
	 * Sets the employee age after validating it is within the working age range.
	 *
	 * BUG FIXED: Original code had no 'return' — it printed "Invalid Age"
	 *            but then still assigned the invalid age to this.age!
	 *
	 * @param age the age to set (must be 18 <= age <= 65)
	 */
	public void setAge(int age) {
		if (age < 18 || age > 65) {
			System.out.println("Invalid Age: Age must be between 18 and 65.");
			return; // ✅ Stop here — do NOT assign the out-of-range value
		}
		this.age = age;
	}

	/**
	 * Sets the salary after validating it is non-negative.
	 *
	 * BUG FIXED: Original code had no 'return' — it printed "Invalid Salary"
	 *            but then still assigned the negative salary to this.salary!
	 *
	 * @param salary the salary to set (must be >= 0)
	 */
	public void setSalary(double salary) {
		if (salary < 0) {
			System.out.println("Invalid Salary: Salary cannot be negative.");
			return; // ✅ Stop here — do NOT assign the negative value
		}
		this.salary = salary;
	}

	/**
	 * Sets the department after validating it is not null or blank.
	 *
	 * BUG FIXED: Original code checked 'name' instead of 'department'!
	 *            The condition was:  if (name == null || name.isBlank())
	 *            It should be:      if (department == null || department.isBlank())
	 *
	 * @param department the department name to set (must not be null or empty)
	 */
	public void setDepartment(String department) {
		if (department == null || department.isBlank()) { // ✅ Fixed: was checking 'name' by mistake
			System.out.println("Invalid Department: Department cannot be null or empty.");
			return; // Stop here — do NOT assign the invalid value
		}
		this.department = department;
	}

}
