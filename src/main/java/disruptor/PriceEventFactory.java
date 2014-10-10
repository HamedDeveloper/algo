package disruptor;

/**
 * Created by fati on 10/10/14.
 */

import com.lmax.disruptor.EventFactory;

public class PriceEventFactory implements EventFactory<PriceEvent> {

    public PriceEvent newInstance() {
        return new PriceEvent();
    }
}


