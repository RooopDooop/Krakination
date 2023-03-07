package Krakination.net;

import Krakination.KrakClientImpl;
import Krakination.messages.generals.Heartbeat;
import Krakination.messages.generals.Subscription;
import Krakination.messages.generals.SubscriptionStatus;
import Krakination.messages.generals.SystemStatus;
import Krakination.messages.publics.*;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SocketClient extends WebSocketClient {
    SystemStatus latestSystemStatus;
    KrakClientImpl api;
    List<SubscriptionStatus> Subscriptions = new ArrayList<>();

    public SocketClient(KrakClientImpl api) throws URISyntaxException {
        super(new URI("wss://ws.kraken.com"));
        this.api = api;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connection established with Kraken");
    }

    @Override
    public void onMessage(String s) {
        if (!String.valueOf(s.charAt(0)).equals("[")) {
            handleMessage(new JSONObject(s));
        } else {
            handleMessage(new JSONArray(s));
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        this.api.handleWebsocketClose(i, s, b);
    }

    @Override
    public void onError(Exception e) {
        this.api.handleWebsocketError(e);
    }

    private void handleMessage(JSONObject data) {
        //System.out.println(data);

        switch (data.getString("event")) {
            case "systemStatus" -> {
                latestSystemStatus = new SystemStatus(data, api);
                this.api.handleEvent(latestSystemStatus);

                Subscription sub = new Subscription(api.getTargetPairs(), "*");
                this.send(sub.outputJSON().toString());

                //this.send(new Subscription(this.TargetPairs, "*").getJSON().toString());
                //this.send(new Subscription(this.TargetPairs, "ohlc").getJSON().toString());
                //this.send(new Subscription(this.TargetPairs, "book").getJSON().toString());
                //this.send(new Subscription(this.TargetPairs, "trade").getJSON().toString());
                //this.send(new Subscription(this.TargetPairs, "spread").getJSON().toString());

                //|openOrders|ownTrades|*, *
            }
            case "heartbeat" -> {
                this.api.handleEvent(new Heartbeat(data, api));
            }
            case "subscriptionStatus" -> {
                SubscriptionStatus subStatus = new SubscriptionStatus(data, api);
                Subscriptions.add(subStatus);
                this.api.handleEvent(subStatus);
            }
            default -> System.out.println("MISSING EVENT: " + data.getString("event"));
        }
    }


    private void handleMessage(JSONArray data) {
        String[] splitMessageName;

        try {
            splitMessageName = data.getString(2).split("-");
        } catch (JSONException e) {
            splitMessageName = data.getString(3).split("-");
        }

        switch(splitMessageName[0]) {
            case "ticker" -> this.api.handleEvent(new Ticker(data, api));
            case "book" -> this.api.handleEvent(new Book(data, api));
            case "ohlc" -> this.api.handleEvent(new OHLC(data, api, splitMessageName[0], splitMessageName[1]));
            case "trade" -> {
                JSONArray Trades = data.getJSONArray(1);
                for (int k = 0; k < Trades.length(); k++) {
                    this.api.handleEvent(new Trade(Trades.getJSONArray(k), api, data.getString(2), data.getString(3)));
                }
            }
            case "spread" -> this.api.handleEvent(new Spread(data, api, data.getString(2), data.getString(3)));
            default -> System.out.println("UNKNOWN: " + splitMessageName[0]);
        }
    }
}