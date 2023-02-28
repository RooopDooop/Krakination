package Krakination.messages.publics;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Book extends GenericMessage {
    String ChannelName;
    int Depth;
    String Pair;
    String Checksum;
    List<BookProperties> AskBook = new ArrayList<>();
    List<BookProperties> BidBook = new ArrayList<>();
    public Book(JSONArray rawData, KrakinationClient api) {
        super(rawData, api);

        try {
            String[] arr_split = rawData.getString(2).split("-");
            Depth = Integer.parseInt(arr_split[1]);
            ChannelName = arr_split[0];
        } catch (JSONException e) {
            String[] arr_split = rawData.getString(3).split("-");
            Depth = Integer.parseInt(arr_split[1]);
            ChannelName = arr_split[0];
        }

        Pair = rawData.getString(3);
        JSONObject rawMsgData = rawData.getJSONObject(1);

        if (rawMsgData.has("c")) {
            Checksum = rawMsgData.getString("c");
            if (rawMsgData.has("a")) {
                JSONArray askArr = rawMsgData.getJSONArray("a");

                for (int w = 0; w < askArr.length(); w++) {
                    JSONArray bookProperties = askArr.getJSONArray(w);

                    AskBook.add(new BookProperties(
                            bookProperties.getString(0),
                            bookProperties.getString(1),
                            bookProperties.getString(2)
                    ));
                }
            }
            if (rawMsgData.has("b")) {
                JSONArray bidArr = rawMsgData.getJSONArray("b");

                for (int z = 0; z < bidArr.length(); z++) {
                    JSONArray bookProperties = bidArr.getJSONArray(z);

                    BidBook.add(new BookProperties(
                            bookProperties.getString(0),
                            bookProperties.getString(1),
                            bookProperties.getString(2)
                    ));
                }
            }
        } else {
            if (rawMsgData.has("as")) {
                JSONArray askArr = rawMsgData.getJSONArray("as");

                for (int x = 0; x < askArr.length(); x++) {
                    JSONArray bookProperties = askArr.getJSONArray(x);

                    AskBook.add(new BookProperties(
                            bookProperties.getString(0),
                            bookProperties.getString(1),
                            bookProperties.getString(2)
                    ));
                }
            }
            if (rawMsgData.has("bs")) {
                JSONArray bidArr = rawMsgData.getJSONArray("bs");

                for (int a = 0; a < bidArr.length(); a++) {
                    JSONArray bookProperties = bidArr.getJSONArray(a);

                    BidBook.add(new BookProperties(
                            bookProperties.getString(0),
                            bookProperties.getString(1),
                            bookProperties.getString(2)
                    ));
                }
            }
        }
    }

    public String getChannelName() { return ChannelName; }

    public String getPair() {
        return Pair;
    }

    public int getDepth() { return Depth; }

    public String getChecksum() { return Checksum; };

    public List<BookProperties> getAskBook() {
        return AskBook;
    }

    public List<BookProperties> getBidBook() {
        return BidBook;
    };
}

