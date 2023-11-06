package com.pepper.mediaplayerone;

import javafx.event.Event;
import javafx.event.EventType;


public class DoubleClickEvent extends Event
{
    public static final EventType<DoubleClickEvent> DoubleClickEvent =
            new EventType<>(Event.ANY, "MEDIA_FILE_CLICKED");

    public DoubleClickEvent(Object source) {
        super(source, null, DoubleClickEvent);
    }
}
