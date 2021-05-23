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
        //AG: lepiej od razu zwróciæ -1.0 ni¿ rzucaæ wyj¹tek i obs³ugiwaæ go w try/catch. Tak proœciej i przejrzyœciej.
        if (!flowerMap.containsKey(name)) {
            return -1.0;
        }
        return flowerMap.get(name);
    }

    public double getPriceOfFlowerWithSpecificColour(List<Flower> flowers, String color) {
        int sum = 0;
        for (Flower flower : flowers) {
            //AG: ³atwiej zrobiæ na warunku gdy kolor siê zgadza. Dodatkowo ignoreCase powoduje ¿e wielkoœæ liter nie ma znaczenia
            if (flower.getColour().equalsIgnoreCase(color)) {
                double pricePerFlower = getPrice(flower);
                double pricePerFlowerPack = flower.getQuantity() * pricePerFlower;
                sum += pricePerFlowerPack;
            }
        }
        return sum;
    }
}
