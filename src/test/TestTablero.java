package test;

import modelo.CasillaYaDescubiertaException;
import modelo.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    @Test
    public void testTableroInicial() {
        Tablero tablero = new Tablero();
        assertNotNull(tablero);
    }

    @Test
    public void testDescubrirCasillaValida() throws CasillaYaDescubiertaException {
        Tablero tablero = new Tablero();
        assertTrue(tablero.descubrir(0, 0)); // No debe ser mina en la mayoría de casos
    }

    @Test
    public void testMarcarCasilla() {
        Tablero tablero = new Tablero();
        tablero.marcar(1, 1);
        // No hay método para verificar marcación directa desde Tablero
        // Este test es limitado por ahora
        assertDoesNotThrow(() -> tablero.marcar(1, 1));
    }

    @Test
    public void testJuegoNoGanadoAlInicio() {
        Tablero tablero = new Tablero();
        assertFalse(tablero.juegoGanado());
    }

    @Test
    public void testMostrarTablero() {
        Tablero tablero = new Tablero();
        assertDoesNotThrow(() -> tablero.mostrarTablero());
    }
}