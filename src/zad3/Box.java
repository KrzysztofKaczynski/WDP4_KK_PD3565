package zad3;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kaczynski on 10:06 - 14.05.2021.
 */
public class Box extends Container {
    public Box(Customer owner) {
        this.owner = owner;
        this.ContainerName = "Pudełko";
        this.flowersInside = new ArrayList<Flower>();
    }

}
