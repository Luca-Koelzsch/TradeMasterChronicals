package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class Africa extends Market {
    public Africa() {
        super(5, "Africa");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Gold();
        availableGoods[1] = new Copper();
        availableGoods[2] = new Petrolium();
    } 
}
