package Controlador;

import Modulos.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public void listar(){
        List<Profesor> lista = new ArrayList<>();
        String sql = "SELECT * FROM profesor";
        Profesor p = null;

        try (Connection connection = Conexion.getConexion();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                p = new Profesor();
                p.setId_profesor(resultSet.getInt("id_profesor"));
                p.setNombre(resultSet.getString("nombre"));
                p.setNum_colegiado(resultSet.getString("num_colegiado"));
                p.setEmail(resultSet.getString("email"));
                p.setId_departamento(resultSet.getInt("id_departamento"));
                lista.add(p);
                p = null;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar: " + e.getMessage());
        }

        System.out.println(lista);
    }

    public void insertar(Profesor profesor) {
        String sql = "INSERT INTO profesor (id_profesor, nombre, num_colegiado, email, id_departamento) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, profesor.getId_profesor());
            pst.setString(2, profesor.getNombre());
            pst.setString(3, profesor.getNum_colegiado());
            pst.setString(4, profesor.getEmail());
            pst.setInt(5, profesor.getId_departamento());

            pst.executeUpdate();
            System.out.println("profesor guardado con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public Profesor buscarPorId(int id) {
        String sql = "SELECT * FROM profesor WHERE id_profesor = ?";
        Profesor profesor = null;

        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    profesor = new Profesor();
                    profesor.setId_profesor(rs.getInt("id_profesor"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setNum_colegiado(rs.getString("num_colegiado"));
                    profesor.setEmail(rs.getString("email"));
                    profesor.setId_departamento(rs.getInt("id_departamento"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar: " + e.getMessage());
        }

        return profesor;
    }
}
