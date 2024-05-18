import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Clase Libro
class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible;

    // Constructor
    public Libro(int id, String titulo, String autor, String genero, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método toString
    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Género: " + genero + ", Disponible: " + disponible;
    }
}

// Clase Usuario
class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Libro> librosPrestados;

    // Constructor
    public Usuario(int id, String nombre, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.librosPrestados = new ArrayList<>();
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    // Método toString
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Dirección: " + direccion;
    }
}

// Clase Biblioteca
public class Biblioteca extends JFrame {
    private Connection conexion;
    private JTextArea outputArea;
    private JTextField buscarField;
    private JButton buscarButton;

    // Constructor
    public Biblioteca(Connection conexion) {
        this.conexion = conexion;

        setTitle("Gestión de Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        buscarField = new JTextField(20);
        buscarButton = new JButton("Buscar Libro");

        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibros();
            }
        });

        JPanel buscarPanel = new JPanel();
        buscarPanel.add(new JLabel("Buscar Libro: "));
        buscarPanel.add(buscarField);
        buscarPanel.add(buscarButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);
        getContentPane().add(buscarPanel, BorderLayout.NORTH);
    }

    // Método para buscar libros por título
    private void buscarLibros() {
        String titulo = buscarField.getText();
        List<Libro> resultados = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Libros WHERE titulo LIKE ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, "%" + titulo + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tituloLibro = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                boolean disponible = rs.getBoolean("disponible");
                Libro libro = new Libro(id, tituloLibro, autor, genero, disponible);
                resultados.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mostrarResultados(resultados);
    }

    // Método para mostrar los resultados de la búsqueda
    private void mostrarResultados(List<Libro> libros) {
        outputArea.setText("");
        if (libros.isEmpty()) {
            outputArea.append("No se encontraron resultados.");
        } else {
            for (Libro libro : libros) {
                outputArea.append(libro.toString() + "\n");
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Conectar a la base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contrasena = "1234";
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            Biblioteca biblioteca = new Biblioteca(conexion);
            biblioteca.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

