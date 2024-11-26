package com.sucinex.sucinexmediaplayer;

import com.sucinex.sucinexmediaplayer.sucinexmusicplayer.SucinexMusicPlayer;
import com.sucinex.sucinexmediaplayer.userinterface.Ventana;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @author Sucinex
 */
public class SucinexMediaPlayer {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) {
        Ventana ventana = new Ventana();
        ventana.abreVentana(args);

        int opcion = 0;
        boolean salir = false;
        
        do{
            opcion = pideInt(true, 1, false, 0, "Selecciona una opcion");
            
           switch (opcion){
               case 1 -> {
                   //SucinexImageVisor.main();
                   System.out.println("Hola");
                }
               case 2 -> {
                   //SucinexVideoPlayer.main();
                   System.out.println("Hola");
                }
               case 3 -> {
                   SucinexMusicPlayer.main(args);
                   System.out.println("Hola");
                }
               case 4 -> {
                   salir = pideBoolean("¿Seguro que desea salir?");
                }
               default -> {
                   System.out.println("Opcion no valida");
                }
           } 
        } while (!salir);
    }
    
    /**
     * Esta funcion imprime un mensaje y pide un respuesta SI/NO
     * @param mensaje Es el mensaje que se tiene que imprimir
     * @return Devuelve el resultado dado por el usuario
     */
    public static boolean pideBoolean(String mensaje){
        boolean valor = true;
        String aux = "";
        boolean salir = false;
        
        do{
            System.out.print(mensaje + "\n>");
            aux = sc.nextLine();
            
            if (aux.equalsIgnoreCase("SI")){
                valor = true;
                salir = true;
            }
            else{
                if (aux.equalsIgnoreCase("NO")){
                    valor = false;
                    salir = true;
                }
                else{
                    System.out.println("Respuesta no comprendida, introduzca 'SI' o 'NO'.");
                    System.out.println();
                }
            }
        } while (!salir);
        
        return valor;
    }
    
    public static int pideInt(boolean setMinimo, int minimo, boolean setMaximo, int maximo, String mensaje){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int num = 0;
        
        if (setMinimo){
            min = minimo;
        }
        if (setMaximo){
            max = maximo;
        }
        
        do {
            try{
                System.out.print(mensaje + "\n>");
                num = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                sc.nextLine();
            }
        } while (min>num || num>max);
        
        return num;
    }
}
