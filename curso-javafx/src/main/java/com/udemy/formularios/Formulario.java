package com.udemy.formularios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Formulario extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent contenedor = new FXMLLoader().load(getClass().getResource("FormularioDepartamento.fxml"));

        Scene escena = new Scene(contenedor, 700, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

}
