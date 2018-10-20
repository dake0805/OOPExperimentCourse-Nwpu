public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter() {

    }

    public static HTMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        String str = "<html>\n" +
                "  <body>\n" +
                "    <center><h2>Orders</h2></center>\n";
        for (Order order : sales) {
            str += "    <hr>\n";
            str += "    <h4>Total = " + order.getTotalCost() + "</h4>\n";

            for (OrderItem orderItem : order) {
                str += "      <p>\n";
                str += "        <b>code:</b> " + orderItem.getProduct().getCode() + "<br>\n" +
                        "        <b>quantity:</b> " + orderItem.getQuantity() + "<br>\n" +
                        "        <b>price:</b> " + orderItem.getProduct().getPrice() + "\n" +
                        "      </p>\n";
            }
        }
        str += "  </body>\n" +
                "</html>\n";
        return str;
    }
}
