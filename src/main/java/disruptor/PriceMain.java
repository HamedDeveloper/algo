package disruptor;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.RingBuffer;
import model.Price;
import service.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import model.MarketDataProvider;

public class PriceMain
{
    public static void main(String[] args) throws Exception
    {
        Executor executor = Executors.newCachedThreadPool();
        PriceEventFactory factory = new PriceEventFactory();
        int bufferSize = 1024;
        Disruptor<PriceEvent> disruptor = new Disruptor<>(factory, bufferSize, executor);
        disruptor.handleEventsWith(new PriceEventHandler());
        disruptor.start();

        RingBuffer<PriceEvent> ringBuffer = disruptor.getRingBuffer();
        PriceEventProducer producer = new PriceEventProducer(ringBuffer);

        MarketDataProvider provider = new MarketDataProvider(Utils.productNames);

        for (int l = 0; l<1000; l++)
        {
            Price price = provider.generatePrice();
            producer.onData(price);
           // Thread.sleep(10);
        }
    }

}


