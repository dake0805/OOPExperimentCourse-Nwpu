import java.io.*;

/**
 * Test driver for class Contact
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see Contact
 */
public class TestContact {

	/* Standard output stream */
	private static PrintWriter stdOut = new PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	/**
	 * Display a message in the standard error stream if the value specified by
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
	 * Display a message in the standard error stream.
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
	 * Test driver for class Contact.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {

		stdOut.println("");
		stdOut.println("Testing class Contact...");

		String name = "machunyan";
		String homeTelephone = "88493779-8419";
		String email = "machunyan@nwpu.edu.cn";
		String workTelephone = "88494221-8419";
		String jobPosition = "associate professor";
		Contact contact = new Contact(name, homeTelephone, email,
				workTelephone, jobPosition);

		// Test class definition
		assertTrue("1: Testing class definition", contact instanceof Person);

		// Test accessors
		assertTrue("2: Testing method getWorkTelephone", contact
				.getWorkTelephone().equals(workTelephone));
		assertTrue("3: Testing method getJobPosition", contact.getJobPosition()
				.equals(jobPosition));

		// Test method toString
		String result = name + "_" + homeTelephone + "_" + email + "_"
				+ workTelephone + "_" + jobPosition;
		assertTrue("4: Testing method toString",
				contact.toString().equals(result));

		stdOut.println("done");
	}
}
