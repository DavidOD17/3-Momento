// Clase SistemaDeControl
import java.util.Scanner;

public class SistemaDeControl {
    private Ascensor ascensor;  // Objeto que controla el ascensor
    private Piso[] pisos;  // Arreglo de los pisos

    // Constructor que inicializa el ascensor y los pisos
    public SistemaDeControl(int numeroDePisos) {
        ascensor = new Ascensor(numeroDePisos);  // Crea un ascensor con el numero de pisos dado
        pisos = new Piso[numeroDePisos];
        for (int i = 1; i <= numeroDePisos; i++) {
            pisos[i - 1] = new Piso(i);  // Crea un piso por cada piso en el edificio
        }
    }

    // Metodo que inicia el sistema y gestiona las opciones del usuario
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Interfaz de usuario para controlar el ascensor
            System.out.println("    ************************************************");
            System.out.println("    *              Panel de control                *");
            System.out.println("    ************************************************");
            System.out.println("    * 1. Solicitar ascensor                        *");
            System.out.println("    * 2. Salir                                     *");
            System.out.println("    ************************************************");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();  // Lee la opcion seleccionada por el usuario

            switch (opcion) {
                case 1:
                    // Solicita el piso de destino para el ascensor
                    System.out.print("Ingrese el piso (1-5): ");
                    int piso = scanner.nextInt();
                    if (piso < 1 || piso > 5) {
                        System.out.println(" El piso " + piso + " no existe");
                    } else {
                        ascensor.seleccionarPiso(piso);  // Mueve el ascensor al piso seleccionado
                    }
                    break;

                case 2:
                    System.out.println("Saliendo...");
                    scanner.close();  // Cierra el escaner cuando se sale del sistema
                    return;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}