package modelo;

// Esta clase representa una sola casilla del tablero del juego
public class Casilla extends ElementoDelTablero {
    private boolean tieneMina;
    private boolean marcada;
    private int minasAlrededor;

    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAlrededor = 0;
    }

    // Retorna True si la casilla contiene una mina
    public boolean tieneMina() {
        return tieneMina;
    }

    // Coloca una mina en esta casilla
    public void colocarMina() {
        this.tieneMina = true;
    }

    // Verifica si la casilla está marcada por el jugador
    public boolean estaMarcada() {
        return marcada;
    }

    // Alterna entre marcada y no marcada
    public void marcar() {
        this.marcada = !marcada;
    }

    // Retorna el número de minas alrededor
    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    // Incrementa el contador de minas alrededor de esta casilla
    public void incrementarMinasAlrededor() {
        this.minasAlrededor++;
    }
    
    @Override
    // Marca la casilla como descubierta
    public void descubrir() {
        this.descubierta = true;
    }

    @Override
    // Devuelve el símbolo que se debe mostrar para esta casilla
    public String mostrar() {
        if (marcada) return "F";          // Marcada con bandera
        if (!descubierta) return "#";     // Oculta
        if (tieneMina) return "X";        // Mina descubierta
        if (minasAlrededor == 0) return "V"; // Sin minas alrededor (Vacía)
        return String.valueOf(minasAlrededor); // Número de minas alrededor
    }
}
