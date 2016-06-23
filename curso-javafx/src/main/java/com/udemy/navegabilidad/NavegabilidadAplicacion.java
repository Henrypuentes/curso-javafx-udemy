package com.udemy.navegabilidad;

import com.udemy.navegabilidad.layout.LayoutPane;
import com.udemy.navegabilidad.pantallas.ControladorPantallaA;
import com.udemy.navegabilidad.pantallas.ControladorPantallaB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by rene on 21/06/16.
 */
public class NavegabilidadAplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LayoutPane layoutPane = new LayoutPane();
        layoutPane.cargarPantalla("a", ControladorPantallaA.class.getResource("PantallaA.fxml"));
        layoutPane.cargarPantalla("b", ControladorPantallaB.class.getResource("PantallaB.fxml"));

        layoutPane.mostrarComoPantallaActual("a");

        Scene escena = new Scene(layoutPane, 900, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
