package com.pepper.WishList.gui;

import com.pepper.mediaplayerone.DoubleClickEvent;
import com.pepper.mediaplayerone.PrimaryController;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AddLabel extends Label
{   
    private int index;
    private String mediaSource;
    private final long DOUBLE_CLICK_TIME = 300_000_000;
    private long lastClickTime = 0;
    private List<EventHandler<DoubleClickEvent>> mediaFileAddedListeners = new ArrayList<>();
    
    public AddLabel(String labelText, Pane parent, String ms, int index) 
    {
        super();
        this.setText(labelText);
        this.setTextFill(Color.WHITE);
        this.setStyle("-fx-font-weight: bold; -fx-font-size: 12;");
        parent.getChildren().add(this);
        
        this.index = index;
        this.mediaSource = ms;
        
        this.setOnMouseClicked(e -> {
            long currentTime = System.nanoTime();
            if (currentTime - lastClickTime <= DOUBLE_CLICK_TIME) {
                PrimaryController.currentIndex = index;
                DoubleClickEvent event = new DoubleClickEvent(this);
                fireEvent(event);
            }
            lastClickTime = currentTime;
            
        });
        this.setOnMouseEntered(e -> {
            this.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: rgb(43,45,66); "); //-fx-background-color:  rgb(50,50,75);
        });

        this.setOnMouseExited(e -> {
            this.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: rgb(250,250,250);");
        });
        
    }
    public void addMediaFileClickedListener(EventHandler<DoubleClickEvent> listener) {
        addEventHandler(DoubleClickEvent.DoubleClickEvent, listener);
    }
}
