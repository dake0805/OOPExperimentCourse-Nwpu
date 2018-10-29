import java.io.*;

/**
 * Test driver class IndividualCustomer.
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see IndividualCustomer
 */
public class TestIndividualCustomer {

	/* Standard output stream */
	private static PrintWriter stdOut = new PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	/**
	 * Displays a message in the standard error stream if the value specified by
	 * parameter condition is false.
	 * 
	 * @param message
	 *            the error message.
	 * @param condition
	 *            the test condition.
	 */
	public static void assertTrue(String message, boolean condition) {
		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);
		}
	}

	/**
	 * Displays a message in the standard error stream.
	 * 
	 * @param message
	 *            the error message.
	 */
	public static void fail(String message) {
		stdErr.print("** Test failure ");
		stdErr.println(message);
		System.exit(0);
	}

	/**
	 * Test driver for class IndividualCustomer.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {

		stdOut.println("");
		stdOut.println("Testing class IndividualCustomer...");

		String name = "machunyan";
		String homeTelephone = "88493779-8419";
		String email = "machunyan@nwpu.edu.cn";

		String customerId = "A1";
		Person person = new Person(name, homeTelephone, email);
		IndividualCustomer individualCustomer = new IndividualCustomer(
				customerId, person);

		// Test class definition
		assertTrue("1: Testing class definition",
				individualCustomer instanceof Customer);

		// Test method getCustomerId
		assertTrue("2: Testing method getCustomerId", individualCustomer
				.getCustomerId().equals(customerId));

		// Test method getPerson
		assertTrue("3: Testing method getPerson", individualCustomer
				.getPerson().equals(person));

		stdOut.println("done");
	}
}
