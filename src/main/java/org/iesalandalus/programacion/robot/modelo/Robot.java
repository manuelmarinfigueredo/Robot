package org.iesalandalus.programacion.robot.modelo;


import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Zona zona;
    private Coordenada coordenada;
    private Orientacion orientacion;

    public Robot(){
        this.zona = new Zona(Zona.ANCHO_MINIMO, Zona.ALTO_MINIMO);
        this.coordenada = new Coordenada(zona.ancho()/2, zona.alto()/2);
        this.orientacion = Orientacion.NORTE;

    }

    public Robot(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
        this.coordenada = new Coordenada(zona.ancho()/2, zona.alto()/2);
        this.orientacion = Orientacion.NORTE;

    }

    public Robot(Zona zona, Orientacion orientacion) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = new Coordenada(zona.ancho()/2, zona.alto()/2);
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
       this.zona = zona;
       this.orientacion = orientacion;
       if (this.zona.pertenece(coordenada)){
           this.coordenada = coordenada;
       } else {
           throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
       }
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.getZona();
        orientacion = robot.getOrientacion();
        coordenada = robot.getCoordenada();
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public void avanzar() throws OperationNotSupportedException {
        int x = coordenada.x();
        int y = coordenada.y();

        switch (this.orientacion){
            case NORTE -> y++;
            case NORESTE -> {
                x++;
                y++;
            }
            case ESTE -> x++;
            case SURESTE -> {
                x++;
                y--;
            }
            case SUR -> y--;
            case SUROESTE -> {
                x--;
                y--;
            }
            case OESTE -> x--;
            case NOROESTE -> {
                x--;
                y++;
            }
        }

        Coordenada nuevaCoordenada = new Coordenada(x, y);
        if (zona.pertenece(nuevaCoordenada)){
            this.coordenada = nuevaCoordenada;
        } else {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }

    }

    public void girarALaDerecha(){
        this.orientacion = this.orientacion.next();
    }

    public void girarALaIzquierda() {
        this.orientacion = this.orientacion.previous();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(zona, robot.zona) && Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return String.format("[zona=%s, coordenada=%s, orientacion=%s]", zona, coordenada, orientacion);
    }
}
