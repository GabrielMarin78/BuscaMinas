package controlador;


import modelo.Jugador;
import modelo.Tablero;
import modelo.CasillaYaDescubiertaException;
import vista.VistaConsola;
import java.util.Scanner;

public class ControladorJuego {
    private Tablero tablero;
    private Jugador jugador;
    private VistaConsola vista;

    public ControladorJuego() {
        this.vista = new VistaConsola();
    }

    public void iniciarJuego() {
    	try (Scanner entrada = new Scanner(System.in)) {
        	//Solicita el nombre del jugador
    		vista.mostrarMensaje("\n<<<<< BUSCAMINAS >>>>>");
        	vista.mostrarMensaje("Ingrese su nombre: ");
        	String nombre = entrada.nextLine();
        	this.jugador = new Jugador(nombre);
        	
            this.tablero = new Tablero();
            boolean jugando = true;

            vista.mostrarMensaje("\n<<< Bienvenido al BUSCAMINAS, " + jugador.getNombre() + " >>>");

            while (jugando) {
                vista.mostrarTablero(tablero);

                // Solicita la acción del jugador
                vista.mostrarMensaje("\nIngresa una acción:" +
                                   "\n- Descubrir (d)" +
                                   "\n- Marcar (m)" +
                                   "\nSeguido de las coordenadas" +
                                   "\n(ejemplo: d A5):");
                
                String accion = entrada.next();
                String coordenada = entrada.next();

                // Convierte coordenadas como "A5" a (fila, columna)
                int fila = coordenada.toUpperCase().charAt(0) - 'A';
                int columna = Integer.parseInt(coordenada.substring(1));
                
                // Validasi la selección del usuario está dentro del rango
                if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
                    vista.mostrarMensaje("\n¡Coordenada fuera de rango!");
                }

                // Ejecuta la acción del usuario
                if (accion.equalsIgnoreCase("d")) {
                	try {
                        boolean continuar = tablero.descubrir(fila, columna);
                        
                        // Si no pisó una mina, aumentamos el puntaje
                        if (continuar) {
                        	jugador.aumentarPuntaje(10); // Cada casilla vacía descubierta da 10 puntos
                        }
                        
                        if (!continuar) {
                            vista.mostrarMensaje("\n¡BOOM! Has perdido.");
                            vista.mostrarTablero(tablero);
                            vista.mostrarMensaje("\nPuntaje final de " + jugador.getNombre() + ": " + jugador.getPuntaje());
                            break;
                        }
                        
                        if (tablero.juegoGanado()) {
                            vista.mostrarMensaje("\n¡Felicidades " + jugador.getNombre() + "! ¡Has ganado!");
                            tablero.mostrarTablero();
                            vista.mostrarMensaje("\nPuntaje final: " + jugador.getPuntaje());
                            break;
                        }
                    } catch (CasillaYaDescubiertaException e) {
                        	vista.mostrarMensaje(e.getMessage());               		
                	}
                } else if (accion.equalsIgnoreCase("m")) {
                    tablero.marcar(fila, columna);
                } else {
                    vista.mostrarMensaje("\nAcción no válida.");
                }
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            vista.mostrarMensaje("\nEntrada inválida. Usa el formato correcto (ej: d A5).");
        }

    }
}
