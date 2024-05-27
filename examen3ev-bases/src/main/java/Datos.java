import java.util.ArrayList;
import java.util.List;

public class Datos {
    private List<Estudios> lista_datos = new ArrayList<>();

    public Datos() {
    }

    public Datos(List<Estudios> datos) {
        this.lista_datos = datos;
    }

    public List<Estudios> getDatos() {
        return lista_datos;
    }

    public void setDatos(List<Estudios> datos) {
        this.lista_datos = datos;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "datos=" + lista_datos +
                '}';
    }
}

