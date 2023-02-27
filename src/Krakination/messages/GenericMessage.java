package Krakination.messages;

import Krakination.KrakinationClient;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;

public abstract class GenericMessage {
    protected KrakinationClient api;
    protected Object rawData;

    public GenericMessage(JSONObject rawData, KrakinationClient api) {
        this.rawData = rawData;
        this.api = api;
    }

    public GenericMessage(JSONArray rawData, KrakinationClient api) {
        this.rawData = rawData;
        this.api = api;
    }

    @NotNull
    protected KrakinationClient getKrakClient() {
        return api;
    };

    @NotNull
    public Object getRawData() {
        return rawData;
    }
}
