package com.udemy.persistencia.dao;

import com.udemy.domain.Departamento;
import com.udemy.domain.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moe on 6/30/16.
 */
public class EmpleadoDao {


    public EmpleadoDao() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        try (Connection conexionDB = DriverManager.getConnection(DepartamentoDao.URL_CONEXION, DepartamentoDao.USUARIO_BDD, DepartamentoDao.PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS empleado" +
                    "(id INTEGER auto_increment, " +
                    " id_departamento INTEGER, " +
                    " nombre VARCHAR(255), " +
                    " apellido VARCHAR(255), " +
                    " fecha_contratacion TIMESTAMP, " +
                    " experiencia VARCHAR(255), " +
                    " genero VARCHAR(255), " +
                    " FOREIGN KEY (id_departamento) REFERENCES departamento(id)  )";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarOActualizar(Empleado empleado) {
        if (empleado.getId() == 0) {
            guardar(empleado);
        } else {
            actualizar(empleado);
        }
    }

    public void guardar(Empleado empleado) {
        try (Connection conexionDB = DriverManager.getConnection(DepartamentoDao.URL_CONEXION, DepartamentoDao.USUARIO_BDD, DepartamentoDao.PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "INSERT INTO empleado(nombre, id_departamento, apellido, fecha_contratacion, experiencia, genero) "
                    + "VALUES ('" + empleado.getNombre() + "', " + empleado.getIdDepartamento() + ", '"
                    + empleado.getApellido() + "', '" + new Timestamp(empleado.getFechaContratacion().getTime())
                    + "', '" + empleado.getExperiencia() + "', '" + empleado.getGenero() + "')";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al guardar la informacion: " + e.getMessage());
        }
    }

    public void actualizar(Empleado empleado) {
        try (Connection conexionDB = DriverManager.getConnection(DepartamentoDao.URL_CONEXION, DepartamentoDao.USUARIO_BDD, DepartamentoDao.PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "UPDATE empleado set nombre='" + empleado.getNombre() +
                    "', apellido='" + empleado.getApellido() +
                    "', experiencia='" + empleado.getExperiencia() +
                    "', genero='" + empleado.getGenero() +
                    "', fecha_contratacion='" + new Timestamp(empleado.getFechaContratacion().getTime()) +
                    "', id_departamento=" + empleado.getIdDepartamento() +
                    " WHERE id=" + empleado.getId();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al actualizar la informacion: " + e.getMessage());
        }
    }

    public List<Empleado> buscarTodos() {
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conexionDB = DriverManager.getConnection(DepartamentoDao.URL_CONEXION, DepartamentoDao.USUARIO_BDD, DepartamentoDao.PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "SELECT * FROM empleado ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setApellido(resultSet.getString("apellido"));
                empleado.setExperiencia(resultSet.getString("experiencia"));
                empleado.setGenero(resultSet.getString("genero"));
                empleado.setFechaContratacion(resultSet.getDate("fecha_contratacion"));
                empleado.setIdDepartamento(resultSet.getInt("id_departamento"));
                empleado.setId(resultSet.getInt("id"));
                empleados.add(empleado);
            }
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al consultar la informacion: " + e.getMessage());
        }
        return empleados;
    }

    public void eliminar(Empleado empleado) {
        try (Connection conexionDB = DriverManager.getConnection(DepartamentoDao.URL_CONEXION, DepartamentoDao.USUARIO_BDD, DepartamentoDao.PASSWORD_BDD)) {
            Statement statement = conexionDB.createStatement();
            String sql = "DELETE FROM empleado WHERE id=" + empleado.getId();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error al eliminar la informacion: " + e.getMessage());
        }
    }
}
