package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot){
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.robot = new Robot(robot);
    }

    public Robot getRobot(){
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws OperationNotSupportedException, RobotExcepcion {

        switch (Character.toUpperCase(comando)) {
            case 'A':
                robot.avanzar();
                break;
            case 'D':
                robot.girarALaDerecha();
                break;
            case 'I':
                robot.girarALaIzquierda();
                break;
            default:
                throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
