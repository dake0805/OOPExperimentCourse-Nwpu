package TeachingAssistant;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int code;
    private String name;
    private List<TaskScore> taskScore;

    public Student(int code, String name) {
        this.code = code;
        this.name = name;
        this.taskScore = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<TaskScore> getTaskScore() {
        return taskScore;
    }

    public void addTaskScore(TaskScore taskScore) {
        this.taskScore.add(taskScore);
    }

    public void editTaskScore(TaskScore taskScore) {
        System.out.println("function editTaskScore");
    }
}
