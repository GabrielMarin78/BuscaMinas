package util;

import java.io.*;
import modelo.Tablero;
import modelo.Jugador;

public class GestorArchivoJuego {
    private static final String RUTA_ARCHIVO = "juegoGuardado.ser";

    public static void guardar(Tablero tablero, Jugador jugador) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            out.writeObject(tablero);
            out.writeObject(jugador);
            System.out.println("Juego guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el juego: " + e.getMessage());
        }
    }

    public static Object[] cargar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            Tablero tablero = (Tablero) in.readObject();
            Jugador jugador = (Jugador) in.readObject();
            return new Object[]{tablero, jugador};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar la partida: " + e.getMessage());
            return null;
        }
    }
}
