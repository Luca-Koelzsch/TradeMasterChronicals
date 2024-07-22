package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Plastic extends Goods {
    public Plastic() {
        super(9, "Plastic");
        this.setBasePrice(10);
        this.setImagePath(basePath + "plastic.png");
    }
}
