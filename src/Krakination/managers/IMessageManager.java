package Krakination.managers;

import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IMessageManager {
    void register(@NotNull Object listener);
    void unregister(@NotNull Object listener);
    void handle(@NotNull GenericMessage message);

    @NotNull
    List<Object> getRegisteredListeners();
}
