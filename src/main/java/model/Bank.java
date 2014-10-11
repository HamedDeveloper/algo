package model;

public class Bank {

    private static int count;

    public void order(Price newPrice, int notional, Direction direction) {
        count++;
        System.out.println(newPrice.getProduct().getName() + "," + direction.toString() + "," +
                newPrice.getNumericalPrice() + "," + notional + " ==> " + count);
    }

    public void order(Trade trade) {
        count++;
        System.out.println(trade.getProductName() + "," + trade.getDirection().toString() + "," +
                trade.getNumericPrice() + "," + trade.getNotional() + " ==> " + count);
    }
}
