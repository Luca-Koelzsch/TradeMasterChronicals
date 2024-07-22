package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Metal extends Goods {
    public Metal() {
        super(4, "Metal");
        this.setBasePrice(500);
        this.setImagePath(basePath + "metal.png");
    } 
}
