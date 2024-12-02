package com.sucinex.sucinexmediaplayer.userinterface;

import javafx.scene.control.Button;

public class Boton extends Button {
    /**
     * Crea un boton con el siguiente estilo:
     * "-fx-background-color: #404040;"
     * "-fx-text-fill: #FFFFFF;"        
     * "-fx-font-size: 16px;"          
     * "-fx-padding: 10px;"             
     * "-fx-background-radius: 50px;" 
     * "-fx-border: 2px;" 
     * "-fx-border-color: #FFFFFF;"
     * "-fx-border-radius: 50px;" 
     */
    public Boton(String id){
        super();
        setId(id);
        setOnAction(e -> {
            System.out.println("Se ha pulsado el boton " + id);
        });
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

    /**
     * Crea un boton con el texto pasado por parametro y el siguiente estilo:
     * "-fx-background-color: #404040;"
     * "-fx-text-fill: #FFFFFF;"        
     * "-fx-font-size: 16px;"          
     * "-fx-padding: 10px;"             
     * "-fx-background-radius: 50px;" 
     * "-fx-border: 2px;" 
     * "-fx-border-color: #FFFFFF;"
     * "-fx-border-radius: 50px;" 
     * @param texto Es el texto que va a tener el boton
     */
    public Boton(String id, String texto){
        super(texto);
        setId(id);
        setOnAction(e -> {
            System.out.println("Se ha pulsado el boton " + id);
        });
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
}
