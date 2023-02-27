package Krakination.managers;

import Krakination.messages.GenericMessage;
import Krakination.messages.generals.*;
import Krakination.messages.publics.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

import java.util.EventListener;

public abstract class ListenerAdapter implements MessageListener {
    public void onGenericMessage(GenericMessage message) {};
    public void onHeartbeat(Heartbeat message) {};
    //public void onPing(Ping message) {};
    //public void onPong(Pong message) {};
    public void onSystemStatus(SystemStatus message) {};
    public void onSubscriptionStatus(SubscriptionStatus message) {};
    public void onBook(Book message) {};
    public void onTicker(Ticker message) {};
    public void onTrade(Trade message) {};
    public void onOHLC(OHLC message) {};
    public void onSpread(Spread message) {};

    @Override
    public final void onEvent(@NotNull GenericMessage message)
    {
        onGenericMessage(message);

        String methodName = message.getClass().getSimpleName();
        switch (methodName) {
            case "Heartbeat":
                onHeartbeat((Heartbeat) message);
                break;
            case "SystemStatus":
                onSystemStatus((SystemStatus) message);
                break;
            case "SubscriptionStatus":
                onSubscriptionStatus((SubscriptionStatus) message);
                break;
            case "Book":
                onBook((Book) message);
                break;
            case "Ticker":
                onTicker((Ticker) message);
                break;
            case "Trade":
                onTrade((Trade) message);
                break;
            case "OHLC":
                onOHLC((OHLC) message);
                break;
            case "Spread":
                onSpread((Spread) message);
                break;
            default:
                System.out.println("UNKNOWN: " + methodName);
                break;
        }
    }
}
