package Krakination;

import Krakination.managers.MessageManager;
import Krakination.messages.GenericMessage;
import Krakination.net.SocketClient;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;
import java.util.List;

public class KrakClientImpl implements KrakinationClient {
    SocketClient websocketClient;
    MessageManager msgManager = new MessageManager();
    List<String> TargetPairs;

    public KrakClientImpl(List<String> TargetPairs) {
        this.TargetPairs = TargetPairs;
        try {
            websocketClient = new SocketClient(this);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        websocketClient.connect();
    }

    public void handleWebsocketClose(int i, String s, boolean b) {
        if (i == -1 || i == 1006 || b) {
            try {
                System.out.println("Websocket lost connection to Kraken, reconnecting...");
                this.websocketClient = new SocketClient(this);
                websocketClient.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("Connection closed: " + i + " - " + s + " - " + b);
    }

    public void handleWebsocketError(Exception e) {
        e.printStackTrace();
        this.websocketClient.close();
    }

    @Override
    public SocketClient getWebsocketClient() {
        return websocketClient;
    }

    @Override
    public List<String> getTargetPairs() {
        return TargetPairs;
    }

    @Override
    public void addEventListener(@NotNull Object... listeners)
    {
        for (Object listener: listeners)
            msgManager.register(listener);
    }

    public void handleEvent(@NotNull GenericMessage message)
    {
        msgManager.handle(message);
    }
}
