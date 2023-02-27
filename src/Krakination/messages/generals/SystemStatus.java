package Krakination.messages.generals;

import Krakination.KrakinationClient;
import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class SystemStatus extends GenericMessage {
    private int ConnectionID;
    private String Event;
    private String Status;
    private String Version;

    public SystemStatus(JSONObject rawData, KrakinationClient api) {
        super(rawData, api);

        if (rawData.has("connectionID")) {
            ConnectionID = rawData.getInt("connectionID");
        }

        Event = rawData.getString("event");

        //Add enum for this: online|maintenance|cancel_only|limit_only|post_only
        Status = rawData.getString("status");
        Version = rawData.getString("version");

    }

    @Nullable
    public Integer getConnectionID() {
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
