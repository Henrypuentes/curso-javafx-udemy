package com.udemy.eventos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by moe on 6/13/16.
 */
public class Eventos extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent contenedor = new FXMLLoader().load(getClass().getResource("Eventos.fxml"));

        Scene escena = new Scene(contenedor, 200, 100);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

}
