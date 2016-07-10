package com.udemy.borderpane;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rene on 21/06/16.
 */
public class BorderPaneCodigo extends BorderPane {

    public BorderPaneCodigo(){
        cargarSeccionSuperior();
        cargarSeccionInferior();
        cargarLadoIzquierdo();
        cargarLadoDerecho();
        cargarSeccionCentral();
    }

    private void cargarSeccionCentral() {
        StackPane contenedor = new StackPane();
        contenedor.setStyle("-fx-background-color: white;");
        setCenter(contenedor);
    }

    private void cargarLadoDerecho() {
        Text texto = new Text("Right");
        StackPane stackPane = new StackPane(texto);
        stackPane.setStyle("-fx-background-color: #eeee;");
        stackPane.setMinSize(150, Region.USE_COMPUTED_SIZE);
        setRight(stackPane);
    }

    private void cargarLadoIzquierdo() {
        Text texto = new Text("Left");
        StackPane stackPane = new StackPane(texto);
        stackPane.setStyle("-fx-background-color: #eeee;");
        stackPane.setMinSize(150, Region.USE_COMPUTED_SIZE);
        setLeft(stackPane);
    }

    private void cargarSeccionInferior() {
        Text texto = new Text("Bottom");
        texto.setFill(Color.WHITE);
        StackPane contenedor = new StackPane(texto);
        contenedor.setStyle("-fx-background-color: #489CDF;");
        contenedor.setPrefHeight(50);
        setBottom(contenedor);
    }

    private void cargarSeccionSuperior() {
        Text texto = new Text("Top");
        texto.setFont(Font.font("Cambria", FontWeight.BOLD, 32));
        texto.setFill(Color.WHITE);
        StackPane contenedor = new StackPane(texto);
        contenedor.setStyle("-fx-background-color: #489CDF;");
        contenedor.setPrefHeight(80);
        setTop(contenedor);
    }


}
