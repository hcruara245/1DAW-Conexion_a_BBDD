package Vista.Consola;

import Controlador.AlumnoDAO;
import Modulos.Alumno;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO dao = new AlumnoDAO();

        System.out.println("\n--- INICIO DE PRUEBAS PROFESOR ---");

        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre("Juan Pérez");
        nuevoAlumno.setEmail("juan.perez@email.com");
        nuevoAlumno.setIsMayorEdad(1);
        nuevoAlumno.setId_curso(1);

        System.out.println("Insertando alumno...");
        dao.insertar(nuevoAlumno);

        System.out.println("\n--- FIN DE PRUEBAS ---");
    }
}
