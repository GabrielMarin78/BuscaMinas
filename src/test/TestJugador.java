package test;

import modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestJugador {

    @Test
    public void testNombreJugador() {
        Jugador jugador = new Jugador("Gabriel");
        assertEquals("Gabriel", jugador.getNombre());
    }

    @Test
    public void testPuntajeInicial() {
        Jugador jugador = new Jugador("Ana");
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void testAumentarPuntaje() {
        Jugador jugador = new Jugador("Luis");
        jugador.aumentarPuntaje(15);
        assertEquals(15, jugador.getPuntaje());
        jugador.aumentarPuntaje(5);
        assertEquals(20, jugador.getPuntaje());
    }
}