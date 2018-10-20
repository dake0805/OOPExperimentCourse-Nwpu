public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter(){
        
    }

    public static HTMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        return "test";
    }
}
