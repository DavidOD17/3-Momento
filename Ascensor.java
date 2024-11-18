import java.util.ArrayList;
import java.util.Scanner;
// Clase Ascensor 
public class Ascensor {
    private int ubicacionActual;  // Piso actual en el que se encuentra el ascensor
    private String direccion;  // Direccion del ascensor ("subiendo" o "bajando")
    private Puerta puerta;  // Objeto que controla la puerta del ascensor
    private ArrayList<BotonDelAscensor> botones;  // Botones para seleccionar el destino del ascensor
    private final double pesoMaximo = 500.0;  // Peso maximo permitido en el ascensor
    private double pesoActual;  // Peso actual dentro del ascensor

    // Constructor del ascensor con un numero de pisos.
    public Ascensor(int pisos) {
        this.ubicacionActual = 1;  // Se inicializa el ascensor en el primer piso
        this.direccion = "subiendo";  // Inicializamos la direccion como "subiendo"
        this.puerta = new Puerta();  // Crea la puerta del ascensor
        this.botones = new ArrayList<>();  // Se crea la lista de botones para cada piso
        this.pesoActual = 0.0;  // Inicializamos el peso actual como 0

        // Inicializa los botones para cada piso (1-5)
        for (int i = 1; i <= pisos; i++) {
            botones.add(new BotonDelAscensor(i));  // Cada boton tiene asociado un piso destino
        }
    }

    // Metodo para mover el ascensor a un piso de destino
    public void moverAscensor(int pisoDestino) {
        if (ubicacionActual == pisoDestino) {
            System.out.println("El ascensor ya está en el piso " + pisoDestino);
            return;
        }

        while (ubicacionActual != pisoDestino) {
            if (ubicacionActual < pisoDestino) {
                direccion = "subiendo";  // Si el ascensor esta en un piso inferior sube el ascensor
                ubicacionActual++;
            } else {
                direccion = "bajando";  // Si el ascensor esta en un piso superior baja el ascensor
                ubicacionActual--;
            }
            System.out.println("Ascensor en piso " + ubicacionActual);  // Imprime la ubicación actual del ascensor
        }

        System.out.println("Ascensor ha llegado al piso " + pisoDestino);
        puerta.abrir();  // Se abre la puerta al llegar al destino

        // Verifica si hay obstaculos con el sensor de la puerta del ascensor
        if (puerta.hayObstaculo()) {
            System.out.println("Obstaculo detectado. *Manteniendo puertas abiertas*.");
        } else {
            puerta.cerrar();  // Si no hay obstaculos cierra la puerta
        }
    }

    // Metodo para seleccionar un piso al que el ascensor debe ir
    public void seleccionarPiso(int piso) {
        if (piso < 1 || piso > 5) {
            System.out.println(" El piso " + piso + " no existe.");
            return;
        }
        botones.get(piso - 1).presionar();  // Llama al boton correspondiente al piso
        if (gestionarPeso()) {  // Verifica si el peso es adecuado antes de mover el ascensor
            moverAscensor(piso);  // Mueve el ascensor al piso seleccionado
        }
    }

    // Metodo para gestionar el peso de las personas que ingresan al ascensor
    private boolean gestionarPeso() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuantas personas van a ingresar al ascensor? ");
        int cantidadPersonas = scanner.nextInt();

        ArrayList<Double> pesosPersonas = new ArrayList<>();
        double pesoTotal = 0.0;

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.print("Ingrese el peso de la persona " + (i + 1) + " en kg: ");
            double peso = scanner.nextDouble();
            pesosPersonas.add(peso);
            pesoTotal += peso;
        }

        // Se Valida si el peso total excede el limite.
        if (pesoTotal > pesoMaximo) {
            System.out.println(" El peso total (" + pesoTotal + " kg) excede el limite de " + pesoMaximo + " kg.");
            while (pesoTotal > pesoMaximo) {
                System.out.println("\nDebe bajar una persona para continuar.");
                for (int i = 0; i < pesosPersonas.size(); i++) {
                    System.out.println((i + 1) + ". Persona con " + pesosPersonas.get(i) + " kg");
                }

                System.out.print("Seleccione el numero de la persona que bajara: ");
                int personaABajar = scanner.nextInt();

                // Validacion de la seleccion
                if (personaABajar < 1 || personaABajar > pesosPersonas.size()) {
                    System.out.println("Seleccion no valida. Intentelo de nuevo.");
                    continue;
                }

                // Restar el peso de la persona seleccionada y se elimina de la lista.
                double pesoBajado = pesosPersonas.remove(personaABajar - 1);
                pesoTotal -= pesoBajado;
                System.out.println("Persona con " + pesoBajado + " kg ha bajado. Peso actual: " + pesoTotal + " kg");
            }
        }

        System.out.println("Peso dentro del limite. *Ascensor listo para moverse*.");
        return true;
    }
}