// Clase Piso
public class Piso {
    private int numero;  // Numero del piso
    private BotonDePiso botonSubida;  // Boton de subida relaciionado al piso
    private BotonDePiso botonBajada;  // Botón de bajada relacionado al piso

    // Constructor que recibe el numero del piso y crea los botones de subida y bajada
    public Piso(int numero) {
        this.numero = numero;
        this.botonSubida = new BotonDePiso("subida");  // Crea el boton de subida
        this.botonBajada = new BotonDePiso("bajada");  // Crea el boton de bajada
    }

    // Metodo para solicitar que el ascensor suba desde este piso
    public void solicitarSubida() {
        botonSubida.presionar();  // Presiona el boton de subida
    }

    // Metodo para solicitar que el ascensor baje desde este piso
    public void solicitarBajada() {
        botonBajada.presionar();  // Presiona el boton de bajada
    }

    // Devuelve el numero del piso
    public int getNumero() {
        return numero;
    }
}