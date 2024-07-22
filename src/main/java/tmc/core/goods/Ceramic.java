package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Ceramic extends Goods {
    public Ceramic() {
        super(6, "Ceramic");
        this.setBasePrice(200);
        this.setImagePath(basePath + "ceramic.png");
    }
}
