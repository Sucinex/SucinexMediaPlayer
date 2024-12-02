package com.sucinex.sucinexmediaplayer.userinterface;

import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class Columna extends VBox {
    public Columna(double espaciado){
        setSpacing(espaciado);
        setAlignment(Pos.TOP_LEFT);
        setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Paint.valueOf("#808080"), null, null)}));
        setStyle(    
            "-fx-background-color: #202020;" + 
            "-fx-padding: 10px;"
        );
    }
}
