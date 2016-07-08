package com.udemy.rrhh.empleados;


import com.udemy.domain.Departamento;
import com.udemy.domain.Empleado;
import com.udemy.persistencia.dao.DepartamentoDao;
import com.udemy.persistencia.dao.EmpleadoDao;
import com.udemy.rrhh.combobox.ConvertidorComboBoxDepartamento;
import com.udemy.rrhh.combobox.ImagenListCell;
import com.udemy.rrhh.layout.ControladorConNavegabilidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rene on 22/06/16.
 */
public class AdministracionEmpleadosControlador extends ControladorConNavegabilidad implements Initializable {

    @FXML
    TextField nombre, apellido;

    @FXML
    DatePicker fechaContratacion;

    @FXML
    TextArea experiencia;

    @FXML
    ComboBox<Departamento> departamentos;

    @FXML
    ComboBox<String> generos;

    @FXML
    TableView<Empleado> tablaEmpleados;

    EmpleadoDao empleadoDao;
    DepartamentoDao departamentoDao;

    int id;

    public void guardar() {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setNombre(nombre.getText());
        empleado.setApellido(apellido.getText());
        LocalDate localDate = fechaContratacion.getValue();
        empleado.setFechaContratacion(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        empleado.setExperiencia(experiencia.getText());
        empleado.setIdDepartamento(departamentos.getValue().getId());
        empleado.setGenero(generos.getValue());
        empleadoDao.guardarOActualizar(empleado);
        id = 0;

        cargarEmpleadosDeLaBase();

        nombre.clear();
        apellido.clear();
        fechaContratacion.setValue(null);
        experiencia.clear();
        generos.setValue(null);
        departamentos.setValue(null);
    }

    private void cargarEmpleadosDeLaBase() {
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        List<Empleado> empleadosEncontrados = empleadoDao.buscarTodos();
        empleados.addAll(empleadosEncontrados);
        tablaEmpleados.setItems(empleados);
    }

    private void configurarTamanioColumnas() {
        tablaEmpleados.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<TableColumn<Empleado, ?>> columnas = tablaEmpleados.getColumns();
        columnas.get(0).setMaxWidth(1f * Integer.MAX_VALUE * 20); // 20%
        columnas.get(1).setMaxWidth(1f * Integer.MAX_VALUE * 40); // 40%
        columnas.get(2).setMaxWidth(1f * Integer.MAX_VALUE * 40); // 40%
    }


    public void editar() {
        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        nombre.setText(empleado.getNombre());
        apellido.setText(empleado.getApellido());
        experiencia.setText(empleado.getExperiencia());

        Date date = empleado.getFechaContratacion();
        LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate();
        fechaContratacion.setValue(localDate);
        generos.setValue(empleado.getGenero());
        id = empleado.getId();

        List<Departamento> itemsDepartamentos = departamentos.getItems();
        for (Departamento departamento: itemsDepartamentos){
            if(departamento.getId()==empleado.getIdDepartamento()){
                departamentos.setValue(departamento);
                return;
            }
        }
    }

    public void eliminar() {
        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        empleadoDao.eliminar(empleado);
        cargarEmpleadosDeLaBase();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        empleadoDao = new EmpleadoDao();
        departamentoDao = new DepartamentoDao();
        cargarEmpleadosDeLaBase();
        configurarTamanioColumnas();

        List<Departamento> departamentosEncontrados = departamentoDao.buscarTodos();
        departamentos.setConverter(new ConvertidorComboBoxDepartamento());
        departamentos.getItems().addAll(departamentosEncontrados);

        // Permite mostrar una imagen por cada elemento en el ComboBox
        generos.setCellFactory(listView -> new ImagenListCell());
        // Permite saber que imagen mostrar de acuerdo al item seleccionado
        generos.setButtonCell(new ImagenListCell());
    }

}
