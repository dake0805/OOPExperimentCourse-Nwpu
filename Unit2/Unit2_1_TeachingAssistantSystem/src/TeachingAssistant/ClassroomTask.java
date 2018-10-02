package TeachingAssistant;

import java.text.ParseException;
import java.util.List;


public class ClassroomTask extends Task {
    private List<Student> listOfStudent;

    public ClassroomTask(int code, String title, String description, String creationDate, int state) throws ParseException {
        super(code, title, description, creationDate, state);
    }

    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

}
