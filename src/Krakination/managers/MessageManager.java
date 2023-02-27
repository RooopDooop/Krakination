package Krakination.managers;

import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageManager implements IMessageManager {
    private final ArrayList<MessageListener> listeners = new ArrayList<>();

    @Override
    public void register(@NotNull Object listener) {
        if (!(listener instanceof MessageListener)) {
            throw new IllegalArgumentException("Listener must implement MessageListener");
        }

        listeners.add((MessageListener) listener);
    }

    @Override
    public void unregister(@NotNull Object listener) {
        if (!(listener instanceof EventListener))
        {
            //noinspection ConstantConditions
            System.out.println("Trying to remove a listener that does not implement EventListener: {}" + (listener == null ? "null" : listener.getClass().getName()));
        }

        //noinspection SuspiciousMethodCalls
        listeners.remove(listener);
    }

    @Override
    public void handle(@NotNull GenericMessage message) {
        for (MessageListener listener : listeners)
        {
            try
            {
                listener.onEvent(message);
            }
            catch (Throwable throwable)
            {
                //JDAImpl.LOG.error("One of the EventListeners had an uncaught exception", throwable);
                if (throwable instanceof Error)
                    throw (Error) throwable;
            }
        }
    }

    @Override
    public @NotNull List<Object> getRegisteredListeners() {
        return new ArrayList<>(listeners);
    }
}