package tmc.core.npc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import tmc.core.exceptions.GoodsException;
import tmc.core.exceptions.MoneyException;
import tmc.core.goods.*;
import tmc.core.markets.Market;

/**
 *
 * @author Luca Kölzsch
 */
public class NpcMarket implements Serializable {

    private static final long serialVersionUID = 1L;
    
    NpcTrader[] trader;
    Random random;

    public NpcMarket(int size) {
        random = new Random();
        trader = new NpcTrader[size];   
    }

    public double getAllSales(double companyVolume) {
        double sales = 0;
        for (NpcTrader npcTrader : trader) {
            sales += npcTrader.getSales();
        }
        sales += companyVolume;
        return sales;
    }
    
    public boolean isMonopol() {
        boolean[] bankrupt = new boolean[trader.length];
        for (int i = 0; i < trader.length; i++) {
            bankrupt[i] = trader[i].isBankrupt();
        }
        
        for (boolean b : bankrupt) {
            if (!b) {
                return false;
            }
        }    
        return true;     
    }
    
    public void trade() throws GoodsException, MoneyException {
        int[] indices = generateIndices();
      /*pairTrading(trader[indices[0]], trader[indices[1]]);
        pairTrading(trader[indices[2]], trader[indices[3]]);
        pairTrading(trader[indices[4]], trader[indices[5]]); */
        for (int i = 0; i < trader.length-1; i++) {
            pairTrading(trader[indices[i]], trader[indices[i+1]]);
        }
    }
    
    public void resellGoods(int size) {
        for (NpcTrader npcTrader : trader) {
            if (npcTrader.getWarehouse().size() >= size) {
               npcTrader.resellGoods(); 
            }  
        }
    }
    
    public void buyGoods(Market[] markets) throws MoneyException {
        for (NpcTrader npcTrader : trader) {
            npcTrader.buyGoods(markets);
        }
    }
    
    public NpcTrader[] makeOffers() throws GoodsException {
        NpcTrader[] offers = new NpcTrader[trader.length];
        for (int i = 0; i < offers.length; i++) {
           trader[i].makeOffer();
        }
        return offers;
    }
    
    public void updateTrader() {
        List<NpcTrader> activeTraders = new ArrayList<>();
        
        for (NpcTrader t : trader) {
            if (t != null && !t.isBankrupt()) {
                activeTraders.add(t);
            }
        }        
        trader = activeTraders.toArray(NpcTrader[]::new);
        
        for (NpcTrader npcTrader : trader) {
            npcTrader.round();
        }
    }
    
    //private Methoden
    private void pairTrading(NpcTrader first, NpcTrader second) throws GoodsException, MoneyException {
        Goods firstOffer = first.makeOffer();
        Goods secondOffer = second.makeOffer();
        
        if (first.acceptOffer(secondOffer)) {
            first.buyOffer(second.sellOffer());
        }
        if (second.acceptOffer(firstOffer)) {
            second.buyOffer(first.sellOffer());
        }
    }
    
    private int[] generateIndices() {
        List<Integer> indicesList = new ArrayList<>();
        for (int i = 0; i < trader.length; i++) {
            indicesList.add(i);
        }
        Collections.shuffle(indicesList);
        int[] indices = new int[trader.length];
        for (int i = 0; i < indicesList.size(); i++) {
            indices[i] = indicesList.get(i);
        }
        return indices;
    }
    
    public boolean watch(Goods offer) throws MoneyException {
        int[] indices = generateIndices();
        for (int i = 0; i < trader.length; i++) {
            if (trader[indices[i]].acceptOffer(offer)) {
                trader[indices[i]].buyOffer(offer);
                return true;
            }
        }
        return false;
    }
    
    //Getter und Setter
    public NpcTrader[] getTrader() {
        return trader;
    }
    
    public String toString(double volume) {
        String value = "";
        for (NpcTrader npcTrader : trader) {
            double marketshare = npcTrader.getMarketShare(getAllSales(volume));
            value += npcTrader.toString() + " Marktanteil: " + marketshare + "\n";
        }
        return value;
    }
}
