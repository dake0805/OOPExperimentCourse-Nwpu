import java.io.*;
import java.lang.reflect.*;

/**
 * Test driver for interface Customer
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see Customer
 */
public class TestCustomer {

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
			System.exit(0);
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
	 * Test driver for interface Customer.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		stdOut.println("");
		stdOut.println("Testing interface Customer...");

		Class interfaceDescriptor = null;

		try {
			interfaceDescriptor = Class.forName("Customer");
		} catch (ClassNotFoundException cnfe) {
			fail("1: Interface Customer not found "
					+ "(check the name of the interface)");
		}

		assertTrue("2: Customer is not an Interface",
				interfaceDescriptor.isInterface());

		Method[] methods = interfaceDescriptor.getMethods();

		if (methods.length == 0) {
			fail("3: Customer contains no methods");
		}

		assertTrue("4: Customer should contain one methods",
				methods.length == 1);

		try {
			Method method = interfaceDescriptor.getMethod("getCustomerId",
					new Class[0]);
		} catch (NoSuchMethodException nsme) {
			fail("5: Method getCustomerId() not found "
					+ "(check the method signature)");
		}

		stdOut.println("done");
	}
}
