package com.udemy.borderpane;

import com.udemy.navegabilidad.layout.ControladorConNavegabilidad;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rene on 21/06/16.
 */
public class BorderPaneCodigo extends BorderPane {

    private Map<String, Node> pantallasDeLaAplicacion;

    public BorderPaneCodigo(){
        this.pantallasDeLaAplicacion = new HashMap<>();
        cargarSeccionSuperior();
        cargarSeccionInferior();
        cargarLadoIzquierdoYDerecho();
        cargarSeccionCentral();
    }

    private void cargarSeccionCentral() {
        StackPane contenedor = new StackPane();
        contenedor.setStyle("-fx-background-color: white;");
        setCenter(contenedor);
    }

    private void cargarLadoIzquierdoYDerecho() {
        StackPane contenedor = new StackPane();
        contenedor.setStyle("-fx-background-color: #eeee;");
        contenedor.minHeight(150);
        setLeft(contenedor);
        setRight(contenedor);
    }

    private void cargarSeccionInferior() {
        Text texto = new Text("Todos los derechos reservados");
        texto.setFill(Color.WHITE);

        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(texto);
        contenedor.setStyle("-fx-background-color: #489CDF;");
        contenedor.minHeight(50);

        setBottom(contenedor);
    }

    private void cargarSeccionSuperior() {

        Text texto = new Text("Demo");
        texto.setFont(Font.font("Cambria", FontWeight.BOLD, 32));
        texto.setFill(Color.WHITE);

        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(texto);
        contenedor.setStyle("-fx-background-color: #489CDF;");
        contenedor.minHeight(80);

        setTop(contenedor);
    }

    public void cargarPantalla(String nombreDeLaPantalla, URL urlArchivoFxml) throws IOException{
        FXMLLoader cargadorPantallas = new FXMLLoader(urlArchivoFxml);
        Parent pantalla = cargadorPantallas.load();

        ControladorConNavegabilidad controladorConNavegabilidad = cargadorPantallas.getController();
        controladorConNavegabilidad.setLayout(this);

        pantallasDeLaAplicacion.put(nombreDeLaPantalla, pantalla);
    }

    public void mostrarComoPantallaActual(String nombreDeLaPantalla) {
        this.setCenter(pantallasDeLaAplicacion.get(nombreDeLaPantalla));
    }
}
