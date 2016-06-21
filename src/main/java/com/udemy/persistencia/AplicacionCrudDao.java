package com.udemy.persistencia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AplicacionCrudDao extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent contenedor = new FXMLLoader().load(getClass().getResource("CrudDao.fxml"));

        Scene escena = new Scene(contenedor, 900, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

}
