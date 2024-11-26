package com.sucinex.sucinexmediaplayer.userinterface;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ventana extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);
        root.setStyle(    
            "-fx-background-color: #202020;" + 
            "-fx-padding: 10px;"
        );

        Text text = new Text("Sucinex Media Player");
        text.setFont(new Font(40));
        text.setStyle("-fx-fill: #FFFFFF;");
        root.getChildren().add(text);

        Image image = new Image("C:/Users/Sucinex/Downloads/Imagenes/horario2dam2425.jpg");
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);

        Boton botonSucinexImagePlayer = new Boton("Sucinex Image Player");
        botonSucinexImagePlayer.setOnAction(e -> {
            System.out.println("Se ha pulsado el boton " + botonSucinexImagePlayer.getText());
        });
        root.getChildren().add(botonSucinexImagePlayer);

        Boton botonPantallaCompleta = new Boton("Pantalla Completa");
        botonPantallaCompleta.setOnAction(e -> {
            stage.setFullScreen(!stage.isFullScreen());
        });
        root.getChildren().add(botonPantallaCompleta);

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Sucinex Media Player");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    public void abreVentana(String[] args) {
        launch(args);
    }
}
