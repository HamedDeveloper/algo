package disruptor;

import com.lmax.disruptor.EventHandler;

public class PriceEventHandler implements EventHandler<PriceEvent> {

    public void onEvent(PriceEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Product: " + event.getPrice().getProduct());
        System.out.println("Price: " + event.getPrice().getNumericalPrice());
        System.out.println("");
    }
}

