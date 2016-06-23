package com.udemy.rrhhempleadosform.empleados;


import com.udemy.persistencia.dao.DepartamentoDao;
import com.udemy.rrhhempleadosform.combobox.ConvertidorComboBoxDepartamento;
import com.udemy.rrhhempleadosform.combobox.ImagenListCell;
import com.udemy.rrhhempleadosform.layout.ControladorConNavegabilidad;
import com.udemy.tablas.Departamento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rene on 22/06/16.
 */
public class AdministracionEmpleadosControlador extends ControladorConNavegabilidad implements Initializable {

    @FXML
    ComboBox<Departamento> departamentos;

    @FXML
    ComboBox generos;

    DepartamentoDao departamentoDao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        departamentoDao = new DepartamentoDao();
        List<Departamento> departamentosEncontrados = departamentoDao.buscarTodos();
        departamentos.setConverter(new ConvertidorComboBoxDepartamento());
        departamentos.getItems().addAll(departamentosEncontrados);

        // Permite mostrar una imagen por cada elemento en el ComboBox
        generos.setCellFactory(listView -> new ImagenListCell());
        // Permite saber que imagen mostrar de acuerdo al item seleccionado
        generos.setButtonCell(new ImagenListCell());
    }

}
