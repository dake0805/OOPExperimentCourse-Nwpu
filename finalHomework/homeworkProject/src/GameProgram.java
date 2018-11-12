import java.text.*;
import java.util.Date;

/**
 * @author hzy
 * @version 1.0.0
 */
public class GameProgram extends Program {
    private String developer;
    private int playTime;
    private Date lastPlayedDate;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public GameProgram(double size, String name, int id, String publisher, String developer, int playTime, String lastPlayedDate) throws ParseException {
        super(size, name, id, publisher);
        this.developer = developer;
        this.playTime = playTime;
        this.lastPlayedDate = simpleDateFormat.parse(lastPlayedDate);
    }

    public String getDeveloper() {
        return developer;
    }

    public int getPlayTime() {
        return playTime;
    }

    public Date getLastPlayedDate() {
        return lastPlayedDate;
    }

    public String toString() {
        return (super.toString() + "_" + this.getDeveloper() + "_" + this.getPlayTime() +
                "_" + simpleDateFormat.format(getLastPlayedDate()));
    }

}
