package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Glass extends Goods {
    public Glass() {
        super(5, "Glass");
        this.setBasePrice(400);
        this.setImagePath(basePath + "glass.png");
    } 
}
