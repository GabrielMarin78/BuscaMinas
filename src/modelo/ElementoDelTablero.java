package modelo;

/* Esta clase podría representar a cualquier elemento del tablero
(casilla, mina, marcador, etc)*/
public abstract class ElementoDelTablero {
    protected boolean descubierta;

    public abstract String mostrar();
    public abstract void descubrir();

    public boolean estaDescubierta() {
        return descubierta;
    }
}
