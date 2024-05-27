package Clases;

public class Coche extends Vehiculo {
    private String ventanilla;

    public Coche(String nombre, int dorsal, int velocidadActual, int velocidadMaxima, String tipoCombustible, int numeroRuedas, String ventanilla) {
        super(nombre, dorsal, velocidadActual, velocidadMaxima, tipoCombustible, numeroRuedas);
        this.ventanilla = ventanilla;
    }

    public Coche(String ventanilla) {
        this.ventanilla = ventanilla;
    }

    @Override
    public String toString() {
        String superstring = super.toString();
        return superstring + ", ventanilla: " + ventanilla + "\n";
    }

    public String subirBajarVentanilla() {
        if (this.ventanilla == "bajada") {
            return this.ventanilla = "subida";
        } else {
            return this.ventanilla = "bajada";
        }
    }

    public String getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(String ventanilla) {
        this.ventanilla = ventanilla;
    }
}
