package zad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Krzysztof Kaczynski on 10:41 - 14.05.2021.
 */
abstract public class Container {
    protected Customer owner;
    protected ArrayList<Flower> flowersInside;
    protected String containerName;


    public Container(Customer owner, String containerName) {
        this.owner = owner;
        flowersInside = new ArrayList<>();
        this.containerName = containerName;
    }

    public void putInsideFlower(Flower flower) {
        flowersInside.add(flower);
    }


    public List<Flower> getContents() {
        return Collections.unmodifiableList(flowersInside);
    }

    public String toString() {
        String content = containerName + " właściciel " + owner.getName();
        if (flowersInside.isEmpty()) {
            content += "  -- pusto";
        } else {
            PriceList priceList = PriceList.getInstance();
            for (Flower flower : flowersInside) {
                double price;
                price = priceList.getPrice(flower);
                content += "\n";
                content += flower.getName();
                content += ", kolor: " + flower.getColour();
                content += ", ilość " + flower.getQuantity();
                content += ", cena " + price;
            }
        }
        return content;
    }

    public void packAll(ArrayList<Flower> flowersToPack) {
        flowersInside = flowersToPack;
    }

    public void pack(Container container) {
        container.packAll(flowersInside);
    }
}
