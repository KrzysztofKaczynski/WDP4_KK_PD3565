package zad3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krzysztof Kaczynski on 10:06 - 14.05.2021.
 */
public class PriceList {
    private static PriceList instance = null;
    private Map<String, Double> flowerMap = new HashMap<>();

    private PriceList() {}

    public static PriceList getInstance() {
        if (instance == null) {
            instance = new PriceList();
        }
        return instance;
    }

    public void put(String flowerName, double price) {
        this.flowerMap.put(flowerName, price);
    }

    public double getPrice(Flower flower) {
        String name = flower.getName();

        if (!flowerMap.containsKey(name)) {
            return -1.0;
        }
        return flowerMap.get(name);
    }

    public double getTotalPrice(Flower flower) {
        double price = getPrice(flower);

        if (price < 0.0) {
            return -1.0;
        }

        return price * flower.getQuantity();
    }

    public int getPriceOfFlowerWithGivenColor(List<Flower> flowers, String color) {
        double sum = 0.0;
        for (Flower flower : flowers) {
            if (flower.getColor().equalsIgnoreCase(color)) {
                sum += getTotalPrice(flower);
            }
        }

        return (int) sum;
    }
}
