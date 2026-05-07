package Modulos;

public class Curso {
    private int id_curso;
    private String nombre;
    private String abreviatura;
    private int isGradoSuperior;
    private int nivel;
    private int id_tutor;

    public int getNivel() {
        return nivel;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Curso() {}

    public Curso(int id_curso, String nombre) {
        this.id_curso = id_curso;
        this.nombre = nombre;
    }

    public int getId_curso() { return id_curso; }
    public void setId_curso(int id_curso) { this.id_curso = id_curso; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return this.nivel + " - " + this.abreviatura;
    }
}
