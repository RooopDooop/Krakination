package Krakination.messages.publics;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.json.JSONArray;

public class OHLC extends GenericMessage {
    String ChannelName;
    String Pair;
    int Interval;
    String LastUpdate;
    String EndTimeInterval;
    String OpenPriceInterval;
    String HighPriceInterval;
    String LowPriceInterval;
    String ClosePriceInterval;
    String VolumeWeightedInterval;
    String AccumulatedVolumeInterval;
    int TradesWithinInterval;


    public OHLC(JSONArray rawData, KrakinationClient api, String ChannelName, String Interval) {
        super(rawData, api);
        JSONArray ohlcProperties = rawData.getJSONArray(1);

        this.ChannelName = ChannelName;
        Pair = rawData.getString(3);
        this.Interval = Integer.parseInt(Interval);
        LastUpdate = ohlcProperties.getString(0);
        EndTimeInterval = ohlcProperties.getString(1);
        OpenPriceInterval = ohlcProperties.getString(2);
        HighPriceInterval = ohlcProperties.getString(3);
        LowPriceInterval = ohlcProperties.getString(4);
        ClosePriceInterval = ohlcProperties.getString(5);
        VolumeWeightedInterval = ohlcProperties.getString(6);
        AccumulatedVolumeInterval = ohlcProperties.getString(7);
        TradesWithinInterval = ohlcProperties.getInt(8);
    }

    public String getChannelName() {
        return ChannelName;
    }
    public String getPair() {
        return Pair;
    }
    public int getInterval() {
        return Interval;
    }
    public String getLastUpdate() {
        return LastUpdate;
    }
    public String getEndTimeInterval() {
        return EndTimeInterval;
    }
    public String getOpenPriceInterval() {
        return OpenPriceInterval;
    }
    public String getHighPriceInterval() {
        return HighPriceInterval;
    }
    public String getLowPriceInterval() {
        return LowPriceInterval;
    }
    public String getClosePriceInterval() {
        return ClosePriceInterval;
    }
    public String getVolumeWeightedInterval() {
        return VolumeWeightedInterval;
    }
    public String getAccumulatedVolumeInterval() {
        return AccumulatedVolumeInterval;
    }
    public int getTradesWithinInterval() {
        return TradesWithinInterval;
    }
}

