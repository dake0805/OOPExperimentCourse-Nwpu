
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author hzy
 * @version 1.0.0
 */
public class FileCatalogLoader implements CatalogLoader {
    private Catalog catalog;
    private ArrayList<Program> programs = new ArrayList<>();
    private StringTokenizer stringTokenizer;

    public Catalog loadCatalog(String fileName) throws IOException, ParseException {
        programs.clear();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        while (line != null) {
            if (line.startsWith("Normal")) {
                programs.add(readNormal(line));
            } else if (line.startsWith("Game")) {
                programs.add(readGame(line));
            }
            line = bufferedReader.readLine();
        }
        catalog = new Catalog(programs);
        bufferedReader.close();
        return catalog;
    }

    private GameProgram readGame(String line) throws ParseException {
        stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() != 8) {
            System.err.println("error");
            return null;
        }
        stringTokenizer.nextToken();
        double size = Double.parseDouble(stringTokenizer.nextToken());
        String name = stringTokenizer.nextToken();
        int id = Integer.parseInt(stringTokenizer.nextToken());
        String publisher = stringTokenizer.nextToken();
        String developer = stringTokenizer.nextToken();
        int playTime = Integer.parseInt(stringTokenizer.nextToken());
        String lastPlayedDate = stringTokenizer.nextToken();
        GameProgram gameProgram = new GameProgram(size, name, id, publisher, developer, playTime, lastPlayedDate);
        return gameProgram;
    }

    private NormalProgram readNormal(String line) throws ParseException {
        stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() != 7) {
            System.err.println("error");
            return null;
        }
        stringTokenizer.nextToken();
        double size = Double.parseDouble(stringTokenizer.nextToken());
        String name = stringTokenizer.nextToken();
        int id = Integer.parseInt(stringTokenizer.nextToken());
        String publisher = stringTokenizer.nextToken();
        String version = stringTokenizer.nextToken();
        String installDate = stringTokenizer.nextToken();
        NormalProgram normalProgram = new NormalProgram(size, name, id, publisher, version, installDate);
        return normalProgram;
    }
}
