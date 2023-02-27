package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONObject;

public class SubscriptionStatus extends GenericMessage {
    private String ChannelName;
    private String Event;
    private int RequiredID;
    private String Pair;
    private String Status;
    private int Depth;
    private int Interval;
    private int MaxRateCount;
    private String Name;
    private String Token;
    private String ChannelID;

    public SubscriptionStatus(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);

        this.ChannelName = rawData.getString("channelName");
        this.Event = rawData.getString("event");

        if (rawData.has("reqid")) {
            this.RequiredID = rawData.getInt("reqid");
        }

        if (rawData.has("pair")) {
            this.Pair = rawData.getString("pair");
        }

        this.Status = rawData.getString("status");

        JSONObject rawSubs = rawData.getJSONObject("subscription");
        this.Name = rawSubs.getString("name");

        if (rawSubs.has("depth")) {
            this.Depth = rawSubs.getInt("depth");
        }

        if (rawSubs.has("interval")) {
            this.Interval = rawSubs.getInt("interval");
        }

        if (rawSubs.has("maxratecount")) {
            this.MaxRateCount = rawSubs.getInt("maxratecount");
        }

        if (rawSubs.has("token")) {
            this.Token = rawSubs.getString("token");
        }

        if (rawSubs.has("channelID")) {
            this.ChannelID  = rawSubs.getString("channelID");
        }
    }
}
