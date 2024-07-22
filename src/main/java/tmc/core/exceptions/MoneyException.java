package tmc.core.exceptions;

/**
 *
 * @author Luca Kölzsch
 */
public class MoneyException extends Exception {


    public MoneyException() {
        super("not enough money!");
    }

    public MoneyException(String msg) {
        super(msg);
    }
}
