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

    private PriceList() {

    }

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
        //AG: lepiej od razu zwr�ci� -1.0 ni� rzuca� wyj�tek i obs�ugiwa� go w try/catch. Tak pro�ciej i przejrzy�ciej.
        if (!flowerMap.containsKey(name)) {
            return -1.0;
        }
        return flowerMap.get(name);
    }

    public double getPriceOfFlowerWithSpecificColour(List<Flower> flowers, String color) {
        int sum = 0;
        for (Flower flower : flowers) {
            //AG: �atwiej zrobi� na warunku gdy kolor si� zgadza. Dodatkowo ignoreCase powoduje �e wielko�� liter nie ma znaczenia
            if (flower.getColour().equalsIgnoreCase(color)) {
                double pricePerFlower = getPrice(flower);
                double pricePerFlowerPack = flower.getQuantity() * pricePerFlower;
                sum += pricePerFlowerPack;
            }
        }
        return sum;
    }
}
