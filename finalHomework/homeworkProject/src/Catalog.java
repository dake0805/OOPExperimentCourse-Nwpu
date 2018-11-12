import java.util.List;

/**
 * @author hzy
 * @version 1.0.0
 */
public class Catalog {
    private List<Program> programList;

    public Catalog(List<Program> programList) {
        this.programList = programList;
    }

    public String displayCatalog() {
        String str = "";
        for (Program program : programList) {
            str += (program.toString() + "\n");
        }
        return str;
    }

}
