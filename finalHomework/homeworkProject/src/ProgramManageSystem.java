import java.io.*;
import java.text.ParseException;

/**
 * main class
 *
 * @author hzy
 * @version 1.0.0
 */
public class ProgramManageSystem {

    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new PrintWriter(System.out, true);
    private static PrintWriter stdErr = new PrintWriter(System.err, true);
    private CatalogLoader catalogLoader = new FileCatalogLoader();
    private Catalog catalog;

    private ProgramManageSystem() throws IOException, ParseException {
        this.catalog = catalogLoader.loadCatalog("catalog.dat");
    }


    public static void main(String[] args) throws IOException, ParseException {
        Catalog catalog = null;

        if (args.length != 1) {
            stdErr.println("Usage: java ProgramManageSystem filename");
        } else {
            try {
                catalog = (new FileCatalogLoader()).loadCatalog(args[0]);
            } catch (FileNotFoundException fnfe) {
                stdErr.println("The file does not exist");

                System.exit(1);

            } catch (ParseException e) {
                stdErr.println(e.getMessage());

                System.exit(1);
            }

            ProgramManageSystem application = new ProgramManageSystem();

            application.run();
        }
    }

    private void run() throws IOException {

        int choice = getChoice();

        while (choice != 0) {
            if (choice == 1) {
                displayCatalog();
            } else if (choice == 2) {
                stdErr.println("Filename is: ");
                String filename = stdIn.readLine();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                bufferedWriter.write(this.catalog.displayCatalog());
                bufferedWriter.close();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            choice = getChoice();
        }
    }

    private void displayCatalog() {
        stdOut.println(this.catalog.displayCatalog());
    }

    private int getChoice() throws IOException {

        int input;

        do {
            try {
                stdErr.println();
                stdErr.print("[0]  Quit\n" + "[1]  Display Catalog\n" + "[2]  Save in file\n" + "choice> ");
                stdErr.flush();

                input = Integer.parseInt(stdIn.readLine());

                stdErr.println();

                if (0 <= input && 2 >= input) {
                    break;
                } else {
                    stdErr.println("Invalid choice:  " + input);
                }
            } catch (NumberFormatException nfe) {
                stdErr.println(nfe);
            }
        } while (true);

        return input;
    }

}

