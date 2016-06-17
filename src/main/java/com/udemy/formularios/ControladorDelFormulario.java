package com.udemy.formularios;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorDelFormulario {

    @FXML
    TextField nombre, apellido;

    @FXML
    TextArea datosAdicionales;

    public void imprimirInformacion() {
        System.out.println("La informacion ingresada es:");
        System.out.println("Nombre: "+nombre.getText());
        System.out.println("Apellido: "+apellido.getText());
        System.out.println("Datos adicionales: "+datosAdicionales.getText());
    }
}
