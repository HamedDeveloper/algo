package model;

import service.TradingAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AutomatedTrader implements TradingAlgorithm{

    Lock buildTradeLock = new ReentrantLock();

    Bank bank = new Bank();
    public String[] productNames;
    //TODO Should it be concurrent HashMap
    Map<String, LinkedList<Double>> pricesByProductName = new HashMap<String, LinkedList<Double>>();

    public AutomatedTrader(String[] productsNames) {
        this.productNames = productsNames;
        for (int i = 0; i < productsNames.length; i++) {
            String productsName = productsNames[i];
            pricesByProductName.put(productsName, new LinkedList<Double>());
        }
    }

    public Trade buildTrades(Price newPrice) {
        try {
            buildTradeLock.lock();
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
                    bank.order(newPrice, 1000, Direction.BUY);
                    return new Trade(productName, numericPrice, Direction.BUY, 1000);
                }
            }
        } finally {
            buildTradeLock.unlock();
        }
        return null;
    }


}
