package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Wood extends Goods {
    public Wood() {
        super(7, "Wood");
        this.setBasePrice(100);
        this.setImagePath(basePath + "wood.png");
    }
}
