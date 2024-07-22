package tmc.core;

import java.io.Serializable;
import java.util.ArrayList;
import tmc.core.exceptions.*;
import tmc.core.goods.Goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    //Attribute
    private int ID, tradedGoods;
    private String name;
    private double money, tradingVolume, profit, sales;
    private ArrayList<Goods> warehouse;

    public Company(int ID, String name, double money, double tradingVolume, int tradedGoods, double profit, double sales) {
        this.ID = ID;
        this.name = name;
        this.money = money;
        this.tradingVolume = tradingVolume;
        this.tradedGoods = tradedGoods;
        this.profit = profit;
        this.sales = sales;
        this.warehouse = new ArrayList<>();
    }

    public Company(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.warehouse = new ArrayList<>();
    }

    //Methoden
    public boolean buy(Goods goods) throws MoneyException {
        if (money >= goods.getPrice()) {
            money -= goods.getPrice();
            warehouse.add(goods);
            //Erhöhung des Trading Volumes
            tradingVolume += goods.getPrice();
            //Manipulation des Gewinnes
            profit -= goods.getPrice();
            return true;

        } else {
            throw new MoneyException();
        }
    }

    public boolean sell(Goods goods) throws GoodsException {
        for (Goods g : warehouse) {
            if (goods.getID() == g.getID()) {
                warehouse.remove(goods);
                money += goods.getPrice();
                //Erhöhung des Trading Volumes
                tradingVolume += goods.getPrice();
                tradedGoods++;
                //Manipulation des Gewinnes
                profit += goods.getPrice();
                sales += goods.getPrice();
                return true;
            }
        }
        throw new GoodsException();
    }

    public int getGoods(int ID) {
        int count = 0;
        for (Goods goods : warehouse) {
            if (goods.getID() == ID) {
                count++;
            }
        }
        return count;
    }
    
    public double getMarketShare(double allSales) {
        return Math.round((sales / allSales * 100) * 100.0) / 100.0;
    }
    
    public void update() {
        money = roundDouble(money);
        tradingVolume = roundDouble(tradingVolume);
        sales = roundDouble(sales);
    }
    
    private double roundDouble(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    //getter und setter
    public int getID() {
        return ID;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public int getTradedGoods() {
        return tradedGoods;
    }

    public double getProfit() {
        return profit;
    }

    public double getSales() {
        return sales;
    }

    public ArrayList<Goods> getWarehouse() {
        return warehouse;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String value = "";
        for (Goods goods : warehouse) {
            value += goods.toString() + "\n";
        }
        return "Name: " + name + " Geld: " + money + " Handelsvolumen: " + tradingVolume + " Verkäufe: " + sales + " Ware: " + value;
    }
    
}
