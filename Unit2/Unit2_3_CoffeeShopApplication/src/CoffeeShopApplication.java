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
                    throw new MoreThanFourValues();
                }
                if (coffeeToken.countTokens() < 4) {
                    throw new LessThanFourValues();
                }
                int id = Integer.parseInt(coffeeToken.nextToken());
                if (id < 0 || id > 50) {
                    throw new WrongIdNumber();
                }
                String name = coffeeToken.nextToken();
                String taste = coffeeToken.nextToken();
                double cost = Double.parseDouble(coffeeToken.nextToken());
                if (cost < 2 || cost > 50) {
                    throw new WrongCostNumber();
                }

                coffee = new Coffee(id, name, taste, cost);
                stdOut.println("Entered success");
                return coffee;
            } catch (MoreThanFourValues e) {
                stdErr.println("Entered more than four values, Need 4 elements in one line\n" +
                        "Please enter again");
            } catch (LessThanFourValues e) {
                stdErr.println("Entered less than four values, Need 4 elements in one line\n" +
                        "Please enter again");
            } catch (NumberFormatException e) {
                stdErr.println("Number format is not valid\n"
                        + "Please enter again");
            } catch (WrongIdNumber e) {
                stdErr.println("Id should more than 0 and less than 50\n" +
                        "Please enter again");
            } catch (WrongCostNumber e) {
                stdErr.println("Cost should more than 2 and less than 50\n"
                        + "Please enter again");
            }
        }
    }
}

class MoreThanFourValues extends Exception {
    public MoreThanFourValues() {
        super();
    }
}

class LessThanFourValues extends Exception {
    public LessThanFourValues() {
        super();
    }
}

class WrongIdNumber extends Exception {
    public WrongIdNumber() {
        super();
    }
}

class WrongCostNumber extends Exception {
    public WrongCostNumber() {
        super();
    }
}
