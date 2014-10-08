package service;

import model.Price;
import model.Trade;

/**
 * Created by fati on 10/8/14.
 */
public interface TradingAlgorithm {
    /**
     }
     * Builds a trade to be executed based on the supplied prices. * @param price data
     * @return trade to execute
     */
    Trade buildTrades(Price price);


}
