import java.util.ArrayList;

/**
 * definition of class CustomerInformationSystem
 *
 * @author hzy
 */
public class CustomerInformationSystem {

    /**
     * constructor without parameter
     */
    public CustomerInformationSystem() {

    }

    ArrayList<Customer> customers = new ArrayList<>();

    /**
     * add customer
     *
     * @param tempCustomer
     */
    public void addCustomer(Customer tempCustomer) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(tempCustomer.getCustomerId())) {
                return;
            }
        }
        customers.add(tempCustomer);
    }

    /**
     * get value of customer by customerId
     *
     * @param customerId
     * @return customer
     */
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * add contact
     *
     * @param customerId
     * @param contact
     * @return boolean
     */
    public boolean addContact(String customerId, Contact contact) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                if (customer instanceof IndividualCustomer) {
                    return false;
                } else if (customer instanceof InstitutionalCustomer) {
                    ((InstitutionalCustomer) customer).addContact(contact);
                    return true;
                }
            }
        }
        return false;
    }
}
