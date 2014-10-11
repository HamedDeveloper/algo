package disruptor;

import model.Direction;
import model.Price;
import model.Trade;
import service.TradingAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AutomatedLmaxTrader implements TradingAlgorithm {

    public String[] productNames;
    Map<String, LinkedList<Double>> pricesByProductName = new ConcurrentHashMap<String, LinkedList<Double>>();

    public AutomatedLmaxTrader(String[] productsNames) {
        this.productNames = productsNames;
        for (int i = 0; i < productsNames.length; i++) {
            String productsName = productsNames[i];
            pricesByProductName.put(productsName, new LinkedList<Double>());
        }
    }

    @Override
    public Trade buildTrades(Price newPrice) {

        String productName = newPrice.getProduct().getName();
        double numericPrice = newPrice.getNumericalPrice();
        List<Double> prices = pricesByProductName.get(productName);
        prices.add(numericPrice);
        int size = prices.size();
        if (size >= 4) {
            double sum = 0;
            for (int i = size - 4; i < size; i++) {
                sum += prices.get(i);
            }
            double avg = sum / 4;
            if (numericPrice > avg) {

                return new Trade(productName, numericPrice, Direction.BUY, 1000);
            }
        }
        return null;
    }
}
