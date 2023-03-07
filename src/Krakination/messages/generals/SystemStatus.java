package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;

public class SystemStatus extends GenericMessage {
    private BigInteger ConnectionID;
    private String Event;
    private String Status;
    private String Version;

    public SystemStatus(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);

        if (rawData.has("connectionID")) {
            try {
                ConnectionID = rawData.getBigInteger("connectionID");
            } catch (JSONException e) {
                System.out.println("ConnectionID was " + rawData.get("connectionID") + ", compensating with default value");
                ConnectionID = new BigInteger("0");
            }
        }

        Event = rawData.getString("event");

        //Add enum for this: online|maintenance|cancel_only|limit_only|post_only
        Status = rawData.getString("status");
        Version = rawData.getString("version");
    }

    public BigInteger getConnectionID() {
        return ConnectionID;
    }

    @NotNull
    public String getEvent() {
        return this.Event;
    }

    @NotNull
    public String getStatus() {
        return this.Status;
    }

    @NotNull
    public String getVersion() {
        return this.Version;
    }
}
