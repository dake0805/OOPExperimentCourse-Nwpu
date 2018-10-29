import java.io.*;
import java.util.*;

/**
 * Test driver class InstitutionalCustomer.
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see InstitutionalCustomer
 */
public class TestInstitutionalCustomer {

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
	 * Test driver for class InstitutionalCustomer.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {

		stdOut.println("");
		stdOut.println("Testing class InstitutionalCustomer...");

		String customerId = "B0";
		InstitutionalCustomer institutionalCustomer = new InstitutionalCustomer(
				customerId, null);

		String[] name = { "name one", "name two", "name three", "name four",
				"name five" };
		String[] homeTelephone = { "88493779-1", "88493779-2", "88493779-3",
				"88493779-4", "88493779-5" };
		String[] email = { "one@nwpu.edu.cn", "two@nwpu.edu.cn",
				"three@nwpu.edu.cn", "four@nwpu.edu.cn", "five@nwpu.edu.cn" };
		String[] workTelephone = { "88494433-1", "88494433-2", "88494433-3",
				"88494433-4", "88494433-5" };
		String[] jobPosition = { "academician", "professor",
				"associate professor", "lecturer", "assistant" };

		Contact[] contact = {
				new Contact(name[0], homeTelephone[0], email[0],
						workTelephone[0], jobPosition[0]),
				new Contact(name[1], homeTelephone[1], email[1],
						workTelephone[1], jobPosition[1]),
				new Contact(name[2], homeTelephone[2], email[2],
						workTelephone[2], jobPosition[2]),
				new Contact(name[3], homeTelephone[3], email[3],
						workTelephone[3], jobPosition[3]),
				new Contact(name[4], homeTelephone[4], email[4],
						workTelephone[4], jobPosition[4]) };

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		contacts.add(contact[0]);
		contacts.add(contact[1]);
		contacts.add(contact[2]);
		contacts.add(contact[3]);
		contacts.add(contact[4]);

		InstitutionalCustomer institutionalCustomerFull = new InstitutionalCustomer(
				"B1", contacts);
		InstitutionalCustomer institutionalCustomerExtra = new InstitutionalCustomer(
				"B2", contacts);

		// Test class definition
		assertTrue("1: Testing class definition",
				institutionalCustomer instanceof Customer);

		// Test method iterator
		InstitutionalCustomer institutionalCustomerIterator = new InstitutionalCustomer(
				"B4", contacts);
		Iterator<Contact> iterator = institutionalCustomerIterator.iterator();
		for (Contact tempContact : contact) {
			if (iterator.hasNext()) {
				assertTrue("2: Testing method iterator",
						iterator.next() == tempContact);
			} else {
				fail("3: Testing method iterator");
			}
		}

		// Test method getCustomerId
		assertTrue("4: Testing method getCustomerId", institutionalCustomer
				.getCustomerId().equals(customerId));

		// Test method getContact
		assertTrue("5: Testing method getContact", institutionalCustomerFull
				.getContact(name[0]).equals(contact[0]));

		// Test method addContact
		Contact contactExtra = new Contact("nameExtra", "homeTelephoneExtra",
				"emailExtra", "workTelephoneExtra", "jobPositionExtra");
		institutionalCustomerExtra.addContact(contactExtra);
		assertTrue("6: Testing method addContact", institutionalCustomerExtra
				.getContact("nameExtra").equals(contactExtra));

		stdOut.println("done");
	}
}
