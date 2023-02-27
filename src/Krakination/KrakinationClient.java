package Krakination;

import Krakination.net.SocketClient;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface KrakinationClient {
    SocketClient getWebsocketClient();
    List<String> getTargetPairs();

    void addEventListener(@NotNull Object... listeners);
}