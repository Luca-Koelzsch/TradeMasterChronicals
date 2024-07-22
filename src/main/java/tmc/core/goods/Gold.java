package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Gold extends Goods {
    
    public Gold() {
        super(1, "Gold");
        this.setBasePrice(2500);
        this.setImagePath(basePath + "gold.png");
    }
    
}
