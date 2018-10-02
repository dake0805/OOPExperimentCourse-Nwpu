package TeachingAssistant;

public class TaskScore {
    private float score;
    private Task task;
    private Student student;

    public TaskScore(float score, Task task, Student student) {
        this.score = score;
        this.task = task;
        this.student = student;
    }

    public float getScore() {
        return score;
    }

    public Task getTask() {
        return task;
    }

    public Student getStudent() {
        return student;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
