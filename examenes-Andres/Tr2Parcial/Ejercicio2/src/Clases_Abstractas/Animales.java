package Clases_Abstractas;

public abstract class Animales {
    private String sexo;

    public Animales() {
        this.sexo = "macho";
    }

    public Animales(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "sexo= "+sexo;
    }
}
