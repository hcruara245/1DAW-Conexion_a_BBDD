package Vista.GUI;

import Controlador.AlumnoDAO;
import Controlador.CursoDAO;
import Modulos.Alumno;
import Modulos.Curso;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListado extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<Object> comboCursos;
    private JButton btnRefrescar, btnAnadir;

    public VentanaListado() {
        setTitle("Listado de Alumnos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(new JLabel("Filtrar por curso:"));
        comboCursos = new JComboBox<>();
        llenarComboCursos();
        btnRefrescar = new JButton("Refrescar");
        panelNorte.add(comboCursos);
        panelNorte.add(btnRefrescar);

        btnAnadir = new JButton("Añadir alumno");
        panelNorte.add(btnAnadir);

        String[] columnas = {"Nombre", "Email", "Mayor de edad", "Curso", "Acciones"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnRefrescar.addActionListener(e -> refrescarTabla());

        btnAnadir.addActionListener(e -> {
            VentanaAltaAlumno vAlta = new VentanaAltaAlumno(this);
            vAlta.setVisible(true);

            if (vAlta.isGuardadoExitoso()) {
                refrescarTabla();
            }
        });

        comboCursos.addActionListener(e -> {
            refrescarTabla();
        });

    }

    public void cargarDatos(List<Alumno> listaAlumnos) {
        modelo.setRowCount(0);
        for (Alumno a : listaAlumnos) {
            String dificultadYNombre = a.getNivel() + " - " + a.getNombreCurso();

            Object[] fila = {
                    a.getNombre(),
                    a.getEmail(),
                    (a.getIsMayorEdad() == 1) ? "Si" : "No",
                    dificultadYNombre,
                    "Editar" // NO TIENE UTILIDAD, ES PARA DECORACIÓN
            };
            modelo.addRow(fila);
        }
    }

    private void refrescarTabla() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        Object seleccionado = comboCursos.getSelectedItem();
        List<Alumno> lista;

        if (seleccionado instanceof Curso) {
            Curso c = (Curso) seleccionado;
            lista = alumnoDAO.listarPorIdCurso(c.getId_curso());
        } else {
            lista = alumnoDAO.listarTodosConCurso();
        }

        if (lista != null) {
            cargarDatos(lista);
        }
    }


    private void llenarComboCursos() {
        comboCursos.addItem("Todos los cursos");

        CursoDAO cursoDAO = new CursoDAO();
        for (Curso c : cursoDAO.obtenerTodos()) {
            comboCursos.addItem(c);
        }
    }
}
