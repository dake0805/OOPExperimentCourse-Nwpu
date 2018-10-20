public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    private XMLSalesFormatter() {
    }

    public static XMLSalesFormatter getSingletonInstance() {

        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        return null;
    }
}
