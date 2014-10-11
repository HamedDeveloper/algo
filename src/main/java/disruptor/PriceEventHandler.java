package disruptor;

import com.lmax.disruptor.EventHandler;
import model.Bank;
import model.Trade;
import service.Utils;


public class PriceEventHandler implements EventHandler<PriceEvent> {

    Bank bank = new Bank();

    AutomatedLmaxTrader lmaxTrader = new AutomatedLmaxTrader(Utils.productNames);

    public void onEvent(PriceEvent event, long sequence, boolean endOfBatch) {

        System.out.println("Product: " + event.getPrice().getProduct());
        System.out.println("Price: " + event.getPrice().getNumericalPrice());
        Trade trade = lmaxTrader.buildTrades(event.getPrice());
        if (trade != null){
            bank.order(trade);
        }
    }
}

