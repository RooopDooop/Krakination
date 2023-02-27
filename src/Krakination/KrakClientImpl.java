package Krakination;

import Krakination.KrakinationClient;
import Krakination.managers.MessageManager;
import Krakination.messages.GenericMessage;
import Krakination.messages.generals.Subscription;
import Krakination.net.SocketClient;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class KrakClientImpl implements KrakinationClient {
    SocketClient websocketClient;
    MessageManager msgManager = new MessageManager();
    List<String> TargetPairs = new ArrayList<>();

    public KrakClientImpl(List<String> TargetPairs) {
        this.TargetPairs = TargetPairs;
        try {
            websocketClient = new SocketClient(this);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        websocketClient.connect();
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
