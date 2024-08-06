package tmc.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import tmc.core.exceptions.*;
import tmc.core.goods.*;
import tmc.core.markets.*;
import tmc.core.npc.*;
import tmc.persistence.StorageHandler;

/**
 *
 * @author Luca Kölzsch
 *
 * TODO: - Testen - GUI
 *
 */
public class Game implements Runnable, Serializable {

    private static final long serialVersionUID = 1L;

    //Attribute
    private int ID, level;
    private long turnDelay;
    private double inflationRate, inflationMin, inflationMax;
    private boolean win;

    private int startingCapital;
    private double npcStartingCapital, npcLiquidity;
    private int npcSurcharge, npcPurchaseAttempts, npcResellSize;

    private Market[] markets;
    private Company company;
    private NpcMarket npcMarket;
    private NpcTrader[] npcOffers;

    private Thread gameThread, levelThread;
    private transient StorageHandler storageHandler;

    public Game(int ID) {
        storageHandler = new StorageHandler();
        this.ID = ID;
    }

    //START_WERTE
    private Game initilize() {
        //Attribute

        //Game
        level = 1;
        inflationRate = 0.0;
        inflationMin = 0.0;
        inflationMax = 0.0;
        turnDelay = 10000; //eine Minute: 60000
        win = false;

        //Company
        startingCapital = 2000;

        //NPCs
        npcStartingCapital = 3000;
        npcSurcharge = 20;
        npcPurchaseAttempts = 8;
        npcLiquidity = 1000;
        npcResellSize = 20;

        //Objekte
        company = new Company(0, "Unternahmen 1", startingCapital, 0, 0, 0, 0);
        npcOffers = null;

        //Märkte
        markets = new Market[7];
        markets[0] = new Asian();
        markets[1] = new Russia();
        markets[2] = new Australia();
        markets[3] = new SouthAmarica();
        markets[4] = new NorthAmerica();
        markets[5] = new Africa();
        markets[6] = new Europe();

        npcMarket = new NpcMarket(6);
        for (int i = 0; i < npcMarket.getTrader().length; i++) {
            //ID, Preisuafschlag, Startkapital, Liquidität
            npcMarket.getTrader()[i] = new NpcTrader(i, npcSurcharge, npcStartingCapital, npcLiquidity);
        }
        npcMarket.getTrader()[0].setPriority(new Gold());
        npcMarket.getTrader()[0].setName("Etienne");
        npcMarket.getTrader()[1].setPriority(new Copper());
        npcMarket.getTrader()[1].setName("Luca");
        npcMarket.getTrader()[2].setPriority(new Ceramic());
        npcMarket.getTrader()[2].setName("Ben");
        npcMarket.getTrader()[3].setPriority(new Metal());
        npcMarket.getTrader()[3].setName("Jonathan");
        npcMarket.getTrader()[4].setPriority(new Wood());
        npcMarket.getTrader()[4].setName("El Jefe");
        npcMarket.getTrader()[5].setPriority(new Petrolium());
        npcMarket.getTrader()[5].setName("Danny");

        return this;
    }

    //public Methoden
    public Game load() {
        try {
            return storageHandler.load(ID);
        } catch (IOException | ClassNotFoundException e) {
            return initilize();
        }
    }

    public boolean save() throws FileNotFoundException, IOException {
        storageHandler.save(this);
        return true;
    }

    public boolean buy(Market market, int ID) throws MoneyException {
        for (int i = 0; i < market.getAvailableGoods().length; i++) {
            if (market.getAvailableGoods()[i].getID() == ID) {
                return company.buy(market.getAvailableGoods()[i]);
            }
        }
        return false;
    }

    public boolean sell(Market market, int ID) throws GoodsException {
        for (int i = 0; i < market.getAvailableGoods().length; i++) {
            if (market.getAvailableGoods()[i].getID() == ID) {
                return company.sell(market.getAvailableGoods()[i]);
            }
        }
        return false;
    }

    public boolean buyNpcOffer(int ID) throws MoneyException {
        for (NpcTrader offers : npcOffers) {
            if (offers.getID() == ID) {
                return company.buy(offers.sellOffer());
            }
        }
        return false;
    }

    public void makeOfferToNpc(Goods offer) throws MoneyException, GoodsException {
        if (npcMarket.watch(offer)) {
            company.sell(offer);
        }
    }
    
    public void acceptOfferFromNPC() {
        //TODO
    }

    public void start() {
        gameThread = new Thread(this);
        levelThread = new Thread(() -> {
            hasWon();
            levelUp();
            update();
        });

        gameThread.start();
        levelThread.start();
    }

    //private Methoden
    private void updatePrices() {
        //calculate Price Ranges
        for (Market market : markets) {
            for (Goods g : market.getAvailableGoods()) {
                g.calculatePriceRange(level);
            }
        }
        //generate prices
        for (Market market : markets) {
            market.generatePrices();
        }
    }

