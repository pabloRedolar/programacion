package Clases;

public class Vehiculo {
    private String nombre;
    private int dorsal;
    private int velocidadActual;
    private int velocidadMaxima;
    private String tipoCombustible;
    private int numeroRuedas;

    public Vehiculo() {
    }

    public Vehiculo(String nombre, int dorsal, int velocidadActual, int velocidadMaxima, String tipoCombustible, int numeroRuedas) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.velocidadActual = velocidadActual;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoCombustible = tipoCombustible;
        this.numeroRuedas = numeroRuedas;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
                ", dorsal: " + dorsal +
                ", velocidadActual: " + velocidadActual +
                ", velocidadMaxima: " + velocidadMaxima +
                ", tipoCombustible: " + tipoCombustible +
                ", numeroRuedas: " + numeroRuedas;
    }

    public String sonidoMotor() {
        String ruido_coche = "";
        if (this.tipoCombustible.toLowerCase() == "gasolina") {
            ruido_coche = "broom broom";
        } else if (this.tipoCombustible.toLowerCase() == "diesel") {
            ruido_coche = "fiuuum";
        } else if (this.tipoCombustible.toLowerCase() == "electrico") {
            ruido_coche = "soy una lavadora";
        }
        return ruido_coche;
    }

    public int acelerar(int kmh) {
        if (this.velocidadActual + kmh < this.velocidadMaxima) {
            this.velocidadActual += kmh;
        } else {
            return this.velocidadMaxima;
        }
        return velocidadActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }
}
