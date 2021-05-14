package zad3;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kaczynski on 10:07 - 14.05.2021.
 */
public class ShoppingCart extends Container {
    public ShoppingCart(Customer owner) {
        this.owner = owner;
        this.ContainerName = "Wózek";
        this.flowersInside = new ArrayList<Flower>();
    }
}
