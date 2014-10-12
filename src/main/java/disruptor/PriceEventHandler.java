package disruptor;

import com.lmax.disruptor.EventHandler;
import model.Bank;
import model.Direction;
import model.Price;
import model.Trade;
import service.TradingAlgorithm;
import service.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PriceEventHandler implements TradingAlgorithm, EventHandler<PriceEvent> {

    Bank bank = new Bank();
    Map<String, LinkedList<Double>> pricesByProductName = new ConcurrentHashMap<String, LinkedList<Double>>();

    @Override
    public Trade buildTrades(Price newPrice) {

        String productName = newPrice.getProduct().getName();
        double numericPrice = newPrice.getNumericalPrice();
        List<Double> prices = pricesByProductName.get(productName);
        if (prices == null){
            prices = new LinkedList<Double>();
        }
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

    public void onEvent(PriceEvent event, long sequence, boolean endOfBatch) {

        System.out.println("Product: " + event.getPrice().getProduct());
        System.out.println("Price: " + event.getPrice().getNumericalPrice());
        Trade trade = buildTrades(event.getPrice());
        if (trade != null){
            bank.order(trade);
        }
    }
}

