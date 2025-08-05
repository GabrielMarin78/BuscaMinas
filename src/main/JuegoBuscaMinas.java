package main;

import controlador.ControladorJuego;

// Clase principal que inicia la ejecución del juego
public class JuegoBuscaMinas {
    public static void main(String[] args) {
        ControladorJuego controlador = new ControladorJuego();
        controlador.iniciarJuego();
    }
}
