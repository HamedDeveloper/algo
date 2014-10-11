package disruptor;

import model.Price;

public class PriceEvent {

    private Price price;

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
