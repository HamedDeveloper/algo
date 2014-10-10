package disruptor;

import model.Price;

/**
 * Created by fati on 10/10/14.
 */
public class PriceEvent {

    private Price price;

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
