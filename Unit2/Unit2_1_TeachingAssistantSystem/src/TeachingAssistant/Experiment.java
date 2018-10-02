package TeachingAssistant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Experiment extends Task {
    private Date deadline;
    private int numberOfJavaFile;

    public Experiment(int code, String title, String description, String creationDate, int state, String deadline, int numberOfJavaFile)
            throws ParseException {
        super(code, title, description, creationDate, state);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.deadline = dateFormat.parse(deadline);
        this.numberOfJavaFile = numberOfJavaFile;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getNumberOfJavaFile() {
        return numberOfJavaFile;
    }
}
