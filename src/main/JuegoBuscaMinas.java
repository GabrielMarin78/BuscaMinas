package main;

import modelo.*;
import java.util.Scanner;

// Clase principal con el método main para iniciar el juego desde la consola
public class JuegoBuscaMinas {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
        	//Solicita el nombre del jugador
        	System.out.print("Ingrese su nombre: ");
        	String nombre = entrada.nextLine();
        	Jugador jugador = new Jugador(nombre);
        	
            Tablero tablero = new Tablero();
            boolean jugando = true;

            System.out.println("\n<<< Bienvenido al BUSCAMINAS, " + jugador.getNombre() + " >>>");

            while (jugando) {
                tablero.mostrarTablero();

                // Solicita la acción del jugador
                System.out.println("\nIngresa una acción:" +
                                   "\n- Descubrir (d)" +
                                   "\n- Marcar (m)" +
                                   "\nSeguido de las coordenadas" +
                                   "\n(ejemplo: d A5):");
                
                String accion = entrada.next();
                String coordenada = entrada.next();

                // Convierte coordenadas como "A5" a (fila, columna)
                int fila = coordenada.toUpperCase().charAt(0) - 'A';
                int columna = Integer.parseInt(coordenada.substring(1));

                // Ejecuta la acción del usuario
                if (accion.equalsIgnoreCase("d")) {
                    boolean continuar = tablero.descubrir(fila, columna);
                    
                    // Si no pisó una mina, aumentamos el puntaje
                    if (continuar) {
                    	jugador.aumentarPuntaje(10); // Cada casilla vacía descubierta da 10 puntos
                    }
                    
                    if (!continuar) {
                        System.out.println("\n¡BOOM! Has perdido.");
                        tablero.mostrarTablero();
                        System.out.println("\nPuntaje final de " + jugador.getNombre() + ": " + jugador.getPuntaje());
                        break;
                    }
                    
                    if (tablero.juegoGanado()) {
                        System.out.println("\n¡Felicidades " + jugador.getNombre() + "! ¡Has ganado!");
                        tablero.mostrarTablero();
                        System.out.println("\nPuntaje final: " + jugador.getPuntaje());
                        break;
                    }
                } else if (accion.equalsIgnoreCase("m")) {
                    tablero.marcar(fila, columna);
                } else {
                    System.out.println("\nAcción no válida.");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
