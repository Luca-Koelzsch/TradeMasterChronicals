package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class Russia extends Market {
    public Russia() {
        super(1, "Russia");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Petrolium();
        availableGoods[1] = new Copper();
        availableGoods[2] = new Wood();
    }
}
