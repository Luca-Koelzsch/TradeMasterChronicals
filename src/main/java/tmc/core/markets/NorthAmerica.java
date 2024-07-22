package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class NorthAmerica extends Market {
    public NorthAmerica() {
        super(4, "North America");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Wood();
        availableGoods[1] = new Glass();
        availableGoods[2] = new Cement();
    } 
}
