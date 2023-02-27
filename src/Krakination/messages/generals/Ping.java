package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONObject;

public class Ping extends GenericMessage {
    public Ping(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);
    }
}
