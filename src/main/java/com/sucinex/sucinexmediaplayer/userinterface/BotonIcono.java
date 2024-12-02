package com.sucinex.sucinexmediaplayer.userinterface;

import java.io.File;
import java.io.IOException;

import javafx.scene.image.ImageView;

public class BotonIcono extends Boton {
    public BotonIcono(String id){
        super(id);
    }

    public BotonIcono(String id, String url) throws IOException{
        super(id);
        File imagenArchivo = new File(url);
        if (!(imagenArchivo.exists() && imagenArchivo.isFile() && (url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".jpeg")))) {
            throw new IOException("URL no valida debido a que el archivo no existe, no es un archivo o no tiene una extension valida(.png / .jpg / .jpeg)");
        }
        this.setGraphic(new ImageView(url));
    }

    public BotonIcono(String id, String url, double tamanyoImagen) throws IOException {
        super(id);
        File imagenArchivo = new File(url);
        if (!(imagenArchivo.exists() && imagenArchivo.isFile() && (url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".jpeg")))) {
            throw new IOException("URL no valida debido a que el archivo no existe, no es un archivo o no tiene una extension valida(.png / .jpg / .jpeg)");
        }
        ImageView imagen = new ImageView(url);
        imagen.setPreserveRatio(true);
        imagen.setFitWidth(tamanyoImagen);
        this.setGraphic(imagen);
    }

    public BotonIcono(String id, ImageView imagen){
        super(id);
        this.setGraphic(imagen);
    }

    public BotonIcono(String id, ImageView imagen, double tamanyoImagen){
        super(id);
        ImageView imagenRedimensionada = new ImageView(imagen.getImage().getUrl());
        imagenRedimensionada.setPreserveRatio(true);
        imagenRedimensionada.setFitWidth(tamanyoImagen);
        this.setGraphic(imagenRedimensionada);
    }
}
