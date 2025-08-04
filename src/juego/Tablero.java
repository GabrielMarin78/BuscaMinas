package juego;

import java.util.Random;

// Esta clase representa el tablero de juego, con sus casillas y lógica de juego
public class Tablero {
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int MINAS = 10;

    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[FILAS][COLUMNAS];
        inicializarCasillas();
        colocarMinas();
        contarMinasAlrededor();
    }

    // Inicializa todas las casillas del tablero como vacías
    private void inicializarCasillas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    // Coloca aleatoriamente las minas en el tablero
    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < MINAS) {
            int fila = rand.nextInt(FILAS);
            int col = rand.nextInt(COLUMNAS);
            if (!casillas[fila][col].tieneMina()) {
                casillas[fila][col].colocarMina();
                minasColocadas++;
            }
        }
    }

    // Cuenta cuántas minas hay alrededor de cada casilla
    private void contarMinasAlrededor() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!casillas[i][j].tieneMina()) {
                    for (int[] dir : direcciones()) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (esValido(ni, nj) && casillas[ni][nj].tieneMina()) {
                            casillas[i][j].incrementarMinasAlrededor();
                        }
                    }
                }
            }
        }
    }

    // Devuelve un array con las 8 direcciones alrededor de una casilla
    private int[][] direcciones() {
        return new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };
    }

    // Verifica que la coordenada esté dentro de los límites del tablero
    private boolean esValido(int fila, int col) {
        return fila >= 0 && fila < FILAS && col >= 0 && col < COLUMNAS;
    }

    // Descubre una casilla. Si es una mina, se pierde el juego
    public boolean descubrir(int fila, int col) {
        if (!esValido(fila, col) || casillas[fila][col].estaDescubierta()) {
            return true;
        }

        casillas[fila][col].descubrir();

        if (casillas[fila][col].tieneMina()) {
            return false; // Perdiste
        }

        // Descubre en cadena si no hay minas alrededor
        if (casillas[fila][col].getMinasAlrededor() == 0) {
            for (int[] dir : direcciones()) {
                int ni = fila + dir[0], nj = col + dir[1];
                if (esValido(ni, nj)) {
                    descubrir(ni, nj);
                }
            }
        }
        return true;
    }

    // Marca o desmarca una casilla
    public void marcar(int fila, int col) {
        if (esValido(fila, col)) {
            casillas[fila][col].marcar();
        }
    }

    // Muestra el tablero actual en consola
    public void mostrarTablero() {
        System.out.println("");
        System.out.print("  ");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(casillas[i][j].mostrar() + " ");
            }
            System.out.println();
        }
    }

    // Verifica si el jugador ha ganado el juego
    public boolean juegoGanado() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!casillas[i][j].tieneMina() && !casillas[i][j].estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }
}
