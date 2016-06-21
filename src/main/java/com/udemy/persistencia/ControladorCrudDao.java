package com.udemy.persistencia;

import com.udemy.persistencia.dao.DepartamentoDao;
import com.udemy.tablas.Departamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by moe on 6/17/16.
 */
public class ControladorCrudDao implements Initializable {

    @FXML
    TextField nombre;

    @FXML
    TextArea descripcion;

    @FXML
    TableView<Departamento> tablaDepartamentos;

    DepartamentoDao departamentoDao;

    int id = 0;

    public void guardar() {
        Departamento departamento = new Departamento();
        departamento.setId(id);
        departamento.setDescripcion(descripcion.getText());
        departamento.setNombre(nombre.getText());
        departamentoDao.guardarOActualizar(departamento);
        id = 0;

        cargarDepartamentosDeLaBase();

        nombre.clear();
        descripcion.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        departamentoDao = new DepartamentoDao();
        cargarDepartamentosDeLaBase();
        configurarTamanioColumnas();

    }

    private void cargarDepartamentosDeLaBase() {
        ObservableList<Departamento> departamentos = FXCollections.observableArrayList();
        List<Departamento> departamentosEncontrados = departamentoDao.buscarTodos();
        departamentos.addAll(departamentosEncontrados);
        tablaDepartamentos.setItems(departamentos);
    }

    private void configurarTamanioColumnas() {
        tablaDepartamentos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<TableColumn<Departamento, ?>> columnas = tablaDepartamentos.getColumns();
        columnas.get(0).setMaxWidth(1f * Integer.MAX_VALUE * 15); // 15%
        columnas.get(1).setMaxWidth(1f * Integer.MAX_VALUE * 25); // 25%
        columnas.get(2).setMaxWidth(1f * Integer.MAX_VALUE * 60); // 60%
    }


    public void editar() {
        Departamento departamento = tablaDepartamentos.getSelectionModel().getSelectedItem();
        nombre.setText(departamento.getNombre());
        descripcion.setText(departamento.getDescripcion());
        id = departamento.getId();
    }

    public void eliminar() {

        Departamento departamento = tablaDepartamentos.getSelectionModel().getSelectedItem();
        try (Connection conexionDB = DriverManager.getConnection("jdbc:h2:./target/demo", "sa", "")) {
            Statement statement = conexionDB.createStatement();
            String sql = "DELETE FROM departamento WHERE id=" + departamento.getId();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cargarDepartamentosDeLaBase();
    }
}


