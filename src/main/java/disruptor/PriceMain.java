package disruptor;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.RingBuffer;
import model.Price;
import model.Product;
import service.Utils;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

        for (int l = 0; l<1000; l++)
        {
            Price price = generatePrice();
            producer.onData(price);
            Thread.sleep(10);
        }
    }

    //TODO Use MarketDataProvider Method
    public static Price generatePrice(){

        Random random = new Random();
        String productName = Utils.productNames[random.nextInt(Utils.productNames.length)];
        Product product = new Product(productName);

        double numericPrice = random.nextDouble()*100;
        return new Price(product, numericPrice);
    }

}


