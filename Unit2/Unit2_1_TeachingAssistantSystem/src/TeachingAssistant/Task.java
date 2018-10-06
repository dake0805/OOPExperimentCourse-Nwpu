package TeachingAssistant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;

/**
 * This class describes attributes of a task
 *
 * @author Hzy
 * @version 1.0
 */
public class Task {
    private int code;
    private String title;
    private String description;
    private Date creationDate;
    private int state;

    /**
     * the constructor
     *
     * @param code         the code of the task
     * @param title        the title of the task
     * @param description  the description of the task
     * @param creationDate the date of creation of the task
     * @param state        the state of the task
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public Task(int code, String title, String description, String creationDate, int state) throws ParseException {
        this.code = code;
        this.title = title;
        this.description = description;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.creationDate = dateFormat.parse(creationDate);
        this.state = state;
    }

    /**
     * set the state of the task
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * express the task as a fixed format overrides method in java.lang.Object
     *
     * @return return the string of task with format
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String toStr = "title = " + (this).getTitle() + ", "
                + "code = " + this.getCode() + ", "
                + "description = " + this.getDescription() + ", "
                + "creationDate = " + dateFormat.format(this.getCreationDate()) + ", "
                + "state = " + this.getState();
        if (Homework.class.isInstance(this)) {
            return ("Homework: " + toStr
                    + ", deadline = " + dateFormat.format(((Homework) (this)).getDeadline()));
        } else if (ClassroomTask.class.isInstance(this)) {
            return ("Classroom this: " + toStr);
        } else {
            return ("Experiment: " + toStr
                    + ", deadline = " + dateFormat.format(((Experiment) (this)).getDeadline()) + ", "
                    + "numberOfJavaFile = " + ((Experiment) (this)).getNumberOfJavaFile());
        }
    }

    /**
     * get the code of the task
     *
     * @return return the code as integer
     */
    public int getCode() {
        return code;
    }

    /**
     * get the title of the task
     *
     * @return return the title as string
     */
    public String getTitle() {
        return title;
    }

    /**
     * get the description of the task
     *
     * @return return the description as string
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the create date of the task
     *
     * @return return the date as <code>Date</code>
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * get the state of the task
     *
     * @return return the task as Integer
     */
    public int getState() {
        return state;
    }
}
