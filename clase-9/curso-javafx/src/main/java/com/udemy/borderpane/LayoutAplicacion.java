package com.udemy.borderpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by rene on 21/06/16.
 */
public class LayoutAplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent contenedor = new FXMLLoader().load(getClass().getResource("Plantilla.fxml"));
        Scene escena = new Scene(contenedor, 900, 400);
//        Scene escena = new Scene(new BorderPaneCodigo(), 900, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
