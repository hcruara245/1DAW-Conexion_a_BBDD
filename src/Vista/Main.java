package Vista;

import Controlador.AlumnoDAO;
import Controlador.ProfesorDAO;
import Modulos.Alumno;
import Modulos.Profesor;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO dao = new AlumnoDAO();
        ProfesorDAO daoprof = new ProfesorDAO();

        System.out.println("\n--- INICIO DE PRUEBAS PROFESOR ---");

        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre("Juan Pérez");
        nuevoAlumno.setEmail("juan.perez@email.com");
        nuevoAlumno.setIsMayorEdad(1);
        nuevoAlumno.setId_curso(1);

        System.out.println("Insertando alumno...");
        dao.insertar(nuevoAlumno);

        int idABuscar = 1;
        System.out.println("\nBuscando alumno con ID: " + idABuscar + "...");

        Alumno alumnoEncontrado = dao.buscarPorId(idABuscar);

        if (alumnoEncontrado != null) {
            System.out.println("¡Alumno encontrado!");
            System.out.println(alumnoEncontrado.toString());
        } else {
            System.out.println("No se encontró ningún alumno con el ID: " + idABuscar);
        }

        System.out.println("\n--- FIN DE PRUEBAS ---");

        System.out.println("--- INICIO DE PRUEBAS PROFESOR ---");

        Profesor profesor = new Profesor(67,"HUGO CRUZ","2999","huguito@gmaill.com",1);

        System.out.println("Insertando profesor...");
        daoprof.insertar(profesor);

        int idProfBuscar = 1;
        System.out.println("\nBuscando profesor con ID: " + idProfBuscar + "...");

        Profesor profesorencontrado = daoprof.buscarPorId(idProfBuscar);

        if (profesorencontrado != null) {
            System.out.println("¡Alumno encontrado!");
            System.out.println(profesorencontrado);
        } else {
            System.out.println("No se encontró ningún profesor con el ID: " + idProfBuscar);
        }

        System.out.println("\n--- FIN DE PRUEBAS ---");
    }
}
