package Krakination.messages.publics;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONArray;
import org.json.JSONObject;

public class Ticker extends GenericMessage {
    String ChannelName;
    String Pair;
    String AskBestPrice;
    int AskWholeLotVolume;
    String AskLotVolume;
    String BidBestPrice;
    int BidWholeLotVolume;
    String BidLotVolume;
    String ClosePrice;
    String CloseLotVolume;
    String TodayVolume;
    String Last24HourVolume;
    String TodayWeightedVolume;
    String Last24HourWeightedVolume;
    int TodayTrades;
    int TodayLast24Hours;
    String TodayLowPrice;
    String Last24HoursLowPrice;
    String TodayHighPrice;
    String Last24HoursHighPrice;
    String TodayOpenPrice;
    String Last24HoursOpenPrice;

    public Ticker(JSONArray rawData, KrakinationClient api) {
        super(rawData, api);

        JSONObject arr_data = rawData.getJSONObject(1);

        JSONArray Ask = arr_data.getJSONArray("a");
        JSONArray Bid = arr_data.getJSONArray("b");
        JSONArray Close = arr_data.getJSONArray("c");
        JSONArray Volume = arr_data.getJSONArray("v");
        JSONArray WeightedVolume = arr_data.getJSONArray("p");
        JSONArray TradeCount = arr_data.getJSONArray("t");
        JSONArray Low = arr_data.getJSONArray("l");
        JSONArray High = arr_data.getJSONArray("h");
        JSONArray Open = arr_data.getJSONArray("o");

        ChannelName = rawData.getString(2);
        Pair = rawData.getString(3);
        AskBestPrice = Ask.getString(0);
        AskWholeLotVolume = Ask.getInt(1);
        AskLotVolume = Ask.getString(2);
        BidBestPrice = Bid.getString(0);
        BidWholeLotVolume = Bid.getInt(1);
        BidLotVolume = Bid.getString(2);
        ClosePrice = Close.getString(0);
        CloseLotVolume = Close.getString(1);
        TodayVolume = Volume.getString(0);
        Last24HourVolume = Volume.getString(1);
        TodayWeightedVolume = WeightedVolume.getString(0);
        Last24HourWeightedVolume = WeightedVolume.getString(1);
        TodayTrades = TradeCount.getInt(0);
        TodayLast24Hours = TradeCount.getInt(1);
        TodayLowPrice = Low.getString(0);
        Last24HoursLowPrice = Low.getString(1);
        TodayHighPrice = High.getString(0);
        Last24HoursHighPrice = High.getString(1);
        TodayOpenPrice = Open.getString(0);
        Last24HoursOpenPrice = Open.getString(1);
    }

    public String getChannelName() {
        return ChannelName;
    }
    public String getPair() {
        return Pair;
    }
    public String getAskBestPrice() {
        return AskBestPrice;
    }
    public int getAskWholeLotVolume() { return AskWholeLotVolume; }
    public String getAskLotVolume() { return AskLotVolume; }
    public String getBidBestPrice() { return BidBestPrice; }
    public int getBidWholeLotVolume() { return BidWholeLotVolume; }
    public String getBidLotVolume() { return BidLotVolume; }
    public String getClosePrice() { return ClosePrice; }
    public String getCloseLotVolume() { return CloseLotVolume; }
    public String getTodayVolume() {
        return TodayVolume;
    }
    public String getLast24HourVolume() {
        return Last24HourVolume;
    }
    public String getTodayWeightedVolume() {
        return TodayWeightedVolume;
    }
    public String getLast24HourWeightedVolume() {
        return Last24HourWeightedVolume;
    }
    public int getTodayTrades() {
        return TodayTrades;
    }
    public int getTodayLast24Hours() { return TodayLast24Hours; }
    public String getTodayLowPrice() { return TodayLowPrice; }
    public String getLast24HoursLowPrice() { return Last24HoursLowPrice; }
    public String getTodayHighPrice() { return TodayHighPrice; }
    public String getLast24HoursHighPrice() { return Last24HoursHighPrice; }
    public String getTodayOpenPrice() { return TodayOpenPrice; }
    public String getLast24HoursOpenPrice() { return Last24HoursOpenPrice; }
}