    private void timer(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
        }
    }

    private void hasWon() {
        if (win) {
            gameThread = null;
            levelThread = null;
        }
    }

    private void levelUp() {
        switch (level) {
            case 1:
                //Handelsvolumen von mindestens 2000
                if (company.getTradingVolume() >= 2000) {
                    level++;
                }
                break;
            case 2:
                //Mindestens 10 gehandelte Waren und ein Handelsvolumen von mindestens 3000
                if (company.getTradedGoods() >= 10 && company.getTradingVolume() >= 3000) {
                    level++;
                }
                break;
            case 3:
                //Gewinn von mindestens 1000
                if (company.getProfit() >= 1000) {
                    level++;
                }
                break;
            case 4:
                //Gewinn von mindestens 1000 und einen Marktanteil von 10%
                if ((company.getProfit() >= 1000) && (company.getMarketShare(npcMarket.getAllSales(company.getTradingVolume())) >= 10)) {
                    level++;
                }
                break;
            case 5:
                //Handelsvolumen von mindestens 7500 und einen Marktanteil von 15%
                if ((company.getTradingVolume() >= 7500) && (company.getMarketShare(npcMarket.getAllSales(company.getTradingVolume())) >= 15)) {
                    level++;
                }
                break;
            case 6:
                //Gewinn von mindestens 2500 und ein Kupfer im Inventar
                if ((company.getProfit() >= 2500) && (company.getGoods(2) >= 1)) {
                    level++;
                }
                break;
            case 7:
                //Gewinn von mindestens 3500 und einen Marktanteil von 30%
                if ((company.getProfit() >= 3500) && (company.getMarketShare(npcMarket.getAllSales(company.getTradingVolume())) >= 30)) {
                    level++;
                }
                break;
            case 8:
                //Gewinn von mindestens 5000 und ein Handelsvolumen von mindestens 15000
                if ((company.getProfit() >= 5000) && (company.getTradingVolume() >= 15000)) {
                    level++;
                }
                break;
            case 9:
                //50% Marktanteil und 2 Gold im Inventar
                if ((company.getMarketShare(npcMarket.getAllSales(company.getTradingVolume())) >= 50) && (company.getGoods(1) >= 2)) {
                    level++;
                }
                break;
            case 10:
                //Monopol
                if (npcMarket.isMonopol()) {
                    win = true;
                }
                break;
        }
    }

    private void doInflation() {
        switch (level) {
            case 1:
                inflationMax = 0.0;
                inflationMax = 0.0;
                break;
            case 2:
                inflationMax = 0.0;
                inflationMax = 0.0;
                break;
            case 3:
                inflationMax = 0.0;
                inflationMax = 0.0;
                break;
            case 4:
                inflationMax = -2;
                inflationMax = 5;
                break;
            case 5:
                inflationMax = -2;
                inflationMax = 5;
                break;
            case 6:
                inflationMax = -2;
                inflationMax = 5;
                break;
            case 7:
                inflationMax = -2;
                inflationMax = 5;
                break;
            case 8:
                inflationMax = -2;
                inflationMax = 7;
                break;
            case 9:
                inflationMax = -2;
                inflationMax = 7;
                break;
            case 10:
                inflationMax = -2;
                inflationMax = 7;
                break;
        }

        inflationRate = generateDouble(inflationMin, inflationMax);

        for (Market market : markets) {
            for (Goods g : market.getAvailableGoods()) {
                g.doInflation(inflationRate);
            }
        }
    }

    private void doNpcTrade() {
        try {
            npcMarket.trade();
        } catch (GoodsException | MoneyException e) {
        }
    }

    private void doNpcPurchase(int count) {
        for (int i = 0; i < count; i++) {
            try {
                npcMarket.buyGoods(markets);
            } catch (MoneyException e) {
            }
        }

    }
    
    

    private void doNpcOffers() {
        try {
            npcOffers = npcMarket.makeOffers();
        } catch (GoodsException ex) {
        }
    }

    private void doNpc(int count, int size) {
        npcMarket.resellGoods(size);
        doNpcPurchase(count);
        doNpcTrade();
        doNpcTrade();
        doNpcOffers();
    }

    private void update() {
        npcMarket.updateTrader();
        company.update();
    }

    private double generateDouble(double min, double max) {
        Random rand = new Random();
        return Math.round((min + (max - min) * rand.nextDouble()) * 100.0) / 100.0;
    }

    @Override
    public void run() {
        //Game Loop
        while (gameThread != null) {
            //Anzahl Warenkauf, Größe des Lagers um resell auszulösen
            doNpc(npcPurchaseAttempts, npcResellSize);
            doInflation();
            updatePrices();
            update();
            System.out.println("Spiel: " + toString());
            timer(turnDelay);
            
            
            //Spielmanipulation zum Testen
            /*
            level = 5;
            System.out.println("Unternehmen vor Kauf von Ware: " + company.toString());
            try {
                //Asian, Plastik
                buy(markets[0], 9);
            } catch (MoneyException ex) {
            }
            System.out.println("Unternehmen nach Kauf von Ware und vor Verkauf: " + company.toString());
            try {
                company.getWarehouse().get(0).setPrice(1);
                makeOfferToNpc(company.getWarehouse().get(0));
            } catch (MoneyException ex) {
            } catch (GoodsException ex) {
            }
            System.out.println("Unternehmen nach Verkauf der Ware: " + company.toString()); */
        }
    }

    //getter und setter
    public Company getCompany() {
        return company;
    }

    public Thread getGameLoop() {
        return gameThread;
    }

    public int getID() {
        return ID;
    }

    public Market[] getMarkets() {
        return markets;
    }

    public int getLevel() {
        return level;
    }
    

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setGameLoop(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMarkets(Market[] markets) {
        this.markets = markets;
    }

    @Override
    public String toString() {
        String value = "";
        for (Market market : markets) {
            value += market.toString() + "\n";
        }

        return "Unternehmen: " + company.toString() + "\n\nMärkte: " + value + "\n\nNpc Markt: " + npcMarket.toString(company.getTradingVolume()) + "\n\nAttribute: \nLevel: " + level + " Inflationsrate: " + inflationRate;
    }

}
