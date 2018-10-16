package teachingAssistant;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes attributes of a student
 *
 * @author Hzy
 * @version 1.0
 */

public class Student {
    private int code;
    private String name;
    private List<TaskScore> taskScore;

    /**
     * the constructor
     *
     * @param code code of the student
     * @param name name of the student
     */
    public Student(int code, String name) {
        this.code = code;
        this.name = name;
        this.taskScore = new ArrayList<>();
    }

    /**
     * express the student as a fixed format overrides method in java.lang.Object
     *
     * @return return the student as String
     */
    public String toString() {
        return ("Student: " + "name = " + name + ", code = " + code);
    }

    /**
     * get code of the student
     *
     * @return return the code of the student as Integer
     */
    public int getCode() {
        return code;
    }

    /**
     * get the name of the student
     *
     * @return return the name of the student as String
     */
    public String getName() {
        return name;
    }

    /**
     * get the list of task score of the student
     *
     * @return return the list of task score as <code>List</code>
     */
    public List<TaskScore> getTaskScore() {
        return taskScore;
    }

    /**
     * add a new task score to the list of the task score of the student
     *
     * @param taskScore the task score need to be added
     */
    public void addTaskScore(TaskScore taskScore) {
        this.taskScore.add(taskScore);
    }

    public void editTaskScore(TaskScore taskScore) {
        System.out.println("function editTaskScore");
    }
}
