package zad3;

/**
 * Created by Krzysztof Kaczynski on 10:06 - 14.05.2021.
 */
public class Box extends Container{
    public Box(Customer owner) {
        this.owner = owner;
        this.ContrainerName = "Pudełko";
        this.flowersInside = new ArrayList<Flower>();
    }

}
