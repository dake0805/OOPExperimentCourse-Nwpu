import java.io.*;

/**
 * Test driver class Person.
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see Person
 */
public class TestPerson {

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
	 * Test driver for class Person.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		stdOut.println("");
		stdOut.println("Testing class Person...");

		String name = "machunyan";
		String homeTelephone = "88493779-8419";
		String email = "machunyan@nwpu.edu.cn";
		Person person = new Person(name, homeTelephone, email);

		// Test class definition
		assertTrue("1: Testing class definition", person instanceof Object);

		// Test the get methods
		assertTrue("2: Testing method getName", person.getName().equals(name));
		assertTrue("3: Testing method getHomeTelephone", person
				.getHomeTelephone().equals(homeTelephone));
		assertTrue("4: Testing method getEmail", person.getEmail()
				.equals(email));

		// Test method equals
		String nameOne = "name one";
		String homeTelephoneOne = "88888888";
		String emailOne = "one@nwpu.edu.cn";

		String nameTwo = "name two";
		String homeTelephoneTwo = "88490000";
		String emailTwo = "two@nwpu.edu.cn";

		Person personOne = new Person(nameOne, homeTelephoneOne, emailOne);
		Person personTwo = new Person(nameTwo, homeTelephoneTwo, emailTwo);
		Person personThree = new Person(nameOne, homeTelephoneTwo, emailTwo);

		assertTrue("5: Testing method equals", personOne.equals(personThree));
		assertTrue("6: Testing method equals", !personTwo.equals(personThree));
		assertTrue("7: Testing method equals", !personOne.equals(personTwo));

		try {
			assertTrue("8: Testing method equals",
					!personOne.equals(new Object()));
		} catch (ClassCastException cce) {
			fail("9: Testing method equals, " + cce.toString());
		}

		// Test method toString
		String result = name + "_" + homeTelephone + "_" + email;
		assertTrue("10: Testing method toString",
				person.toString().equals(result));

		stdOut.println("done");
	}
}
