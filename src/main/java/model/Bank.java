package model;

/**
 * Created by fati on 10/8/14.
 */
public class Bank {

    private static int count;

    public void order(Price newPrice, int notional, Direction direction) {
        count++;
        System.out.println(newPrice.getProduct().getName() + "," + direction.toString() + "," +
                newPrice.getNumericalPrice() + "," + notional + " ==> " + count);
    }
}
