// Clase Puerta
public class Puerta {
    private boolean abierta;  // Indica si la puerta esta abierta o cerrada

    // Constructor que inicializa la puerta cerrada
    public Puerta() {
        this.abierta = false;
    }

    // Metodo para abrir la puerta
    public void abrir() {
        if (!abierta) {
            abierta = true;
            System.out.println("Puerta abierta. Luz verde encendida.");
        }
    }

    // Metodo para cerrar la puerta
    public void cerrar() {
        if (abierta) {
            abierta = false;
            System.out.println("Puerta cerrada. Luz roja encendida.");
        }
    }

    // Metodo que devuelve si la puerta esta abierta
    public boolean estaAbierta() {
        return abierta;
    }

    // Metodo para detectar si hay un obstaculo en la puerta
    public boolean hayObstaculo() {
        // Simulacion de sensor de obstaculos hay una probabilidad de que haya un obstaculo
        return Math.random() < 0.1;
    }
}