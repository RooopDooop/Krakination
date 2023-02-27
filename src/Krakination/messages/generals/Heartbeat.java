package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class Heartbeat extends GenericMessage {
    public Heartbeat(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);
    }

    @Override
    protected @NotNull KrakinationClient getKrakClient() {
        return api;
    }
}
