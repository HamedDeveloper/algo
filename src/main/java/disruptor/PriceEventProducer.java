package disruptor;

import com.lmax.disruptor.RingBuffer;
import model.Price;

public class PriceEventProducer
{
    private final RingBuffer<PriceEvent> ringBuffer;

    public PriceEventProducer(RingBuffer<PriceEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void onData(Price price)
    {
        long sequence = ringBuffer.next();
        try {
            PriceEvent event = ringBuffer.get(sequence);
            event.setPrice(price);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

