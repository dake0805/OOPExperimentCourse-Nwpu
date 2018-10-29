/**
 * definition of class XMLSalesFormatter
 *
 * @author hzy
 */
public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    /**
     * constructor
     */
    private XMLSalesFormatter() {
    }

    /**
     * get static object singletonInstance
     *
     * @return singletonInstance
     */
    public static XMLSalesFormatter getSingletonInstance() {

        return singletonInstance;
    }

    /**
     * format sales to String
     *
     * @param sales
     * @return String
     */
    public String formatSales(Sales sales) {
        String str = "<Sales>\n";
        for (Order order : sales) {
            str += "  <Order total=\"" + order.getTotalCost() + "\">\n";
            for (OrderItem orderItem : order) {
                str += "    <OrderItem quantity=\"" + orderItem.getQuantity() + "\" " +
                        "price=\"" + orderItem.getProduct().getPrice() + "\">" +
                        orderItem.getProduct().getCode() + "</OrderItem>\n";

            }
            str += "  </Order>\n";
        }
        str += "</Sales>\n";
        return str;
    }
}
