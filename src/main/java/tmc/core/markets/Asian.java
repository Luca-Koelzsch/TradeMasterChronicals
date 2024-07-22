package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class Asian extends Market {

    public Asian() {
        super(0, "Asian");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Microchip();
        availableGoods[1] = new Ceramic();
        availableGoods[2] = new Plastic();
    }
    
}
