package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.RobotExcepcion;
import org.iesalandalus.programacion.robot.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("Elige una opción: ");
            opcion = Entrada.entero();
            if ((opcion >= 0 && opcion < 5) || (controladorRobot != null)) {
                try{
                    ejecutarOpcion(opcion);
                    System.out.println(controladorRobot.getRobot().toString());
                } catch (Exception e){
                    System.out.println("No se puede ejecutar: " + e.getMessage() + "\n");
                }
            } else {
                System.out.println("Opción no válida crea un robot antes");
            }

        }while (opcion != 0);

    }



    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {

        switch (opcion){
            case 1: controlarRobotDefecto();
            break;
            case 2: controlarRobotZona();
            break;
            case 3: controlarRobotZonaOrientacion();
            break;
            case 4: controlarRobotZonaOrientacionCoordenada();
            break;
            case 5: ejecutarComando();
            break;
            case 0: {
                Consola.despedirse();
                System.exit(0);
            }
            break;
            default:System.out.println("Opción no valida.");
        }
    }

    private static void controlarRobotDefecto(){
        controladorRobot = new ControladorRobot(new Robot());
    }

    private static void controlarRobotZona(){
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotZonaOrientacion(){
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static void controlarRobotZonaOrientacionCoordenada(){
       controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
    }

    private static void ejecutarComando() throws OperationNotSupportedException {
       controladorRobot.ejecutar(Consola.elegirComando());
    }

}
