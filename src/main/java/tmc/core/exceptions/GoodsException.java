package tmc.core.exceptions;

/**
 *
 * @author Luca Kölzsch
 */
public class GoodsException extends Exception {

    public GoodsException() {
        super("the item is not available");
    }

    public GoodsException(String msg) {
        super(msg);
    }
}
