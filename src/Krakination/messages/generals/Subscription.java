package Krakination.messages.generals;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Subscription {
    private String event = "subscribe";
    private int ClientID;
    private List<String> Pairs;
    private HashMap<String, Object> subParams = new HashMap<>();

    //Convert target to enum
    public Subscription(List<String> Pairs, String Target) {
        this.Pairs = Pairs;
        subParams.put("name", Target);
    }

    public Subscription(int ClientID, List<String> Pairs, String Target) {
        this.ClientID = ClientID;
        this.Pairs = Pairs;
        subParams.put("name", Target);
    }

    public List<String> getPairs() {
        return this.Pairs;
    }

    public JSONObject outputJSON() {
        JSONObject returnJSON = new JSONObject()
                .put("event", this.event)
                .put("subscription", this.subParams);

        if (ClientID != 0) {
            returnJSON.put("reqid", this.ClientID);
        }

        if (Pairs != null) {
            returnJSON.put("pair", this.Pairs);
        }

        return returnJSON;
    }
}
