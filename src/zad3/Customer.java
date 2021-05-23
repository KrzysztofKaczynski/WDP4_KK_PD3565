package zad3;

/**
 * Created by Krzysztof Kaczynski on 10:06 - 14.05.2021.
 */
public class Customer {
    private String name;
    private Double cash;

    private ShoppingCart shoppingCart;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
        shoppingCart = new ShoppingCart(this);
    }

    public String getName() {
        return this.name;
    }

    public void get(Flower flower) {
        shoppingCart.putInsideFlower(flower);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void pay() {
        ShoppingCart newCart = new ShoppingCart(this);
        PriceList priceList = PriceList.getInstance();
        for (Flower flower : this.shoppingCart.getContents()) {
            double pricePerFlower = priceList.getPrice(flower);
            double pricePerFlowerPack = flower.getQuantity() * pricePerFlower;

            if (isPriceDefined(pricePerFlower) && hasEnoughCash(pricePerFlowerPack)) {
                cash -= pricePerFlowerPack;
                newCart.putInsideFlower(flower);
            }
        }
        shoppingCart = newCart;
    }

    private boolean hasEnoughCash(double pricePerFlowerPack) {
        return cash - pricePerFlowerPack >= 0;
    }

    private boolean isPriceDefined(double pricePerFlower) {
        return pricePerFlower > 0;
    }

    public double getCash() {
        return this.cash;
    }

    public void pack(Box box) {
        this.shoppingCart.pack(box);
    }
}
