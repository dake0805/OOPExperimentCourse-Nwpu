import java.io.*;
import java.util.*;

/**
 * Test driver for class CustomerInformationSystem.
 * 
 * @author ³ÂãùÎÄ
 * @version 1.0.0
 * @see CustomerInformationSystem
 */
public class TestCustomerInformationSystem {

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
	 * Test driver for class CustomerInformationSystem.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {

		stdOut.println("");
		stdOut.println("Testing class CustomerInformationSystem...");

		String nameOne = "machunyan";
		String homeTelephoneOne = "88493779-8419";
		String emailOne = "machunyan@nwpu.edu.cn";

		String customerIdOne = "A1";
		Person person = new Person(nameOne, homeTelephoneOne, emailOne);
		IndividualCustomer individualCustomer = new IndividualCustomer(
				customerIdOne, person);

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

		String customerIdTwo = "B1";
		InstitutionalCustomer institutionalCustomer = new InstitutionalCustomer(
				customerIdTwo, contacts);

		CustomerInformationSystem customerInfo = new CustomerInformationSystem();

		// Test method addCustomer
		assertTrue("1: Testing method addCustomer",
				customerInfo.getCustomer(customerIdOne) == null);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(individualCustomer);
		customers.add(institutionalCustomer);
		for (Customer tempCustomer : customers) {
			customerInfo.addCustomer(tempCustomer);
		}
		assertTrue("2: Testing method addCustomer",
				customerInfo.getCustomer(customerIdOne) != null);

		// Test method getCustomer
		assertTrue(
				"3: Testing method getCustomer",
				customerInfo.getCustomer(customerIdOne).equals(
						individualCustomer));
		assertTrue(
				"4: Testing method getCustomer",
				customerInfo.getCustomer(customerIdTwo).equals(
						institutionalCustomer));

		// Test method addContact
		Contact contactExtra = new Contact("nameExtra", "homeTelephoneExtra",
				"emailExtra", "workTelephoneExtra", "jobPositionExtra");
		assertTrue("5: Testing method addContact",
				customerInfo.addContact(customerIdTwo, contactExtra));
		InstitutionalCustomer temp = new InstitutionalCustomer();
		temp = (InstitutionalCustomer) customerInfo.getCustomer(customerIdTwo);
		System.out.println(temp.getContact("nameExtra").toString());
		assertTrue("6: Testing method addContact",
				!customerInfo.addContact("B2", contactExtra));

		stdOut.println("done");
	}
}
