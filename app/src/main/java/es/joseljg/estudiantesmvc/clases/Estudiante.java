package es.joseljg.estudiantesmvc.clases;


import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable {
    //---------------------------------------------------

    private String dni;
    private String nombre;
    private String curso;
    private String fechan;
    private String horap;
    //---------------------------------------------------
    public Estudiante(String dni, String nombre, String curso, String fechan, String horap) {
        this.dni = dni;
        this.nombre = nombre;
        this.curso = curso;
        this.fechan = fechan;
        this.horap = horap;
    }
    //---------------------------------------------------
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFechan() {
        return fechan;
    }

    public void setFechan(String fechan) {
        this.fechan = fechan;
    }

    public String getHorap() {
        return horap;
    }

    public void setHorap(String horap) {
        this.horap = horap;
    }
    //--------------------------------------------------------
    @Override
    public String toString() {
        return "Estudiante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", fechan='" + fechan + '\'' +
                ", horap='" + horap + '\'' +
                '}';
    }
    //---------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    //---------------------------------------------------------
}
