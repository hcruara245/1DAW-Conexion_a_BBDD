package Vista.GUI;

import Modulos.Alumno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VentanaListado extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<String> comboCursos;
    private JButton btnRefrescar, btnAnadir;

    public VentanaListado() {
        setTitle("Listado de Alumnos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(new JLabel("Filtrar por curso:"));
        comboCursos = new JComboBox<>(new String[]{"Todos los cursos", "1º DAM", "2º DAM"}); // Ejemplo
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
    }

    public void cargarDatos(ArrayList<Alumno> listaAlumnos) {
        for (Alumno a : listaAlumnos) {
            Object[] fila = {
                    a.getNombre(),
                    a.getEmail(),
                    a.getIsMayorEdad() == 1 ? "Si" : "No",
                    a.getId_curso(),
                    "Editar"
            };
            modelo.addRow(fila);
        }
    }
}
