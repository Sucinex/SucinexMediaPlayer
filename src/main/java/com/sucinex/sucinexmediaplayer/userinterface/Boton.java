package com.sucinex.sucinexmediaplayer.userinterface;

import javafx.scene.control.Button;

public class Boton extends Button {
    public Boton(){
        super();
        setStyle(
            "-fx-background-color: #404040;" + 
            "-fx-text-fill: #FFFFFF;" +        
            "-fx-font-size: 16px;" +           
            "-fx-padding: 10px;" +             
            "-fx-background-radius: 50px;" + 
            "-fx-border: 2px;" + 
            "-fx-border-color: #FFFFFF;" +
            "-fx-border-radius: 50px;"    
        );
    }

    public Boton(String texto){
        super(texto);
        setStyle(
            "-fx-background-color: #404040;" + 
            "-fx-text-fill: #FFFFFF;" +        
            "-fx-font-size: 16px;" +           
            "-fx-padding: 10px;" +             
            "-fx-background-radius: 50px;" + 
            "-fx-border: 2px;" + 
            "-fx-border-color: #FFFFFF;" +
            "-fx-border-radius: 50px;" +
            "-fx-font-family: 'Consolas';" 
        );
    }
}
