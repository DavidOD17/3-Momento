// Clase BotonDelAscensor Hereda de Boton y representa los botones dentro del ascensor
public class BotonDelAscensor extends Boton {
    private int pisoDestino;  // Piso destino al que se desea mover el ascensor

    // Constructor que recibe el piso destino del botn
    public BotonDelAscensor(int pisoDestino) {
        super("destino");  // Llama al constructor de la clase base (Boton) con el tipo "destino"
        this.pisoDestino = pisoDestino;
    }

    // Aca lo que hacemos es Sobrescrir el metodo presionar para incluir el comportamiento de los botones dentro del ascensor
    @Override
    public void presionar() {
        super.presionar();  // Llama al metodo presionar de la clase base (Boton)
        System.out.println("Piso de destino " + pisoDestino + " seleccionado.");
    }

    // Devuelve el piso de destino asociado a este boton
    public int getPisoDestino() {
        return pisoDestino;
    }
}