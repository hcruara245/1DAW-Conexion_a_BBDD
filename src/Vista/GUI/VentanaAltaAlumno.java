package Vista.GUI;

import Modulos.Alumno;
import Controlador.AlumnoDAO;
import javax.swing.*;
import java.awt.*;

public class VentanaAltaAlumno extends JDialog {
    private JTextField txtNombre, txtEmail, txtIdCurso;
    private JCheckBox chkMayor;
    private JButton btnGuardar, btnCancelar;
    private boolean guardadoExitoso = false;

    public VentanaAltaAlumno(Frame padre) {
        super(padre, "Añadir Nuevo Alumno", true);
        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(350, 250);
        setLocationRelativeTo(padre);

        txtNombre = new JTextField();
        txtEmail = new JTextField();
        chkMayor = new JCheckBox("Sí");
        txtIdCurso = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        add(new JLabel(" Nombre:")); add(txtNombre);
        add(new JLabel(" Email:")); add(txtEmail);
        add(new JLabel(" ¿Mayor de edad?:")); add(chkMayor);
        add(new JLabel(" ID Curso (nº):")); add(txtIdCurso);
        add(btnGuardar); add(btnCancelar);

        btnGuardar.addActionListener(e -> accionGuardar());

        btnCancelar.addActionListener(e -> dispose());
    }

    private void accionGuardar() {
        try {
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim().toLowerCase();
            int idCurso = Integer.parseInt(txtIdCurso.getText().trim());

            if (nombre.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Rellena todos los campos");
                return;
            }

            Alumno nuevo = new Alumno();
            nuevo.setNombre(nombre);
            nuevo.setEmail(email);
            nuevo.setIsMayorEdad(chkMayor.isSelected() ? 1 : 0);
            nuevo.setId_curso(idCurso);

            AlumnoDAO dao = new AlumnoDAO();
            if (dao.insertarAlumno(nuevo)) {
                guardadoExitoso = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al insertar en la BD");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID del curso debe ser un número");
        }
    }

    public boolean isGuardadoExitoso() {
        return guardadoExitoso;
    }
}
