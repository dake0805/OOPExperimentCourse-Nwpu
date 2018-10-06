package TeachingAssistant;

/**
 * this class has score of the task
 *
 * @author Hzy
 * @version 1.0
 */
public class TaskScore {
    private float score;
    private Task task;
    private Student student;

    /**
     * the constructor
     *
     * @param score   the score of the task of the student
     * @param task    the task of the student
     * @param student the student who has these attributes
     */
    public TaskScore(float score, Task task, Student student) {
        this.score = score;
        this.task = task;
        this.student = student;
    }

    /**
     * get the score
     *
     * @return return the score of the task
     */
    public float getScore() {
        return score;
    }

    /**
     * get the task of the student
     *
     * @return return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * get the student
     *
     * @return return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * set the score of the task
     *
     * @param score the number of the score you need to set
     */
    public void setScore(float score) {
        this.score = score;
    }
}
