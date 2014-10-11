package model;

public class Price {

    private double numericalPrice;
    private Product product;


    public Price(Product product, double numericalPrice) {
        this.numericalPrice = numericalPrice;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public double getNumericalPrice() {
        return numericalPrice;
    }

    public void setNumericalPrice(double numericalPrice) {
        this.numericalPrice = numericalPrice;
    }
}
