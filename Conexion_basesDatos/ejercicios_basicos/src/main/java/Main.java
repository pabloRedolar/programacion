import Base_de_datos.DatabaseConector;
import Modelos.Alumno;

public class Main {
    public static void main(String[] args) {
        DatabaseConector databaseConector = new DatabaseConector();
//        List<Alumno> alumnoList = new ArrayList<>();
//        Alumno alumno = new Alumno(0, "Pablo", "Redolar", "Calle alta, 2");
//        Alumno alumno1 = new Alumno(1, "a", "b", "Calle alta, 2");
//
//        alumnoList.add(alumno);
//        alumnoList.add(alumno1);
//        databaseConector.inserta(alumnoList);
//        Alumno alumno = new Alumno();

        databaseConector.opciones();

//      databaseConector.insertalumnos(alumno);
//      databaseConector.actualizaAlumnos(alumno);
    }
}
