package test;

import modelo.Casilla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCasilla {

    @Test
    void testCasillaInicialSinMina() {
        Casilla casilla = new Casilla();
        assertFalse(casilla.tieneMina());
        assertFalse(casilla.estaDescubierta());
        assertFalse(casilla.estaMarcada());
        assertEquals(0, casilla.getMinasAlrededor());
    }

    @Test
    void testMarcarYDesmarcar() {
        Casilla casilla = new Casilla();
        casilla.marcar();
        assertTrue(casilla.estaMarcada());
        casilla.marcar(); // alterna
        assertFalse(casilla.estaMarcada());
    }

    @Test
    void testColocarMina() {
        Casilla casilla = new Casilla();
        casilla.colocarMina();
        assertTrue(casilla.tieneMina());
    }
}
