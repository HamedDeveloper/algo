package model;

public class Trade {

    private String productName;
    private double numericPrice;
    private Direction direction;

    public Trade(String productName, double numericPrice, Direction direction, int notional) {
        this.productName = productName;
        this.numericPrice = numericPrice;
        this.direction = direction;
        this.notional = notional;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
