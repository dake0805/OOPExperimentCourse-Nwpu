/**
 * @author hzy
 * @version 1.0.0
 */

public class Program {
    private double size;
    private String name;
    private int id;
    private String publisher;

    public Program(double size, String name, int id, String publisher) {
        this.size = size;
        this.name = name;
        this.id = id;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public String toString() {
        return (this.getSize() + "_" + this.getName() + "_" + this.getId() + "_" + this.getPublisher());
    }


}
