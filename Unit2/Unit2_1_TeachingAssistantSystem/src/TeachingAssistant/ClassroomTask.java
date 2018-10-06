package TeachingAssistant;

import java.text.ParseException;
import java.util.List;

/**
 * this class extends from <code>Task</code>
 *
 * @author Hzy
 * @version 1.0
 */
public class ClassroomTask extends Task {
    private List<Student> listOfStudent;

    /**
     * @param code         attribute from class Task
     * @param title        attribute from class Task
     * @param description  attribute from class Task
     * @param creationDate attribute from class Task
     * @param state        attribute from class Task
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public ClassroomTask(int code, String title, String description, String creationDate, int state) throws ParseException {
        super(code, title, description, creationDate, state);
    }

    /**
     * get the list of student
     *
     * @return return the student list as <code>List</code>
     */
    public List<Student> getListOfStudent() {
        return listOfStudent;
    }
}
