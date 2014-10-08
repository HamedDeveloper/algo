package model;

/**
 * Created by fati on 10/8/14.
 */
public class Trade {

    private Product product;
    private double numericPrice;
    private Direction direction;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getNumericPrice() {
        return numericPrice;
    }

    public void setNumericPrice(double numericPrice) {
        this.numericPrice = numericPrice;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getNotional() {

        return notional;
    }

    public void setNotional(int notional) {
        this.notional = notional;
    }

    private int notional;
}
