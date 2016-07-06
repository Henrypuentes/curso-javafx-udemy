package com.udemy.rrhh.webview;

import com.udemy.persistencia.dao.DepartamentoDao;
import com.udemy.rrhh.layout.ControladorConNavegabilidad;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

/**
 * Created by moe on 7/5/16.
 */
public class WebviewControlador extends ControladorConNavegabilidad implements Initializable {

    @FXML
    private WebView webView;

    private DepartamentoDao departamentoDao;

    public void mostrarDepartamentosComoPdf() throws Exception {
        new DepartamentosHtml(departamentoDao.buscarTodos()).generarArchivoPdf();
        String url = getClass().getResource("pdfjs/web/viewer.html").toExternalForm();
        webView.getEngine().load(url);
    }

    public void mostrarDepartamentos() throws Exception {
        new DepartamentosHtml(departamentoDao.buscarTodos()).generarArchivoHtml();
        String url = Paths.get("departamentos.html").toUri().toURL().toExternalForm();
        webView.getEngine().load(url);
        webView.getEngine().load(url);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departamentoDao = new DepartamentoDao();
        webView.getEngine().load("http://www.google.com");
    }
}
