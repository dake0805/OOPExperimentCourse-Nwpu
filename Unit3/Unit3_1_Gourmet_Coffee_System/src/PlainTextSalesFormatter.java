/**
 * definition of class PlainTextSalesFormatter
 *
 * @author hzy
 */

public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    /**
     * constructor
     */
    private PlainTextSalesFormatter() {
    }

    /**
     * get static object singletonInstance
     *
     * @return singletonInstance
     */
    public static PlainTextSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    /**
     * format sales to String
     *
     * @param sales
     * @return String
     */
    public String formatSales(Sales sales) {
        String str = "";
        int i = 0;
        for (Order order : sales) {
            i++;
            str += "------------------------\n" +
                    "Order " + i + "\n\n";

            for (OrderItem orderItem : order) {
                str += orderItem.toString() + "\n";
            }

            str += "\n" + "Total = " + order.getTotalCost() + "\n";
        }

        return str;
    }
}
