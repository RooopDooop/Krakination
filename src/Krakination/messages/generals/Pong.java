package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONObject;

public class Pong extends GenericMessage {
    public Pong(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);
    }
}
