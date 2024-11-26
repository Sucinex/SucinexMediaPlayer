package com.sucinex.sucinexmediaplayer.userinterface;

import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
        //!Columna principal
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);
        root.setStyle(    
            "-fx-background-color: #202020;" + 
            "-fx-padding: 10px;"
        );

        //!Creacion del titulo de la aplicacion
        Text text = new Text("Sucinex Media Player");
        text.setFont(new Font(40));
        text.setStyle("-fx-fill: #FFFFFF;");
        text.setId("textoSMP");
        root.getChildren().add(text);

        //!Creacion de una imagen
        Image image = new Image("C:/Users/Sucinex/Downloads/Imagenes/horario2dam2425.jpg");
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);

        //!Creacion del boton de navegacion a Sucinex Image Player
        Boton botonSucinexImagePlayer = new Boton("Sucinex Image Player");
        botonSucinexImagePlayer.setId("botonSIP");
        botonSucinexImagePlayer.setOnAction(e -> {
            System.out.println("Se ha pulsado el boton " + botonSucinexImagePlayer.getText());
        });
        root.getChildren().add(buscaPosicion(root.getChildren(), "textoSMP") + 1, botonSucinexImagePlayer);

        //!Creacion del boton para poner pantalla completa
        Boton botonPantallaCompleta = new Boton("Pantalla Completa");
        botonPantallaCompleta.setOnAction(e -> {
            stage.setFullScreen(!stage.isFullScreen());
        });
        root.getChildren().add(buscaPosicion(root.getChildren(), "botonSIP") + 1, botonPantallaCompleta);

        //!Creacion del interior de la ventana
        Scene scene = new Scene(root, 400, 300);

        //!Creacion de la venatana
        stage.setTitle("Sucinex Media Player");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    /**
     * Esta funcion busca la posicion del id en la lista de nodos pasada por parametro
     * @param lista Es la lista donde se tiene que buscar la posicion del ID
     * @param id Es el ID a buscar en la lista
     * @return Devuelve la posicion del ID en la lista
     */
    public static int buscaPosicion(List<Node> lista, String id){
        int posicion = 0;

        for (int i = 0; i < lista.size(); i++) {
            Node nodo = lista.get(i);
            if (nodo.getId() != null && nodo.getId().equals(id)) {
                posicion = i;
            }
        }

        return posicion;
    }

    /**
     * Esta funcion inicia la ventana creada
     * @param args Son los argumentos
     */
    public void abreVentana(String[] args) {
        launch(args);
    }
}
