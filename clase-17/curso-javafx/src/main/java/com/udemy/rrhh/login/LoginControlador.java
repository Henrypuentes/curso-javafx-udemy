package com.udemy.rrhh.login;

import com.udemy.rrhh.layout.ControladorConNavegabilidad;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginControlador extends ControladorConNavegabilidad {

    @FXML
    Text error;

    public void login() {
        error.setText("Las credenciales ingresadas son incorrectas");
    }

    public void cancelar() {
        Platform.exit();
    }
}
