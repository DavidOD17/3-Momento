// Clase BotonDePiso esta clase extiende de la clase Boton 
public class BotonDePiso extends Boton {
    private String direccion;  // Direccion del boton: "subida" o "bajada"

    // Constructor que recibe la dirección del boton (subida o bajada) y la pasa al constructor de la clase base (Boton)
    public BotonDePiso(String direccion) {
        super(direccion);  // Llama al constructor de la clase base Boton con la direccion
        this.direccion = direccion;  // Establece la direccion del boton (subida o bajada)
    }

  
    // Cuando se presiona el boton se muestra un mensaje específico para esta accin
    @Override
    public void presionar() {
        super.presionar();  // Llama al metodo presionar() de la clase base Boton para encender la luz 
        System.out.println("Solicitud de " + direccion + " registrada desde el piso.");  // Mensaje de la accion
    }

    // Devuelve la direccion del boton ("subida" o "bajada")
    public String getDireccion() {
        return direccion;
    }
}