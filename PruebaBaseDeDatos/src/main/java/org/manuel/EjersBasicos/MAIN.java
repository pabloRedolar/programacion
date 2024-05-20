package org.manuel.EjersBasicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIN {
    public static void main(String[] args) {
//        List<Estudiante> listaDeEstudiante = new ArrayList<>();
//        Estudiante estudiante = new Estudiante(1,"Manuel","Julve","chomon");
//        Estudiante estudiante1 = new Estudiante(2,"Maria","Julve","chomon");
//        Estudiante estudiante2 = new Estudiante(3,"Juan","Julve","chomon");
//        Estudiante estudiante3 = new Estudiante(4,"Pablo","Julve","chomon");
//        Estudiante estudiante4 = new Estudiante(5,"Kevin","Julve","chomon");
//        Estudiante estudiante5 = new Estudiante(6,"Alex","Julve","chomon");
//        Estudiante estudiante6 = new Estudiante(7,"Mario","Julve","chomon");
//        Estudiante estudiante7 = new Estudiante(8,"Berron","Julve","chomon");
//        Estudiante estudiante8 = new Estudiante(9,"Juanma","Julve","chomon");
//        Estudiante estudiante9  = new Estudiante(10,"Oscar","Julve","chomon");
//        listaDeEstudiante.add(estudiante);
//        listaDeEstudiante.add(estudiante1);
//        listaDeEstudiante.add(estudiante2);
//        listaDeEstudiante.add(estudiante3);
//        listaDeEstudiante.add(estudiante4);
//        listaDeEstudiante.add(estudiante5);
//        listaDeEstudiante.add(estudiante6);
//        listaDeEstudiante.add(estudiante7);
//        listaDeEstudiante.add(estudiante8);
//        listaDeEstudiante.add(estudiante9);
       ConectarseDatabase conectarseDatabase = new ConectarseDatabase();
//        conectarseDatabase.insertaListaEstudiantes(listaDeEstudiante);
        //Estudiante estudiante = new Estudiante();
        //conectarseDatabase.insertaAlumno(estudiante);
        //conectarseDatabase.deleteEstudiante();

//        for (Estudiante estudiante : conectarseDatabase.obtenerAlumnos()){
//            System.out.println(estudiante);
//        }
//        conectarseDatabase.buscarAlumno();
//       Curso curso = new Curso();
//       conectarseDatabase.insertarCurso(curso);
//        conectarseDatabase.updatearCurso();
//        conectarseDatabase.obtenerCursos();
//
//        conectarseDatabase.borrarCurso();
 //       conectarseDatabase.matricularAlumnoEnCurso();
 //       conectarseDatabase.desmatricularAlumnoDeCurso();
 //       conectarseDatabase.modificarMatricula();
 //       conectarseDatabase.devolverCursosDeUnAlumno();
        conectarseDatabase.devolverAlumnosDeUnCurso();

    }
}
