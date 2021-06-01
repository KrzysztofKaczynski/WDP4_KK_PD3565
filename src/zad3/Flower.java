package zad3;

/**
 * Created by Krzysztof Kaczynski on 11:05 - 14.05.2021.
 */
abstract public class Flower {
    protected int quantity;
    protected String color;
    protected String name;

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
