package com.udemy.rrhh.login;

import com.udemy.persistencia.dao.UsuarioDao;
import com.udemy.rrhh.layout.ControladorConNavegabilidad;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by moe on 7/10/16.
 */
public class LoginControlador extends ControladorConNavegabilidad {

    UsuarioDao usuarioDao;

    @FXML
    TextField nombreUsuario;

    @FXML
    PasswordField password;

    @FXML
    Text error;

    public LoginControlador() {
        usuarioDao = new UsuarioDao();
    }

    public void login() {
        boolean loginOK = usuarioDao.existeUsuario(nombreUsuario.getText(), password.getText());
        if (loginOK) {
            layout.cargarBarraDeMenuEnLaPartePosterior();
            Stage stage = (Stage) layout.getScene().getWindow();
            stage.hide();

            layout.mostrarComoPantallaActual("departamentos");
            stage = new Stage();
            stage.setScene(layout.getScene());
            stage.setMaximized(true);
            stage.show();
        } else {
            error.setText("Las credenciales ingresadas son incorrectas");
        }
    }

    public void cancelar() {
        Platform.exit();
    }
}
