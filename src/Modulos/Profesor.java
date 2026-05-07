package Modulos;

public class Profesor {
    private int id_profesor;
    private String nombre;
    private String num_colegiado;
    private String email;
    private int id_departamento;

    public Profesor(int id_profesor, String nombre, String num_colegiado, String email, int id_departamento) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.num_colegiado = num_colegiado;
        this.email = email;
        this.id_departamento = id_departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id_profesor=" + id_profesor +
                ", nombre='" + nombre + '\'' +
                ", num_colegiado='" + num_colegiado + '\'' +
                ", email='" + email + '\'' +
                ", id_departamento=" + id_departamento +
                '}';
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_colegiado() {
        return num_colegiado;
    }

    public void setNum_colegiado(String num_colegiado) {
        this.num_colegiado = num_colegiado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Profesor() {
    }
}
