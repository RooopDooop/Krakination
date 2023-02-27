package Krakination;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KrakinationBuilder {
    protected final List<Object> listeners = new LinkedList<>();
    protected List<String> TargetPairs;

    public KrakinationBuilder(List<String> TargetPairs) {
        this.TargetPairs = TargetPairs;
    }

    @NotNull
    public KrakinationBuilder addEventListeners(@NotNull Object... listeners)
    {
        Collections.addAll(this.listeners, listeners);
        return this;
    }

    @NotNull
    public KrakinationBuilder removeEventListeners(@NotNull Object... listeners)
    {
        this.listeners.removeAll(Arrays.asList(listeners));
        return this;
    }

    @NotNull
    public KrakClientImpl build()
    {
        KrakClientImpl krakClient = new KrakClientImpl(TargetPairs);

        //if (eventManager != null)
            //krakClient.setEventManager(eventManager);

        listeners.forEach(krakClient::addEventListener);
        return krakClient;
    }
}
