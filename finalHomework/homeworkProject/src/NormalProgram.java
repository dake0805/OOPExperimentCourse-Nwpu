import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author hzy
 * @version 1.0.0
 */
public class NormalProgram extends Program {

    private String version;
    private Date installDate;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public NormalProgram(double size, String name, int id, String publisher, String version, String installDate) throws ParseException {
        super(size, name, id, publisher);
        this.version = version;
        this.installDate = simpleDateFormat.parse(installDate);
    }

    public Date getInstallDate() {
        return installDate;
    }

    public String getVersion() {
        return version;
    }

    public String toString() {
        return (super.toString() + "_" + this.getVersion() + "_" + simpleDateFormat.format(getInstallDate()));
    }
}
