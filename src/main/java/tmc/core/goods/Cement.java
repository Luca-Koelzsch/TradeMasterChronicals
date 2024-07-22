package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Cement extends Goods {
    public Cement() {
        super(8, "Cement");
        this.setBasePrice(25);
        this.setImagePath(basePath + "cement.png");
    }
}
