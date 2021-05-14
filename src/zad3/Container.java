package zad3;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kaczynski on 10:41 - 14.05.2021.
 */
abstract public class Container {
    protected Customer owner;
    protected ArrayList<Flower> flowersInside;
    protected String ContainerName;

    public void emptyContainer() {
        this.flowersInside = new ArrayList<Flower>();
    }

    public void putInsideFlower(Flower flower) {
        this.flowersInside.add(flower);
    }

    public ArrayList<Flower> getContents() {
        return this.flowersInside;
    }

    public String toString() {
        String content = ContainerName + " właściciel " + owner.getName();
        if (this.flowersInside.isEmpty()) {
            content += "  -- pusto";
        } else {
            PriceList priceList = PriceList.getInstance();
            for (Flower flower : this.flowersInside) {
                double price;

                try {
                    price = priceList.getPrice(flower);
                } catch (Exception e) {
                    price = -1.0;
                }

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
        this.flowersInside = flowersToPack;
    }

    public void pack(Container container) {
        container.packAll(this.flowersInside);
    }
}
