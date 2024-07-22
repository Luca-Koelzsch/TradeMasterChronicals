package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class Europe extends Market {
    public Europe() {
        super(6, "Europe");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Glass();
        availableGoods[1] = new Ceramic();
        availableGoods[2] = new Plastic();
    } 
}
