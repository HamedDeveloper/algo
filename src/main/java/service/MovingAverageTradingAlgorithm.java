package service;

import model.Price;
import model.Product;
import model.Trade;

/**
 * Created by fati on 10/8/14.
 */
public class MovingAverageTradingAlgorithm implements TradingAlgorithm {

    public String[] productNames;
    public Product[] products;

    public MovingAverageTradingAlgorithm(String[] productsNames) {
        this.productNames = productsNames;
    }

    @Override
    public Trade buildTrades(Price price) {
        return null;
    }

    public void setProducts(String[] productNames){
        int length = productNames.length;
        products = new Product[length];
        for (int i = 0; i < productNames.length; i++) {
            String productName = productNames[i];
            Product product = new Product(productName);
            products[i] = product;
        }
    }
}
