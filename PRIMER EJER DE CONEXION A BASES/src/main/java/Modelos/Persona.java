package Modelos;

public class Persona {
        private String dni;
        private String nombre;
        private String apellidos;
        private String sexo;
        private int altura;
        private double peso;

        public Persona(String dni, String nombre, String apellidos, String sexo, int altura, double peso) {
                this.dni = dni;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.sexo = sexo;
                this.altura = altura;
                this.peso = peso;
        }

        public Persona() {
        }

        public String getDni() {
                return dni;
        }

        public void setDni(String dni) {
                this.dni = dni;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellidos() {
                return apellidos;
        }

        public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
        }

        public String getSexo() {
                return sexo;
        }

        public void setSexo(String sexo) {
                this.sexo = sexo;
        }

        public int getAltura() {
                return altura;
        }

        public void setAltura(int altura) {
                this.altura = altura;
        }

        public double getPeso() {
                return peso;
        }

        public void setPeso(double peso) {
                this.peso = peso;
        }

        @Override
        public String toString() {
                return "Personas{" +
                                "dni='" + dni + '\'' +
                                ", nombre='" + nombre + '\'' +
                                ", apellidos='" + apellidos + '\'' +
                                ", sexo='" + sexo + '\'' +
                                ", altura=" + altura +
                                ", peso=" + peso +
                                '}';
        }
}
