package Modulos;

public class Alumno {
    private int id_alumno;
    private String nombre;
    private String email;
    private int isMayorEdad;
    private int id_curso;

    public Alumno(int id_alumno, String nombre, String email, int isMayorEdad, int id_curso) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.email = email;
        this.isMayorEdad = isMayorEdad;
        this.id_curso = id_curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id_alumno=" + id_alumno +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", isMayorEdad=" + isMayorEdad +
                ", id_curso=" + id_curso +
                '}';
    }

    public Alumno() {
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsMayorEdad() {
        return isMayorEdad;
    }

    public void setIsMayorEdad(int isMayorEdad) {
        this.isMayorEdad = isMayorEdad;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
}
