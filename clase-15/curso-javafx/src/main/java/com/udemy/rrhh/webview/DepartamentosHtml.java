package com.udemy.rrhh.webview;

import com.udemy.domain.Departamento;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DepartamentosHtml {

    private String textoHtml;

    public DepartamentosHtml(List<Departamento> departamentos) {

        textoHtml = "<!DOCTYPE html><html><body><style>" +
                "div {" +
                "width: 680px; padding-top: 8px; padding-bottom: 15px;" +
                "margin: 0 auto 20px auto; background-color: #446bb3; border-radius: 15px;" +
                "-moz-border-radius: 15px; -webkit-border-radius: 15px; color: #446bb3; padding:10px;}" +
                "table { background-color: #fff; color: #443; width=670px; cellpadding=2; cellsapcing=2;}" +
                "thead { background-color: #446bb3  ; color : #fff; font: bold 14px verdana; padding:4px; line-height:30px}" +
                "tbody tr:nth-child(even) {background: #CCC;}" +
                "tbody tr:nth-child(odd) {background: #FFF}" +
                "th, td { width: 325px; }</style>" +
                "<h2>Departamentos</h2>" +
                "<div><table>" +
                "<thead><tr><th>Id</th><th>Nombre</th></tr></thead>" +
                "<tbody>" +
                "CONTENIDO_TABLA" +
                "</tbody>" +
                "</table></div></body></html>";

        String contenidoTabla = "";
        for (Departamento departamento : departamentos) {
            contenidoTabla += "<tr><td>" + departamento.getId() + "</td><td>"
                    + departamento.getNombre() + "</td></tr>";
        }

        textoHtml = textoHtml.replace("CONTENIDO_TABLA", contenidoTabla);
    }

    public void generarArchivoHtml() {
        try {
            Files.write(Paths.get("departamentos.html"), textoHtml.getBytes());
        } catch (Exception ex) {;
            throw new RuntimeException("No se pudo generar el archivo", ex);
        }
    }
}
