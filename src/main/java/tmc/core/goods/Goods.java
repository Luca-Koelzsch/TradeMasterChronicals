package tmc.core.goods;

import java.io.Serializable;

/**
 *
 * @author Luca Kölzsch
 */
public abstract class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    //Attribute
    private int ID;
    private String name;
    private double price, basePrice, minPrice, maxPrice;
    private String imagePath;
    protected final String basePath = "src/images/goods/";

    public Goods(int ID, String name, double price, double basePrice, double minPrice, double maxPrice, String imagePath) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.basePrice = basePrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.imagePath = imagePath;
    }

    public Goods(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    //Methoden
    public Goods buy() {
        return this;
    }

    public void calculatePriceRange(int level) {
        int range = 0;
        switch (level) {
            case 1:
                range = 10;
                break;
            case 2:
                range = 10;
                break;
            case 3:
                range = 20;
                break;
            case 4:
                range = 25;
                break;
            case 5:
                range = 30;
                break;
            case 6:
                range = 40;
                break;
            case 7:
                range = 50;
                break;
            case 8:
                range = 75;
                break;
            case 9:
                range = 100;
                break;
            case 10:
                range = 200;
                break;
        }
        double rangeValue = basePrice * range / 100;
        
        minPrice = basePrice - rangeValue;
        if (minPrice < 0) {
            minPrice = 0;
        }
        maxPrice = basePrice + rangeValue;
    }

    public void doInflation(double rate) {
        if (rate > 0) {
            basePrice += basePrice * (rate / 100);
        } else {
            basePrice -= basePrice * (rate / 100);
        }

    }

    //Getter und Setter 
    public double getBasePrice() {
        return basePrice;
    }

    public int getID() {
        return ID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " Preis: " + price;
    }

}
