package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class Australia extends Market {
    public Australia() {
        super(2, "Australia");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Gold();
        availableGoods[1] = new Copper();
        availableGoods[2] = new Metal();
    }
}
