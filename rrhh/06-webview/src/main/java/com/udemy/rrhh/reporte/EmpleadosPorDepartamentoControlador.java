package com.udemy.rrhh.reporte;

import com.udemy.persistencia.dao.DepartamentoDao;
import com.udemy.rrhh.layout.ControladorConNavegabilidad;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.*;

/**
 * Created by moe on 7/4/16.
 */
public class EmpleadosPorDepartamentoControlador extends ControladorConNavegabilidad implements Initializable {

    DepartamentoDao departamentoDao;

    @FXML
    private PieChart chart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        departamentoDao = new DepartamentoDao();
        cargarDatosEnElChart();
    }

    public void cargarDatosEnElChart() {
        // Obtiene la informacion usando el dao
        Map<String, Integer> empleadosPorDepartamento = departamentoDao.contarEmpleadosPorDepartamento();

        ObservableList<PieChart.Data> datosParaElChart = FXCollections.observableArrayList();
        // Itera sobre el mapa y llena la coleccion para el Chart
        empleadosPorDepartamento.forEach((nombreDepartamento, cantidad) ->
        {
            PieChart.Data data = new PieChart.Data(nombreDepartamento, cantidad);
            datosParaElChart.add(data);
        });
        // Carga los datos en el chart
        chart.setData(datosParaElChart);
    }
}
