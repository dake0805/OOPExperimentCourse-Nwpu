import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader {

    private Catalog catalog;
    private ArrayList<Product> products = new ArrayList<>();
    private StringTokenizer stringTokenizer;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String code;
    private String description;
    private BigDecimal price;
    private Date productionDate;
    private String shelfLife;

    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException, ParseException {

        products.clear();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        while (line != null) {
            if (line.startsWith("PureMilk")) {
                products.add(readPureMilk(line));
            } else if (line.startsWith("Jelly")) {
                products.add(readJelly(line));
            } else if (line.startsWith("Yogurt")) {
                products.add(readYogurt(line));
            } else if (line.startsWith("MilkDrink")) {
                products.add(readMilkDrink(line));
            }
        }
        catalog = new Catalog(products);
        return catalog;
    }

    private PureMilk readPureMilk(String line) throws ParseException {
        readProduct(line);
        if (stringTokenizer.countTokens() != 3) {
            System.err.println("error");
            return null;
        }
        String countryOfOrigin = stringTokenizer.nextToken();
        String butterfat = stringTokenizer.nextToken();
        String protein = stringTokenizer.nextToken();

        PureMilk pureMilk = new PureMilk(code, description, price, productionDate, shelfLife, countryOfOrigin, butterfat, protein);
        return pureMilk;
    }

    private Jelly readJelly(String line) throws ParseException {
        readProduct(line);
        if (stringTokenizer.countTokens() != 2) {
            System.err.println("error");
            return null;
        }
        String type = stringTokenizer.nextToken();
        String diluteConcentration = stringTokenizer.nextToken();

        Jelly jelly = new Jelly(code, description, price, productionDate, shelfLife, type, diluteConcentration);
        return jelly;
    }

    private Yogurt readYogurt(String line) throws ParseException {
        readProduct(line);
        if (stringTokenizer.countTokens() != 1) {
            System.err.println("error");
            return null;
        }
        String flavor = stringTokenizer.nextToken();

        Yogurt yogurt = new Yogurt(code, description, price, productionDate, shelfLife, flavor);
        return yogurt;
    }

    private MilkDrink readMilkDrink(String line) throws ParseException {
        readProduct(line);
        if (stringTokenizer.countTokens() != 2) {
            System.err.println("error");
            return null;
        }
        String flavor = stringTokenizer.nextToken();
        String sugar = stringTokenizer.nextToken();

        MilkDrink milkDrink = new MilkDrink(code, description, price, productionDate, shelfLife, flavor, sugar);
        return milkDrink;
    }

    private void readProduct(String line) throws ParseException {
        stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() < 6) {
            System.err.println("error");
            return;
        }
        stringTokenizer.nextToken();
        code = stringTokenizer.nextToken();
        description = stringTokenizer.nextToken();
        price = new BigDecimal(stringTokenizer.nextToken());
        productionDate = simpleDateFormat.parse(stringTokenizer.nextToken());
        shelfLife = stringTokenizer.nextToken();
    }

}
