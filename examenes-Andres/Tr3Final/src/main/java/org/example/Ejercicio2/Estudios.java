package org.example.Ejercicio2;

public class Estudios {

        private String localidad;
        private float tasa_graduacion;
        private  float media_cursos_matriculados;
        private String tipo_estudio;
        private String estudio;
        private String sexo;
        private float tasa_abandono_inicial;
        private int alumnos_graduados;
        private int curso_academico;
        private int alumnos_graduados_en_tiempo;
        private float tasa_abandono;
        private int alumnos_interrumpen_estudios;
        private int alumnos_interrumpen_est_ano1;

        public String getLocalidad() {
                return localidad;
        }

        public float getTasa_graduacion() {
                return tasa_graduacion;
        }

        public float getMedia_cursos_matriculados() {
                return media_cursos_matriculados;
        }

        public String getTipo_estudio() {
                return tipo_estudio;
        }

        public String getEstudio() {
                return estudio;
        }

        public String getSexo() {
                return sexo;
        }

        public float getTasa_abandono_inicial() {
                return tasa_abandono_inicial;
        }

        public int getAlumnos_graduados() {
                return alumnos_graduados;
        }

        public int getCurso_academico() {
                return curso_academico;
        }

        public int getAlumnos_graduados_en_tiempo() {
                return alumnos_graduados_en_tiempo;
        }

        public float getTasa_abandono() {
                return tasa_abandono;
        }

        public int getAlumnos_interrumpen_estudios() {
                return alumnos_interrumpen_estudios;
        }

        public int getAlumnos_interrumpen_est_ano1() {
                return alumnos_interrumpen_est_ano1;
        }

        @Override
        public String toString() {
                return "Estudios{" +
                        "localidad='" + localidad + '\'' +
                        ", tasa_graduacion=" + tasa_graduacion +
                        ", media_cursos_matriculados=" + media_cursos_matriculados +
                        ", tipo_estudio='" + tipo_estudio + '\'' +
                        ", estudio='" + estudio + '\'' +
                        ", sexo='" + sexo + '\'' +
                        ", tasa_abandono_inicial=" + tasa_abandono_inicial +
                        ", alumnos_graduados=" + alumnos_graduados +
                        ", curso_academico=" + curso_academico +
                        ", alumnos_graduados_en_tiempo=" + alumnos_graduados_en_tiempo +
                        ", tasa_abandono=" + tasa_abandono +
                        ", alumnos_interrumpen_estudios=" + alumnos_interrumpen_estudios +
                        ", alumnos_interrumpen_est_ano1=" + alumnos_interrumpen_est_ano1 +
                        '}';
        }
}
