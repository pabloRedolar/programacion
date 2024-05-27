package Clases;

import Clases_Abstractas.Animales;
import Excepciones.ApareamientoImposibleException;

import java.util.random.RandomGenerator;

public class Gatos extends Animales {
    private String raza;

    public Gatos() {
        super("hembra");
        this.raza = "siames";
    }

    //Tecnicamente admite solo uno, aunque reciba 3
    public Gatos(String raza, String nada1, String nada2) {
        super("hembra");
        this.raza = raza;
    }
    //Y este solo recibe uno, Porque no puedo añadir dos contructores
    // con mismo numero de parametros de entrada
    public Gatos(String sexo) {
        super(sexo);
        this.raza = "siames";
    }

    public Gatos(String sexo, String raza) {
        super(sexo);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "El Gato de raza= "+raza+" y "+super.toString();
    }
    public Gatos apareaCon(Gatos gato){
        try {
            if (this.getSexo().equals(gato.getSexo())) {
                throw new ApareamientoImposibleException(this.getSexo());

            } else {
                String sexo = "hembra"; String raza;
                if (RandomGenerator.getDefault().nextInt(0,2)==1){sexo = "macho";}
                if (this.raza.equals(gato.raza)){raza=this.raza;} else {raza=this.raza+"/"+gato.raza;}
                return new Gatos(sexo, raza);
            }
        }catch(ApareamientoImposibleException aie){
                System.out.println(aie.getMessage());
                return null;
        }
    }
}
