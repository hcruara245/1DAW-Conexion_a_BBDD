package Vista.GUI;

import Controlador.AlumnoDAO;
import Modulos.Alumno;

import java.util.List;

public class MainGui {
    public static void main(String[] args) {
        // DEJAR ESTO ASÍ PARA IR VIENDO DATOS
        VentanaListado ventanaListado = new VentanaListado();
        AlumnoDAO  alumnoDAO = new AlumnoDAO();
        ventanaListado.setVisible(true);

        // SE PONEN TODOS LOS ALUMNOS
        List<Alumno> alumnos = alumnoDAO.listarTodosConCurso();
        ventanaListado.cargarDatos(alumnos);
    }
}
