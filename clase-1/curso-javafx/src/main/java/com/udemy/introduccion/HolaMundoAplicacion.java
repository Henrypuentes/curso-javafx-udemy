package com.udemy.introduccion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by moe on 6/13/16.
 */
public class HolaMundoAplicacion extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text texto = new Text("Hola mundo");
        texto.setFont(Font.font("Cambria", FontWeight.BOLD, 32));
        texto.setFill(Color.GREEN);
        Reflection efectoDeReflexion = new Reflection();
        efectoDeReflexion.setFraction(0.7f);
        texto.setEffect(efectoDeReflexion);

        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(texto);

        Scene escena = new Scene(contenedor, 500, 500);

        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
