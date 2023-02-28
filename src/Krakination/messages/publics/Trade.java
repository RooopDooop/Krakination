package Krakination.messages.publics;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONArray;
import org.json.JSONObject;

public class Trade extends GenericMessage {
        String ChannelName;
        String Pair;
        String Price;
        String Volume;
        String Time;
        String BuyOrSell;
        String OrderType;
        String Miscellaneous;

    public Trade(JSONArray rawData, KrakinationClient api, String ChannelName, String Pair) {
        super(rawData, api);

        if (rawData.getString(3).equals("b")) {
            BuyOrSell = "Buy";
        } else if (rawData.getString(3).equals("s")) {
            BuyOrSell = "Sell";
        } else {
            BuyOrSell = "UNKNOWN";
        }

        if (rawData.getString(4).equals("m")) {
            OrderType = "Market";
        } else if (rawData.getString(4).equals("l")) {
            OrderType = "Limit";
        } else {
            OrderType = "UNKNOWN";
        }

        this.ChannelName = ChannelName;
        this.Pair = Pair;
        Price = rawData.getString(0);
        Volume = rawData.getString(1);
        Time = rawData.getString(2);
        Miscellaneous = rawData.getString(5);
    }

    public String getChannelName() {
        return ChannelName;
    }
    public String getPair() {
        return Pair;
    }
    public String getPrice() {
        return Price;
    }
    public String getVolume() {
        return Volume;
    }
    public String getTime() {
        return Time;
    }
    public String getBuyOrSell() {
        return BuyOrSell;
    }
    public String getOrderType() {
        return OrderType;
    }
    public String getMiscellaneous() {
        return Miscellaneous;
    }
}