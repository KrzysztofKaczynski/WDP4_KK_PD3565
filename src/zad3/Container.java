package zad3;

/**
 * Created by Krzysztof Kaczynski on 10:41 - 14.05.2021.
 */
public class Container {
    protected Customer owner;
    protected ArrayList<Flower> flowersInside;
    protected String ContrainerName;

    public void emptyContainer()
    {
        this.flowersInside = new ArrayList<Flower>();
    }

    public void putInsideFlower(Flower flower) {
        this.flowersInside.add(flower);
    }

    public ArrayList<Flower> getContents() {
        return this.flowersInside;
    }

    public String toString() {
        String ret = ContrainerName + " właściciel " + owner.getName();
        if(this.flowersInside.isEmpty()) {
            ret += "  -- pusto";
        } else {
            PriceList priceList = PriceList.getInstance();
            for(Flower flower : this.flowersInside) {
                double price;

                try{
                    price = priceList.getPrice(flower);
                } catch(Exception e) {
                    price = -1.0;
                }

                ret += "\n";
                ret += flower.getName();
                ret += ", kolor: " + flower.getColour();
                ret += ", ilość " + flower.getQuantity();
                ret += ", cena " + price;
            }
        }

        return ret;
    }

    public void packAll(ArrayList<Flower> flowersToPack) {
        this.flowersInside = flowersToPack;
    }

    public void pack(Container container) {
        container.packAll(this.flowersInside);
    }
}
