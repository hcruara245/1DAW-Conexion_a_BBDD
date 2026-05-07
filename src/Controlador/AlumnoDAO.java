package Controlador;

import Modulos.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {

    public void insertar(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, email, isMayorEdad, id_curso) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, alumno.getNombre());
            pst.setString(2, alumno.getEmail());
            pst.setInt(3, alumno.getIsMayorEdad());
            pst.setInt(4, alumno.getId_curso());

            pst.executeUpdate();
            System.out.println("Alumno guardado con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    /*public ArrayList<Alumno> getAllAlumnos() {

    }*/
}
