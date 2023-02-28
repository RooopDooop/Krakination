package Krakination.messages.publics;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONArray;

public class Spread extends GenericMessage {
    String ChannelName;
    String Pair;
    String BidPrice;
    String AskPrice;
    String Time;
    String BidVolume;
    String AskVolume;

    public Spread(JSONArray rawData, KrakinationClient api, String ChannelName, String Pair) {
        super(rawData, api);

        JSONArray SpreadProperties = rawData.getJSONArray(1);

        this.ChannelName = ChannelName;
        this.Pair = Pair;
        this.BidPrice = SpreadProperties.getString(0);
        this.AskPrice = SpreadProperties.getString(1);
        this.Time = SpreadProperties.getString(2);
        this.BidVolume = SpreadProperties.getString(3);
        this.AskVolume = SpreadProperties.getString(4);
    }

    public String getChannelName() {
        return ChannelName;
    };
    public String getPair() {
        return Pair;
    }
    public String getBidPrice() {
        return BidPrice;
    };
    public String getAskPrice() {
        return AskPrice;
    };
    public String getTime() {
        return Time;
    };
    public String getBidVolume() {
        return BidVolume;
    };
    public String getAskVolume() {
        return AskVolume;
    };
}
