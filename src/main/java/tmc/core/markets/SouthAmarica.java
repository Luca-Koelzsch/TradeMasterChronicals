package tmc.core.markets;

import tmc.core.goods.*;

/**
 *
 * @author Luca Kölzsch
 */
public class SouthAmarica extends Market {
    
    public SouthAmarica() {
        super(3, "South Amarica");
        this.availableGoods = new Goods[3];
        availableGoods[0] = new Cement();
        availableGoods[1] = new Petrolium();
        availableGoods[2] = new Metal();
    } 
    
}
