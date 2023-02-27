package Krakination.managers;

import Krakination.messages.GenericMessage;
import org.jetbrains.annotations.NotNull;

public interface MessageListener {
    void onEvent(@NotNull GenericMessage event);
}
