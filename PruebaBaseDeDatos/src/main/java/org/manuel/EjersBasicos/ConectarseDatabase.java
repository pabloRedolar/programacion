package org.manuel.EjersBasicos;

import org.manuel.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConectarseDatabase {
    private final String url = "jdbc:mysql://localhost:3306/programacion";
    private final String user = "root";
    private final String password = "1234";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int insertaListaEstudiantes(List<Estudiante> listaEstudiantes) {

        int numfilas = 0;
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("insert into alumnos (nombre,apellidos,direccion) VALUES (?,?,?)")) {
            for (Estudiante estudiante : listaEstudiantes) {
                preparedStatement.setString(1, estudiante.getNombre());
                preparedStatement.setString(2, estudiante.getApellidos());
                preparedStatement.setString(3, estudiante.getDireccion());

                // Ejecutamos la consulta
                int numflias = preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

    public int insertaAlumno(Estudiante es) {

        int numfilas = 0;
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("insert into alumnos (nombre,apellidos,direccion) VALUES (?,?,?)")) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del alumno");
            String direccion = JOptionPane.showInputDialog("Ingrese la direccion del alumno");
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, direccion);

            // Ejecutamos la consulta
            int numflias = preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

    public int updateEstudiante() {
        int numfilas = 0;
        String nombre;
        String apellidos;
        String direccion;

        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = null;
            String opcion = JOptionPane.showInputDialog("Ingrese que quiere cambiar nombre,apellidos,direccion o TODO");
            int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del alumno que quieres modificar"));
            if (opcion.equalsIgnoreCase("nombre")) {
                nombre = JOptionPane.showInputDialog("Introduce el nombre que quieres setear");
                preparedStatement = connection.prepareStatement("UPDATE alumnos set nombre = ? WHERE id = ?");
                preparedStatement.setString(1, nombre);
                preparedStatement.setInt(2, id);
                int numflias = preparedStatement.executeUpdate();

            } else if (opcion.equalsIgnoreCase("apellidos")) {
                apellidos = JOptionPane.showInputDialog("Introduce los apellidos que quieres setear");
                preparedStatement = connection.prepareStatement("UPDATE alumnos set apellidos = ? WHERE id = ?");
                preparedStatement.setString(1, apellidos);
                preparedStatement.setInt(2, id);
                int numflias = preparedStatement.executeUpdate();

            } else if (opcion.equalsIgnoreCase("direccion")) {
                direccion = JOptionPane.showInputDialog("Introduce la direccion que quieres setear");
                preparedStatement = connection.prepareStatement("UPDATE alumnos set direccion = ? WHERE id = ?");
                preparedStatement.setString(1, direccion);
                preparedStatement.setInt(2, id);
                int numflias = preparedStatement.executeUpdate();

            } else if (opcion.equalsIgnoreCase("todo")) {
                nombre = JOptionPane.showInputDialog("Introduce el nombre que quieres setear");
                apellidos = JOptionPane.showInputDialog("Introduce los apellidos que quieres setear");
                direccion = JOptionPane.showInputDialog("Introduce la direccion que quieres setear");
                preparedStatement = connection
                        .prepareStatement("UPDATE alumnos set nombre = ?, apellidos = ?, direccion = ? WHERE id = ?");
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellidos);
                preparedStatement.setString(3, direccion);
                preparedStatement.setInt(4, id);
                int numflias = preparedStatement.executeUpdate();
            }

            // Ejecutamos la consulta

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

    public int deleteEstudiante() {
        int numfilas = 0;

        try {
            Connection connection = connect();
            int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del alumno que quieres eliminar"));
            PreparedStatement preparedStatement = connection.prepareStatement("delete from alumnos WHERE id = ?");
            preparedStatement.setInt(1, id);

            // Ejecutamos la consulta
            int numflias = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

    public List<Estudiante> obtenerAlumnos() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        try (Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from alumnos")) {
            ;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String direccion = resultSet.getString("direccion");
                Estudiante estudiante = new Estudiante(id, nombre, apellidos, direccion);
                listaEstudiantes.add(estudiante);
                System.out.println(estudiante);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEstudiantes;
    }

    public List<Estudiante> buscarAlumno() {
        List<Estudiante> listaDeEstudianteBuscado = new ArrayList<>();

        String opcion = JOptionPane
                .showInputDialog("Quieres buscar por id, por nombre, apellidos o por nombre y apellidos");
        try {

            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            if (opcion.equalsIgnoreCase("id")) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del ALumno que buscas"));
                resultSet = statement.executeQuery("Select * from alumnos Where id = " + id);

            } else if (opcion.equalsIgnoreCase("nombre")) {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno que estas buscando");
                resultSet = statement.executeQuery("Select * from alumnos Where nombre = '" + nombre + "'");

            } else if (opcion.equalsIgnoreCase("apellidos")) {
                String apellidos = JOptionPane.showInputDialog("Introduce el nombre del alumno que estas buscando")
                        .toLowerCase();
                resultSet = statement
                        .executeQuery("Select * from alumnos Where apellidos = '" + apellidos.toLowerCase() + "'");

            } else if (opcion.equalsIgnoreCase("nombre y apellidos")) {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno que estas buscando")
                        .toLowerCase();
                String apellidos = JOptionPane.showInputDialog("Introduce el nombre del alumno que estas buscando")
                        .toLowerCase();
                resultSet = statement.executeQuery("Select * from alumnos Where nombre LIKE '%" + nombre.toLowerCase()
                        + "%'AND apellidos LIKE '%" + apellidos.toLowerCase() + "%'");
            }

            while (resultSet.next()) {
                int idEstudiante = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String direccion = resultSet.getString("direccion");
                Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellidos, direccion);
                listaDeEstudianteBuscado.add(estudiante);
                System.out.println(estudiante);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaDeEstudianteBuscado;
    }

    public int insertarCurso(Curso curso) {
        int numerofilas = 0;

        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO cursos (nombre,instructor) VALUES (?,?)")) {

            String nombre = JOptionPane.showInputDialog("Introduce el nombre del curso a añadir");
            String instrutor = JOptionPane
                    .showInputDialog("Introduce el nombre del instructor que imparte dicho curso");
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, instrutor);

            numerofilas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerofilas;
    }

    public int borrarCurso() {
        int numerofilas = 0;
        int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del curso que quiere borrar"));

        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cursos WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            numerofilas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerofilas;
    }

    public int updatearCurso() {

        int numerodefilas = 0;
        int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del curso que quieres updatear"));
        String opcion = JOptionPane.showInputDialog("Que quieres cambiar del curso el nombre, el intructor o ambas");
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = null;

            if (opcion.equalsIgnoreCase("nombre")) {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre que quieres ponerle al curso");
                preparedStatement = connection.prepareStatement("UPDATE cursos SET nombre = ? WHERE id = ?");
                preparedStatement.setString(1, nombre);
                preparedStatement.setInt(2, id);
                numerodefilas = preparedStatement.executeUpdate();

            } else if (opcion.equalsIgnoreCase("intructor")) {
                String instructor = JOptionPane.showInputDialog("Introduce el nombre del instructor");
                preparedStatement = connection.prepareStatement("UPDATE cursos SET instructor = ? WHERE id = ?");
                preparedStatement.setString(1, instructor);
                preparedStatement.setInt(2, id);
                numerodefilas = preparedStatement.executeUpdate();

            } else if (opcion.equalsIgnoreCase("ambas")) {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre que quieres ponerle al curso");
                String instructor = JOptionPane.showInputDialog("Introduce el nombre del instructor");
                preparedStatement = connection
                        .prepareStatement("UPDATE cursos SET nombre = ?, instructor = ? WHERE id = ?");
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, instructor);
                preparedStatement.setInt(3, id);
                numerodefilas = preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerodefilas;
    }

    public List<Curso> obtenerCursos() {
        List<Curso> listaDeCursos = new ArrayList<>();

        try (Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from cursos");) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getNString("nombre");
                String instructor = resultSet.getNString("instructor");
                Curso curso = new Curso(id, nombre, instructor);
                listaDeCursos.add(curso);
                System.out.println(curso);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaDeCursos;
    }

    public int matricularAlumnoEnCurso() {
        int numerodefilas = 0;

        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO matricula (idAlumno,idCurso) VALUES (?,?)")) {
            System.out.println("ALUMNOS");
            obtenerAlumnos();
            int idAlumno = Integer
                    .parseInt(JOptionPane.showInputDialog("Introduce el ID del alumno que quieres matricular"));
            System.out.println("CURSOS");
            obtenerCursos();
            int idCurso = Integer.parseInt(JOptionPane.showInputDialog(
                    "Introduce el ID del curso al que quieres matricular al alumno con ID: " + idAlumno));
            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idCurso);
            numerodefilas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerodefilas;
    }

    public int desmatricularAlumnoDeCurso() {
        int numerofilas = 0;
        obtenerAlumnos();
        int idAlumno = Integer
                .parseInt(JOptionPane.showInputDialog("Introduce el id del alumno que quieres desmatricular"));
        obtenerCursos();
        String nombreCurso = JOptionPane.showInputDialog("Introduce el nnombre del curso que quieres desmatricular");
        String idCurso = ("(SELECT id from cursos WHERE nombre = '" + nombreCurso + "')");

        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("DELETE FROM matricula WHERE idAlumno = ? AND idCurso =" + idCurso)) {

            preparedStatement.setInt(1, idAlumno);
            numerofilas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerofilas;
    }

    public int modificarMatricula() {
        int numerodefilas = 0;
        obtenerAlumnos();
        int idAlumno = Integer.parseInt(
                JOptionPane.showInputDialog("Introduce el id del alumno al que quieres cambiarle la matricula"));
        obtenerCursos();
        int idCurso = Integer
                .parseInt(JOptionPane.showInputDialog("Escribe el id del curso al que quieres inscribirlo"));

        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("UPDATE matricula SET idCurso = ? WHERE idAlumno = ? ")) {
            preparedStatement.setInt(1, idCurso);
            preparedStatement.setInt(2, idAlumno);
            numerodefilas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numerodefilas;
    }

    public void devolverCursosDeUnAlumno() {
        obtenerAlumnos();
        int idAlumno = Integer.parseInt(
                JOptionPane.showInputDialog("Introduce el id del alumno del cual quires saber en que cursos estan"));

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT nombre FROM alumnos WHERE id = " + idAlumno);) {
            if (resultSet.next()) {
                String nombreAlumno = resultSet.getString("nombre");
                ResultSet cursosResultSet = statement.executeQuery(
                        "Select nombre from cursos WHERE id IN (Select idCurso from matricula WHERE idAlumno = "
                                + idAlumno + ")");
                while (cursosResultSet.next()) {
                    String nombreCurso = cursosResultSet.getString("nombre");
                    System.out.println("El alumno " + nombreAlumno + " esta inscrito en: " + nombreCurso);
                }
            } else {
                System.out.println("No se encontró un alumno con el ID proporcionado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void devolverAlumnosDeUnCurso() {
        obtenerCursos();
        int idCurso = Integer.parseInt(
                JOptionPane.showInputDialog("Introduce el id del curso del cual quires saber que alumnos hay"));

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT nombre FROM cursos WHERE id = " + idCurso);) {
            if (resultSet.next()) {
                String nombreCurso = resultSet.getString("nombre");
                ResultSet cursosResultSet = statement.executeQuery(
                        "Select nombre from alumnos WHERE id IN (Select idAlumno from matricula WHERE idCurso = "
                                + idCurso + ")");
                while (cursosResultSet.next()) {
                    String nombreAlumno = cursosResultSet.getString("nombre");
                    System.out.println("El alumno " + nombreAlumno + " esta inscrito en: " + nombreCurso);
                }
            } else {
                System.out.println("No se encontró un alumno con el ID proporcionado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
