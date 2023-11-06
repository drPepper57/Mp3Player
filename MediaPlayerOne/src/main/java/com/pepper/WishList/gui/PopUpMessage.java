package com.pepper.WishList.gui;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class PopUpMessage extends Popup
{
    private Timer timer;
    
    public PopUpMessage(String message, Pane parent)
    {
        Label msg = new Label(message);
        msg.setStyle("-fx-background-color: transparent; -fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill:  rgb(50, 50, 75);");
        
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: transparent; -fx-border-width: 2px; -fx-border-color: rgb(50, 50, 75); -fx-pref-height: 33; -fx-alignment: center;");
        vbox.getChildren().add(msg);
        
        Scene popupScene = new Scene(vbox, 200, 50);     
        popupScene.fillProperty();
        Stage popupStage = new Stage();
        
        
        popupStage.initStyle(StageStyle.UNDECORATED);
        popupStage.initStyle(StageStyle.TRANSPARENT);
        popupStage.setScene(popupScene);        
        popupStage.show();
        
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2.8), vbox);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            popupStage.close();
            popupScene.setFill(Color.TRANSPARENT); // Set the root's opacity to 0
        });
        fadeOut.play();
        
        timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                Platform.runLater(() -> {
                    popupStage.close();
                    if(timer != null){
                        timer.cancel();
                        timer = null;
                    }
                });
            }
        }, 1500);
    }

}
