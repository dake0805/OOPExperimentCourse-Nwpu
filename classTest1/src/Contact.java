/**
 * definition of class Contact, extents class Person
 *
 * @author hzy
 */

public class Contact extends Person {
    private String workTelephone;
    private String jobPosition;

    /**
     * @param name          name of contact
     * @param homeTelephone homeTel of contact
     * @param email         email of contact
     * @param workTelephone workTel of contact
     * @param jobPosition   jobPosition of contact
     */
    public Contact(String name, String homeTelephone, String email, String workTelephone, String jobPosition) {
        super(name, homeTelephone, email);
        this.workTelephone = workTelephone;
        this.jobPosition = jobPosition;
    }

    /**
     * get value of WorkTelephone
     *
     * @return workTelephone
     */
    public String getWorkTelephone() {
        return workTelephone;
    }

    /**
     * get value of jobPosition
     *
     * @return jobPosition
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * override toString()
     *
     * @return String
     */
    public String toString() {
        return (super.toString() + "_"
                + getWorkTelephone() + "_" + getJobPosition());
    }
}
