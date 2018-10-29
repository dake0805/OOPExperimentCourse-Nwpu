import java.util.ArrayList;
import java.util.Iterator;

/**
 * definition of class InstitutionalCustomer
 *
 * @author hzy
 */
public class InstitutionalCustomer implements Customer, Iterable<Contact> {
    private String customerId;
    ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * constructor
     *
     * @param customerId
     * @param contacts
     */
    public InstitutionalCustomer(String customerId, ArrayList<Contact> contacts) {
        this.customerId = customerId;
        this.contacts = contacts;
    }

    /**
     * constructor without parameter
     */
    public InstitutionalCustomer() {

    }

    /**
     * get value of customerId
     *
     * @return customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * get value of contact by name
     *
     * @param name
     * @return contact
     */
    public Contact getContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * add contact
     *
     * @param contact
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * override iterator()
     *
     * @return iterator
     */
    public Iterator<Contact> iterator() {
        return contacts.iterator();
    }
}
