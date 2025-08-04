package juego;

// Esta clase representa al jugador del juego
public class Jugador {
	// Atributos de la clase 'Jugador'
    private String nombre;
    private int puntaje;

    // Método constructor de la clase 'Jugador'
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    // Método getter para el campo 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Método getter para el campo 'puntaje'
    public int getPuntaje() {
        return puntaje;
    }

    // Incrementa el puntaje del jugador
    public void aumentarPuntaje(int puntos) {
        this.puntaje += puntos;
    }
}
