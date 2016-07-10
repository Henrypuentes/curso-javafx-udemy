package com.udemy.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by moe on 6/13/16.
 */
public class HolaMundoFxml extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Buscar la hoja de papel y colocarla en la escena
        Parent contenedor = new FXMLLoader().load(getClass().getResource("HolaMundoConEstilos.fxml"));

        Scene escena = new Scene(contenedor, 500, 500);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

}
