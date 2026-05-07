package Controlador;

import Modulos.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> obtenerTodos() {
        List<Curso> cursos = new ArrayList<>();
        // Añadimos 'nivel' a la consulta
        String sql = "SELECT id_curso, nombre, abreviatura, nivel FROM curso";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setId_curso(rs.getInt("id_curso"));
                c.setNombre(rs.getString("nombre"));
                c.setAbreviatura(rs.getString("abreviatura"));
                c.setNivel(rs.getInt("nivel")); // <--- No olvides guardar el nivel
                cursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
