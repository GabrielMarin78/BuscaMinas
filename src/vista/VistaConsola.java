package vista;

import modelo.Tablero;
import java.util.Scanner;

public class VistaConsola {
    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    // Muestra un mensaje por pantalla
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Muestra el tablero actual
    public void mostrarTablero(Tablero tablero) {
        tablero.mostrarTablero(); // delega la visualización al modelo
    }

    // Solicita una acción al usuario y devuelve la entrada como array: [acción, coordenada]
    public String[] pedirEntrada() {
        System.out.println("\nIngresa una acción:" +
                           "\n- Descubrir (d)" +
                           "\n- Marcar (m)" +
                           "\nSeguido de las coordenadas (ej: d A5):");

        String accion = scanner.next();
        String coordenada = scanner.next();
        return new String[]{accion, coordenada};
    }
}
