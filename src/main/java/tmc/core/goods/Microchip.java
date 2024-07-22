package tmc.core.goods;

/**
 *
 * @author Luca Kölzsch
 */
public class Microchip extends Goods {

    public Microchip() {
        super(0, "Microchip");
        this.setBasePrice(10000);
        this.setImagePath(basePath + "microchip.png");
    }
}
