package com.udemy.persistencia.dao;

import com.udemy.tablas.Departamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rene on 21/06/16.
 */
public class EmpleadoDao {

    public static final String URL_CONEXION = "jdbc:h2:./target/demo";
    public static final String USUARIO_BDD = "sa";
    public static final String PASSWORD_BDD = "";

    public EmpleadoDao() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS empleado" +
                    "(id INTEGER auto_increment, " +
                    " nombre VARCHAR(255), " +
                    " apellido VARCHAR(255), " +
                    " fecha_contratacion DATE, " +
                    " genero VARCHAR(255), " +
                    " experiencia_laboral VARCHAR(255)," +
                    " id_departamento INTEGER, " +
                    " FOREIGN KEY (id_departamento)" +
                    " REFERENCES public.departamento(id))";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarOActualizar(Departamento departamento) {
        if (departamento.getId() == 0) {
            guardar(departamento);
        } else {
            actualizar(departamento);
        }
    }

    public void guardar(Departamento departamento) {
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "INSERT INTO departamento(nombre, descripcion) "
                    + "VALUES ('" + departamento.getNombre() + "', '" + departamento.getDescripcion() + "')";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al guardar la informacion: " + e.getMessage());
        }
    }

    public void actualizar(Departamento departamento) {
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "UPDATE departamento set nombre='" + departamento.getNombre() +
                    "', descripcion='" + departamento.getDescripcion() + "' WHERE id=" + departamento.getId();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al actualizar la informacion: " + e.getMessage());
        }
    }

    public List<Departamento> buscarTodos() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "SELECT * FROM departamento ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setDescripcion(resultSet.getString("descripcion"));
                departamento.setNombre(resultSet.getString("nombre"));
                departamento.setId(resultSet.getInt("id"));
                departamentos.add(departamento);
            }
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al consultar la informacion: " + e.getMessage());
        }
        return departamentos;
    }

    public void eliminar(Departamento departamento) {
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "DELETE FROM departamento WHERE id=" + departamento.getId();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al eliminar la informacion: " + e.getMessage());
        }
    }
}
