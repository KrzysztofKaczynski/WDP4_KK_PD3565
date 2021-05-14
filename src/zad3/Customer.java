package zad3;

/**
 * Created by Krzysztof Kaczynski on 10:06 - 14.05.2021.
 */
public class Customer {
    private String name;
    private Double cash;

    private ShoppingCart shoppingCart;

    public Customer(String name, int cash) {
        this.parametrize(name, cash);
    }

    public Customer(String name, double cash) {
        this.parametrize(name, cash);
    }

    private void parametrize(String name, double cash) {
        this.name = name;
        this.cash = cash;

        this.shoppingCart = new ShoppingCart(this);
    }

    public String getName() {
        return this.name;
    }

    public void get(Flower flower) {
        this.shoppingCart.putInsideFlower(flower);
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void pay() {
        ShoppingCart newCart = new ShoppingCart(this);
        PriceList priceList = PriceList.getInstance();

        for (Flower flower : this.shoppingCart.getContents()) {
            try {
                double pricePerFlower = priceList.getPrice(flower);
                double pricePerFlowerPack = flower.getQuantity() * pricePerFlower;

                if (this.cash - pricePerFlowerPack >= 0) {
                    this.cash -= pricePerFlowerPack;
                    newCart.putInsideFlower(flower);
                }
            } catch (Exception e) {
            }
        }

        this.shoppingCart = newCart;
    }

    public double getCash() {
        return this.cash;
    }

    public void pack(Box box) {
        this.shoppingCart.pack(box);
    }
}
