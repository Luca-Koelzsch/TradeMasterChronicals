package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Copper extends Goods {
    
    public Copper() {
        super(2, "Copper");
        this.setBasePrice(1000);
        this.setImagePath(basePath + "copper.png");
    }
}
