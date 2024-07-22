package tmc.core.npc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import tmc.core.exceptions.GoodsException;
import tmc.core.exceptions.MoneyException;
import tmc.core.goods.Goods;
import tmc.core.markets.Market;

/**
 *
 * @author Luca Kölzsch
 */
public class NpcTrader implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //Attribute
    private int ID;
    private String name;
    private double sales;
    private double money, liquidity;
    private int maxSurcharge, offerIndex;
    
    
    //Obejkte
    private ArrayList<Goods> warehouse;
    private Goods offer, priority;
    Random random;

      
    public NpcTrader(int ID, int maxSurcharge, double money, double liquidity) {
        random = new Random();
        sales = 0;
        offer = null;
        offerIndex = -1;
        priority = null;
        warehouse = new ArrayList<>();
        
        this.ID = ID;
        this.maxSurcharge = maxSurcharge;
        this.money = money;
        this.liquidity = liquidity;
    }
    
    public Goods makeOffer() throws GoodsException {
        if (warehouse.isEmpty()) {
            throw new GoodsException();
        }
        int surcharge = random.nextInt(this.maxSurcharge) + 1;      
        int index = random.nextInt(warehouse.size());
        Goods good = warehouse.get(index);
        good.setPrice(good.getBasePrice() + (surcharge * good.getBasePrice() / 100));
        this.offerIndex = index;
        this.offer = good;
        return good;
    }
    
    public Goods sellOffer() {
        money += offer.getPrice();
        sales += offer.getPrice();
        warehouse.remove(offerIndex);
        offerIndex = -1;
        Goods tempOffer = offer;
        offer = null;
        return tempOffer;
    }
    
    public void buyOffer(Goods offer) throws MoneyException {
        double useableMoney = money - liquidity;
        if (useableMoney < offer.getPrice()) {
            throw new MoneyException();
        }
        money -= offer.getPrice();
        warehouse.add(offer);
    }
    
    public boolean acceptOffer(Goods offer) {
        int surcharge = random.nextInt(this.maxSurcharge) + 1;
        surcharge /= 2;
        double acceptablePrice = offer.getBasePrice() + (offer.getBasePrice() * surcharge / 100);
        
        if (acceptablePrice >= offer.getPrice()) {
            return true;
        } else {
            if (offer.getID() == priority.getID()) {
                acceptablePrice = offer.getBasePrice() + (offer.getBasePrice() * maxSurcharge / 100);
                if (acceptablePrice >= offer.getPrice()) {
                    return true;
                }
            }          
            return false;
        }
    }
    
    public void buyGoods(Market[] markets) throws MoneyException {
        int market = random.nextInt(markets.length);
        int goods = random.nextInt(markets[market].getAvailableGoods().length);
        Goods good = markets[market].getAvailableGoods()[goods];
        
        double useableMoney = money - liquidity;
        
        //NPC Trader kaufen zum Basispreis
        if (useableMoney < good.getBasePrice()) {
            throw new MoneyException();
        }
        
        money -= good.getBasePrice();
        warehouse.add(good);
    }
    
    public void resellGoods() {
        int count = warehouse.size() / 2;
        Collections.shuffle(warehouse);
        for (int i = 0; i < count; i++) {
            double price = roundDouble(warehouse.get(i).getBasePrice() / 2);
            money += price;
            warehouse.remove(i);
        }
    }
    
    public void round() {
        money = roundDouble(money);
        sales = roundDouble(sales);
    }
    
    private double roundDouble(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
    
    //Getter und Setter
    public double getMarketShare(double allSales) {
        return Math.round((sales / allSales * 100) * 100.0) / 100.0;
    }

    public double getSales() {
        return sales;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Goods> getWarehouse() {
        return warehouse;
    }
    

    public boolean isBankrupt() {
        return money <= liquidity && warehouse.isEmpty();
    }

    public void setPriority(Goods priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        String value = "";
        for (Goods goods : warehouse) {
            value += goods.getName() + " ";
        }
        return "Name: " + name + " Geld: " + money + " Verkäufe: " + sales + " Ware: " + value;
    }
    
}
