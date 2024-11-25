package org.iesalandalus.programacion.robot.modelo;

public record Zona(int ancho, int alto) {
    public static int ANCHO_MINIMO = 10;
    public static int ANCHO_MAXIMO = 100;
    public static int ALTO_MINIMO = 10;
    public static int ALTO_MAXIMO = 100;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);

    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    private void validarAncho(int ancho){
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    private void validarAlto(int alto){
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }

    }

    public Coordenada getCentro() {
        int coordenadaX = ancho / 2;
        int coordenadaY = alto / 2;
        return new Coordenada(coordenadaX, coordenadaY);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null){
            throw new NullPointerException("La coordenada no puede ser nula.");
        }

        /*
        boolean perteneceX = this.perteneceX(coordenada.x());
        boolean perteneceY = this.perteneceY(coordenada.y());
        if (perteneceX == true && perteneceY == true) {
            return true;
        } else {
            return false;
        }
         */

        return this.perteneceX(coordenada.x()) && this.perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {
        /*
        if (x >= 0 && x < this.ancho) {
            return true;
        } else {
            return false;
        }
        */

        return x >= 0 && x < this.ancho;
    }

    private boolean perteneceY(int y) {
       /*
       if (y >= 0 && y < this.alto) {
            return true;
        } else {
            return false;
        }
        */

        return y >= 0 && y < this.alto;
    }
}
