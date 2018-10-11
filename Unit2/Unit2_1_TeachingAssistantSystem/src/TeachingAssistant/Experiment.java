package teachingAssistant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class extends from <code>Task</code>
 *
 * @author Hzy
 * @version 1.0
 */
public class Experiment extends Task {
    private Date deadline;
    private int numberOfJavaFile;

    /**
     * the constructor
     *
     * @param code             attribute from class Task
     * @param title            attribute from class Task
     * @param description      attribute from class Task
     * @param creationDate     attribute from class Task
     * @param state            attribute from class Task
     * @param deadline         the deadline date of the experiment
     * @param numberOfJavaFile the number of java file of the experiment
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public Experiment(int code, String title, String description, String creationDate, int state, String deadline, int numberOfJavaFile)
            throws ParseException {
        super(code, title, description, creationDate, state);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.deadline = dateFormat.parse(deadline);
        this.numberOfJavaFile = numberOfJavaFile;
    }

    /**
     * express the experiment task as a fixed format overrides method in Class Task
     *
     * @return return the experiment as String
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return ("Experiment: " + super.toString() + ", deadline = " + dateFormat.format(deadline) + ", "
                + "numberOfJavaFile = " + numberOfJavaFile);
    }

    /**
     * get the deadline time
     *
     * @return return the deadline time as <code>Date</code>
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * get the number of java file
     *
     * @return return the number as Integer
     */
    public int getNumberOfJavaFile() {
        return numberOfJavaFile;
    }
}
