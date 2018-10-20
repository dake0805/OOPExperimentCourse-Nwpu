public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();
    private String str = new String();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {

        int i = 0;
        for (Order order : sales) {
            i++;
            str += "------------------------\n" +
                    "Order " + i + "\n\n";
            for (OrderItem orderItem : order) {
                str += orderItem.toString() + "\n";
            }
            str += "\n" +
                    "    Total = " + order.getTotalCost() + "\n\n";
            str += "    Where\n\n" +
                    "        " + order.getNumberOfItems() + " is the order number\n";
      /*              "        "+ order.getItem().getQuantity() + " is the quantity of the product\n"+
                    "        "+ order.getItem() */
        }

        return str;
    }
}
