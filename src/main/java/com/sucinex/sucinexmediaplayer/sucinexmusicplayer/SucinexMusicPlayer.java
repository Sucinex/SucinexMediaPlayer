package com.sucinex.sucinexmediaplayer.sucinexmusicplayer;

import static com.sucinex.sucinexmediaplayer.SucinexMediaPlayer.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1.0.0
 * @author Sucinex
 */
public class SucinexMusicPlayer {
    
    public static void main(String args[]) {
        boolean salir = false;
        int opcion = 0;
        
        do{
            System.out.println("Sucinex Music Player");
            System.out.println("====================");
            
            switch (opcion){
                case 1 -> {
                    
                }
                
                case 50 -> {
                    salir = pideBoolean("¿Seguro que desea salir?");
                }
                
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
            
        } while (!salir);
        
    }
    
    private static void guardaDatos(){
        try{
            Class.forName("com.mysql.cj.jdbc.DriverManager");
            Connection conexion = DriverManager.getConnection("","","");
            
            conexion.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
