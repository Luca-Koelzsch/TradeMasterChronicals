package tmc.core.markets;

import java.io.Serializable;
import java.util.Random;
import tmc.core.goods.Goods;

/**
 *
 * @author Luca Kölzsch
 */

//Russland, Australien, Asian, Südamerika, Nordamerika, Europa, Afrika

public abstract class Market implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //Attribute
    private int ID;
    private String name;
    protected Goods[] availableGoods;

    public Market(int ID, String name, Goods[] availableGoods) {
        this.ID = ID;
        this.name = name;
        this.availableGoods = availableGoods;
    }
    
    public Market(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    //public Methoden  
    public Goods buy(int ID) {
        for (int i = 0; i < availableGoods.length; i++) {
            if (availableGoods[i].getID() == ID) {
                return availableGoods[i].buy();
            }
        }
        return null;
    }
    
    public void generatePrices() {
        for (Goods availableGood : availableGoods) {
            availableGood.setPrice(generateDouble(availableGood.getMinPrice(), availableGood.getMaxPrice()));
        }
    }
    
    //private Methoden
    private double generateDouble(double min, double max) {
        Random rand = new Random();
        return Math.round((min + (max - min) * rand.nextDouble()) * 100.0) / 100.0;
    }
 
    //getter und setter
    public Goods[] getAvailableGoods() {
        return availableGoods;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setAvailableGoods(Goods[] availableGoods) {
        this.availableGoods = availableGoods;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        String value = "";
        for (Goods availableGood : availableGoods) {
            value += availableGood.toString() + "\n";
        }
        return "Name: " + name + " verfügbare Ware: " + value;
    }
 
}
