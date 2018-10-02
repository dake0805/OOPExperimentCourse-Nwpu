package TeachingAssistant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;

public class Task {
    private int code;
    private String title;
    private String description;
    private Date creationDate;
    private int state;

    public Task(int code, String title, String description, String creationDate, int state) throws ParseException {
        this.code = code;
        this.title = title;
        this.description = description;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.creationDate = dateFormat.parse(creationDate);
        this.state = state;
    }

    public void setState(int state){
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getState() {
        return state;
    }



}
