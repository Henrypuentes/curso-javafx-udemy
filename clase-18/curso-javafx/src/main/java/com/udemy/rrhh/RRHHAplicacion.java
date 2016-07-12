package com.udemy.rrhh;


import com.udemy.rrhh.barramenu.BarraMenuControlador;
import com.udemy.rrhh.departamentos.AdministracionDepartamentosControlador;
import com.udemy.rrhh.empleados.AdministracionEmpleadosControlador;
import com.udemy.rrhh.layout.LayoutPane;
import com.udemy.rrhh.login.LoginControlador;
import com.udemy.rrhh.reporte.EmpleadosPorDepartamentoControlador;
import com.udemy.rrhh.webview.WebviewControlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by rene on 21/06/16.
 */
public class RRHHAplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LayoutPane layoutPane = new LayoutPane();
        layoutPane.cargarPantalla("departamentos", AdministracionDepartamentosControlador.class.getResource("AdministracionDepartamentos.fxml"));
        layoutPane.cargarPantalla("empleados", AdministracionEmpleadosControlador.class.getResource("AdministracionEmpleados.fxml"));
        layoutPane.cargarPantalla("chart", EmpleadosPorDepartamentoControlador.class.getResource("EmpleadosPorDepartamento.fxml"));
        layoutPane.cargarPantalla("menu", BarraMenuControlador.class.getResource("BarraMenu.fxml"));
        layoutPane.cargarPantalla("webview", WebviewControlador.class.getResource("WebView.fxml"));
        layoutPane.cargarPantalla("login", LoginControlador.class.getResource("Login.fxml"));

        layoutPane.mostrarComoPantallaActual("login");

        Scene escena = new Scene(layoutPane);
        escena.getStylesheets().add("bootstrapfx.css");
        primaryStage.setScene(escena);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }
}
