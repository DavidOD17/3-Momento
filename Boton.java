// Clase Boton
public class Boton {
    private boolean encendido;  // Indica si el boton esta presionado
    private String tipo;  // Tipo de botón "subida", "bajada" o "destino"

    // Constructor de un boton de tipo 
    public Boton(String tipo) {
        this.tipo = tipo;
        this.encendido = false;
    }

    // Metodo que simula presionar el boton
    public void presionar() {
        encendido = true;
        System.out.println("Boton " + tipo + " presionado. Luz encendida.");
        System.out.println("Sonido de confirmacion...");
    }

    // Metodo para resetear el estado del botón a apagado
    public void resetear() {
        encendido = false;
        System.out.println("Boton " + tipo + " apagado.");
    }

    // Devuelve si el boton esta presionado
    public boolean estaEncendido() {
        return encendido;
    }

    // Devuelve el tipo de boton (subida, bajada, destino)
    public String getTipo() {
        return tipo;
    }
}