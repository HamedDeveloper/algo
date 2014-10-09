package model;

import java.util.Random;

/**
 * Created by fati on 10/8/14.
 */
public class MarketDataProvider {

    public String[] productNames;
    public AutomatedTrader autoTrader;

    public MarketDataProvider(String[] productNames) {
        this.productNames = productNames;
    }

    public Price generatePrice(){

        Random random = new Random();
        String productName = productNames[random.nextInt(productNames.length)];
        Product product = new Product(productName);

        double numericPrice = random.nextDouble()*100;
        return new Price(product, numericPrice);
    }

    public void sendPrices(){
        autoTrader = new AutomatedTrader(productNames);
        for (int i = 0; i < 1000; i++) {
            Price price = generatePrice();
            Trade trade = autoTrader.buildTrades(price);
        }
    }
}
