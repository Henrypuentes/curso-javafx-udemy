package com.udemy.formularios;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorFormularioDepartamento {

    @FXML
    TextField nombre;

    @FXML
    TextArea descripcion;

    public void guardar() {
        System.out.println("+++GUARDANDO INFORMACION DEL DEPARTAMENTO+++");
        System.out.println("Nombre: " + nombre.getText());
        System.out.println("Descripcion: " + descripcion.getText());

        nombre.clear();
        descripcion.clear();
    }
}
