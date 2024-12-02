package com.sucinex.sucinexmediaplayer.userinterface;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ventana extends Application {
    private String claseLlamada;

    public String getClaseLlamada(){
        return claseLlamada;
    }

    public void setClaseLlamada(String claseLlamada){
        this.claseLlamada = claseLlamada;
    }

    public Ventana(){
        claseLlamada = "SucinexMediaPlayer";
    }

    public Ventana(String claseLlamada){
        this.claseLlamada = claseLlamada;
    }

    @Override
    public void start(Stage stage) throws ClassNotFoundException {
        //!Creacion de un video
        /*
        Media video = new Media(new File("").toURI().toString());
        MediaPlayer mp = new MediaPlayer(video);
        MediaView mv = new MediaView(mp);
        root.getChildren().add(mv);
        */

        //!Creacion del interior de la ventana
        Scene scene = null;

        switch (claseLlamada) {
            case "SucinexMediaPlayer":
                scene = new Scene(creaInterfazSucinexMediaPlayer(stage, this));
            break;

            case "SucinexImageVisor":
                scene = new Scene(creaInterfazSucinexImageVisor(stage, this));
            break;

            case "SucinexVideoPlayer":
                //scene = creaInterfazSucinexVideoPlayer(stage, this);
            break;

            case "SucinexMusicPlayer":
                //scene = creaInterfazSucinexMusicPlayer(stage, this);
            break;

            default:
                System.out.println("Clase no valida, lanzando excepcion");
                throw new ClassNotFoundException("Clase no valida");
        }

        //!Creacion de la venatana
        stage.getIcons().add(new Image("C:/Users/Sucinex/Pictures/LogoJava.png"));
        stage.setTitle("Sucinex Media Player");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    private ScrollPane creaInterfazSucinexMediaPlayer(Stage stage, Ventana ventana){
        //!Columna principal
        Columna root = new Columna(10);

        //!Creacion del titulo de la aplicacion
        Text text = new Text("Sucinex Media Player");
        text.setFont(new Font(40));
        text.setStyle("-fx-fill: #FFFFFF;");
        text.setId("textoSMeP");
        root.getChildren().add(text);

        //!Creacion del boton de navegacion a Sucinex Image Visor
        Boton botonSucinexImageVisor = new Boton("botonSIV", "Sucinex Image Visor");
        botonSucinexImageVisor.setOnAction(e -> {
            System.out.println("Se ha pulsado el boton " + botonSucinexImageVisor.getText());
            claseLlamada = "SucinexImageVisor";
            stage.getScene().setRoot(creaInterfazSucinexImageVisor(stage, ventana));
        });
        root.getChildren().add(buscaPosicion(root.getChildren(), "textoSMeP") + 1, botonSucinexImageVisor);

        //!Creacion del boton de navegacion a Sucinex Video Player
        Boton botonSucinexVideoPlayer = new Boton("botonSVP", "Sucinex Video Player");
        root.getChildren().add(buscaPosicion(root.getChildren(), "botonSIV") + 1, botonSucinexVideoPlayer);

        //!Creacion del boton de navegacion a Sucinex Music Player
        Boton botonSucinexMusicPlayer = new Boton("botonSMuP","Sucinex Music Player");
        root.getChildren().add(buscaPosicion(root.getChildren(), "botonSVP") + 1, botonSucinexMusicPlayer);

        //!Creacion del boton para poner pantalla completa
        Boton botonPantallaCompleta = new Boton("botonPC", "Pantalla Completa");
        botonPantallaCompleta.setOnAction(e -> {
            stage.setFullScreen(!stage.isFullScreen());
        });
        root.getChildren().add(buscaPosicion(root.getChildren(), "botonSMuP") + 1, botonPantallaCompleta);

        //!Creacion del boton para poner la ventana siempre encima
        Boton botonSiempreEncima = new Boton("botonSE", "Siempre Encima");
        botonSiempreEncima.setOnAction(e -> {
            stage.setAlwaysOnTop(!stage.isAlwaysOnTop());
        });
        root.getChildren().add(buscaPosicion(root.getChildren(), "botonPC") + 1, botonSiempreEncima);
        
        try {
            BotonIcono iconButton = new BotonIcono("botonLogoJava", "C:/Users/Sucinex/Pictures/LogoJava.png", 100);
            iconButton.setMaxSize(100, 100);
            root.getChildren().add(iconButton);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScrollPane columnaScrollable = new ScrollPane();
        columnaScrollable.setContent(root);
        columnaScrollable.setFitToWidth(true);
        columnaScrollable.setFitToHeight(true);

        return columnaScrollable;
    }

    private ScrollPane creaInterfazSucinexImageVisor(Stage stage, Ventana ventana){
        Columna root = new Columna(10);

        //!Creacion del IconButton atras
        try {
            BotonIcono botonIconoAtras = new BotonIcono("botonIconoAtras", "C:/Users/Sucinex/Pictures/Flecha atras clara.png", 30);
            botonIconoAtras.setMaxSize(30, 30);
            botonIconoAtras.setStyle(botonIconoAtras.getStyle() + "-fx-background-radius: 0px; -fx-border-radius: 0px");
            botonIconoAtras.setOnAction(e -> {
                System.out.println("Se ha pulsado el boton " + botonIconoAtras.getId());
                claseLlamada = "SucinexMediaPlayer";
                stage.getScene().setRoot(creaInterfazSucinexMediaPlayer(stage, ventana));
            });
            root.getChildren().add(botonIconoAtras);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //!Creacion de una imagen
        Image image = new Image("C:/Users/Sucinex/Downloads/Imagenes/horario2dam2425.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);
        root.getChildren().add(imageView);

        ScrollPane columnaScrollable = new ScrollPane();
        columnaScrollable.setContent(root);
        columnaScrollable.setFitToWidth(true);
        columnaScrollable.setFitToHeight(true);

        return columnaScrollable;
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
    public void abreVentana() {
        launch(new String[0]);
    }
}
