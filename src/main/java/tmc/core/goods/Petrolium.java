package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Petrolium extends Goods {
    
    public Petrolium() {
        super(3, "Petrolium");
        this.setBasePrice(750);
        this.setImagePath(basePath + "petrolium.png");
    }    
}
