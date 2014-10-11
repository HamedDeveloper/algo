import model.MarketDataProvider;
import service.Utils;

public class ExecClass {
    public static void main(String[] args) {
        System.out.print("\n");
        MarketDataProvider provider = new MarketDataProvider(Utils.productNames);
        provider.sendPrices();

        for (int i = 0; i < provider.productNames.length; i++) {
            System.out.println(provider.productNames[i]);
        }
    }
}
