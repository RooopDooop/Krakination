
import Krakination.KrakClientImpl;
import Krakination.KrakinationBuilder;
import Krakination.managers.ListenerAdapter;
import Krakination.messages.GenericMessage;
import Krakination.messages.generals.Heartbeat;
import Krakination.messages.generals.SubscriptionStatus;
import Krakination.messages.generals.SystemStatus;
import Krakination.messages.publics.*;

import java.util.List;

public class example extends ListenerAdapter {
    public static void main(String[] args) {
        KrakinationBuilder builder = new KrakinationBuilder(List.of(
                "DOT/USD",
                "1INCH/EUR",
                "1INCH/USD",
                "AAVE/ETH",
                "AAVE/EUR",
                "AAVE/GBP",
                "AAVE/USD",
                "AAVE/XBT",
                "ACA/EUR",
                "ACA/USD"
        ));

        builder.addEventListeners(new example());

        KrakClientImpl krak = builder.build();
    }

    @Override
    public void onGenericMessage(GenericMessage message) {
        //System.out.println("Main Message: " + message);
    }

    @Override
    public void onHeartbeat(Heartbeat message) {
        System.out.println(message);
    }

    @Override
    public void onSystemStatus(SystemStatus message) {
        System.out.println(message);
    }

    @Override
    public void onSubscriptionStatus(SubscriptionStatus message) {
        System.out.println(message);
    }

    @Override
    public void onBook(Book message) {
        System.out.println(message);
    }

    @Override
    public void onTicker(Ticker message) {
        System.out.println(message);
    }

    @Override
    public void onTrade(Trade message) {
        System.out.println(message);
    }
    @Override
    public void onOHLC(OHLC message) {
        System.out.println(message);
    }

    @Override
    public void onSpread(Spread message) {
        System.out.println(message);
    }
}
