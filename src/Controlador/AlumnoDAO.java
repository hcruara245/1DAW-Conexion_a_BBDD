package Controlador;

import Modulos.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Alumno> listarTodosConCurso() {
        List<Alumno> lista = new ArrayList<>();

        String sql = "SELECT a.*, c.nombre AS nombre_curso, c.nivel " +
                "FROM alumno a " +
                "INNER JOIN curso c ON a.id_curso = c.id_curso";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno al = new Alumno();
                al.setNombre(rs.getString("nombre"));
                al.setEmail(rs.getString("email"));
                al.setIsMayorEdad(rs.getInt("isMayorEdad"));
                al.setId_curso(rs.getInt("id_curso"));
                al.setNombreCurso(rs.getString("nombre_curso"));
                al.setNivel(rs.getInt("nivel"));
                al.setNombreCurso(rs.getString("nombre_curso"));

                lista.add(al);
            }
        } catch (SQLException e) {
            System.out.println("No se han podido listar los alumnos");
        }
        return lista;
    }

    public boolean insertarAlumno(Alumno al) {
        String sql = "INSERT INTO alumno (nombre, email, isMayorEdad, id_curso) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, al.getNombre());
            ps.setString(2, al.getEmail());
            ps.setInt(3, al.getIsMayorEdad());
            ps.setInt(4, al.getId_curso());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Alumno> listarPorIdCurso(int idCurso) {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT a.*, c.nombre AS nombre_curso, c.nivel " +
                "FROM alumno a " +
                "INNER JOIN curso c ON a.id_curso = c.id_curso " +
                "WHERE a.id_curso = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno();
                al.setNombre(rs.getString("nombre"));
                al.setEmail(rs.getString("email"));
                al.setIsMayorEdad(rs.getInt("isMayorEdad"));
                al.setId_curso(rs.getInt("id_curso"));
                al.setNombreCurso(rs.getString("nombre_curso"));
                al.setNivel(rs.getInt("nivel"));
                al.setNombreCurso(rs.getString("nombre_curso"));
                lista.add(al);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
