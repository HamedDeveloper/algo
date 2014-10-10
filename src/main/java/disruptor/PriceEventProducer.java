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
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            PriceEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.setPrice(price);  // Fill with data
        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}

