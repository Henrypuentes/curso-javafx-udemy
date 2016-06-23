package com.udemy.rrhhdepartamentos;


import com.udemy.rrhhdepartamentos.departamentos.AdministracionDepartamentosControlador;
import com.udemy.rrhhdepartamentos.barramenu.BarraMenuControlador;
import com.udemy.rrhhdepartamentos.empleados.AdministracionEmpleadosControlador;
import com.udemy.rrhhdepartamentos.layout.LayoutPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by rene on 21/06/16.
 */
public class RRHHAplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LayoutPane layoutPane = new LayoutPane();

        layoutPane.cargarPantalla("departamentos", AdministracionDepartamentosControlador.class.getResource("AdministracionDepartamentos.fxml"));
        layoutPane.cargarPantalla("empleados", AdministracionEmpleadosControlador.class.getResource("AdministracionEmpleados.fxml"));
        layoutPane.cargarPantalla("menu", BarraMenuControlador.class.getResource("BarraMenu.fxml"));

        layoutPane.cargarBarraDeMenuEnLaPartePosterior();

        Scene escena = new Scene(layoutPane, 900, 400);
        escena.getStylesheets().addAll(getClass().getResource("estilos.css").toExternalForm());
        primaryStage.setScene(escena);
        primaryStage.show();
    }

}
