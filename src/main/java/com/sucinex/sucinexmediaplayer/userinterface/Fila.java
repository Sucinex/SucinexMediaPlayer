package com.sucinex.sucinexmediaplayer.userinterface;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Fila extends HBox {
    public Fila(double espaciado){
        setSpacing(espaciado);
        setAlignment(Pos.TOP_LEFT);
        setStyle(
            "-fx-padding: 10px;"
        );
    }
}
