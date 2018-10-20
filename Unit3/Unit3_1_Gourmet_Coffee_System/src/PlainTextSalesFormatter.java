public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

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
