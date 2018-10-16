import java.io.*;
import java.util.*;

public class CoffeeShopApplication {

    private static BufferedReader stdIn =
            new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut =
            new PrintWriter(System.out, true);
    private static PrintWriter stdErr =
            new PrintWriter(System.err, true);

    private CoffeeShop coffeeShop;

    private static final int MIN_NUMBER = 0;

    private static final int MAX_NUMBER = 50;

    private static final double MIN_COST = 2.0;

    private static final double MAX_COST = 50.0;

    public static void main(String[] args) throws IOException {

        CoffeeShopApplication application = new CoffeeShopApplication();

        application.run();
    }

    private void run() throws IOException {

        coffeeShop = new CoffeeShop();

        int choice = getChoice();

        while (choice != 0) {

            if (choice == 1) {
                coffeeShop.addCoffee(readCoffee());
            } else if (choice == 2) {
                stdOut.println(coffeeShop.toString());
            } else if (choice == 3) {
                stdOut.println("Total Cost: " + coffeeShop.getTotalCost());
            }

            choice = getChoice();
        }
    }

    private int getChoice() throws IOException {
        int choice = Integer.parseInt(stdIn.readLine());
        return choice;
    }

    private Coffee readCoffee() throws IOException {
        while (true) {
            try {
                Coffee coffee;
                String strCoffee = stdIn.readLine();
                StringTokenizer coffeeToken = new StringTokenizer(strCoffee, "_");
                if (coffeeToken.countTokens() > 4) {
                    stdErr.println("Entered more than four values, Need 4 elements in one line\n" +
                            "Please enter again");
                    continue;
                }
                if (coffeeToken.countTokens() < 4) {
                    stdErr.println("Entered less than four values, Need 4 elements in one line\n" +
                            "Please enter again");
                    continue;
                }
                int id = Integer.parseInt(coffeeToken.nextToken());
                if (id < MIN_NUMBER || id > MAX_NUMBER) {
                    stdErr.println("Id should more than 0 and less than 50\n" +
                            "Please enter again");
                    continue;
                }
                String name = coffeeToken.nextToken();
                String taste = coffeeToken.nextToken();
                double cost = Double.parseDouble(coffeeToken.nextToken());
                if (cost < MIN_COST || cost > MAX_COST) {
                    stdErr.println("Cost should more than 2 and less than 50\n"
                            + "Please enter again");
                    continue;
                }

                coffee = new Coffee(id, name, taste, cost);
                stdOut.println("Entered success");
                return coffee;
            } catch (NumberFormatException e) {
                stdErr.println("Number format is not valid\n"
                        + "Please enter again");
            }
        }
    }
}
