package modelo;

// Excepción lanzada cuando el jugador intenta descubrir una casilla ya descubierta.
public class CasillaYaDescubiertaException extends Exception {
	private static final long serialVersionUID = 1L;

	public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }
}