package TeachingAssistant;

import java.util.*;
import java.text.*;

public class Homework extends Task {
    private Date deadline;

    public Homework(int code, String title, String description, String creationDate, int state, String deadline) throws ParseException {
        super(code, title, description, creationDate, state);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.deadline = dateFormat.parse(deadline);
    }

    public Date getDeadline() {
        return deadline;
    }
}
