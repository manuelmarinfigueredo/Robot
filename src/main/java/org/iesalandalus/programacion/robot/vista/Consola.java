package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){}

    public static void mostrarMenuPrincipal(){
        System.out.println("Menú principal.");
        System.out.println("1. Controlar un robot por defecto.");
        System.out.println("2. Controlar un robot indicando su zona.");
        System.out.println("3. Controlar un robot indicando su zona y orientación.");
        System.out.println("4. Controlar un robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5. Ejecutar comando.");
        System.out.println("0. Salir.");
    }

    public static int elegirOpcion(){
        int opcion = -1;
        do {
            mostrarMenuPrincipal();
            System.out.println("Elige una opción del menú:");
            opcion = Entrada.entero();
        }while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public static Zona elegirZona(){
        Zona zona = null;
        do{
            System.out.println("Dime el alto:");
            int alto = Entrada.entero();
            System.out.println("Dime el ancho:");
            int ancho = Entrada.entero();
            try{
                zona = new Zona(ancho, alto);
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(zona == null);
        return zona;
    }

    public static void mostrarMenuOrientacion(){
        System.out.println("Menú Orientación.");
        System.out.println("1. Norte.");
        System.out.println("2. Noreste.");
        System.out.println("3. Este.");
        System.out.println("4. Sureste.");
        System.out.println("5. Sur.");
        System.out.println("6. Suroeste.");
        System.out.println("7. Oeste.");
        System.out.println("8. Noroeste.");

    }

    public static Orientacion elegirOrientacion(){
        int opcion;
        do {
            mostrarMenuOrientacion();
            System.out.println("Elige una opción del menú:");
            opcion = Entrada.entero();
        }while (opcion < 1 || opcion > 8);

        switch (opcion){
            case 1: return Orientacion.NORTE;
            case 2: return Orientacion.NORESTE;
            case 3: return Orientacion.ESTE;
            case 4: return Orientacion.SURESTE;
            case 5: return Orientacion.SUR;
            case 6: return Orientacion.SUROESTE;
            case 7: return Orientacion.OESTE;
            case 8: return Orientacion.NOROESTE;
            default: return null;

        }
    }

    public static Coordenada elegirCoordenada(){
        System.out.println("Introduce la coordenada X: ");
        int x = Entrada.entero();
        System.out.println("Introduce la coordenada y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando(){
        char comando;
        do {
            System.out.println("Introduce un comando");
            comando = Entrada.caracter();
        }while (Character.toLowerCase(comando) != 'a' && Character.toLowerCase(comando) != 'd' && Character.toLowerCase(comando) != 'i');
        return comando;
    }

    public static void mostrarRobot(ControladorRobot controladorRobot){
        if (controladorRobot == null){
            System.out.println("El robot es nulo.");
        } else {
            System.out.println(controladorRobot.getRobot().toString());
        }
    }

    public static void despedirse(){
        System.out.println("Hasta luego.");
    }

}
