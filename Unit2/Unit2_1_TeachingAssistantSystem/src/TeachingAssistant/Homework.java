package TeachingAssistant;

import java.util.*;
import java.text.*;

/**
 * this class extends from <code>Task</code>
 *
 * @author Hzy
 * @version 1.0
 */
public class Homework extends Task {
    private Date deadline;

    /**
     * the constructor
     *
     * @param code         attribute from class Task
     * @param title        attribute from class Task
     * @param description  attribute from class Task
     * @param creationDate attribute from class Task
     * @param state        attribute from class Task
     * @param deadline     the deadline time of the homework
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public Homework(int code, String title, String description, String creationDate, int state, String deadline) throws ParseException {
        super(code, title, description, creationDate, state);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.deadline = dateFormat.parse(deadline);
    }

    /**
     * get the deadline time
     *
     * @return return the deadline time as <code>Date</code>
     */
    public Date getDeadline() {
        return deadline;
    }
}
