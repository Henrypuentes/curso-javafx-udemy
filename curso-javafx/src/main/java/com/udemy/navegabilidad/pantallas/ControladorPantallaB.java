package com.udemy.navegabilidad.pantallas;

import com.udemy.navegabilidad.layout.ControladorConNavegabilidad;

/**
 * Created by rene on 21/06/16.
 */
public class ControladorPantallaB extends ControladorConNavegabilidad {

    public void mostrarPantalla() {
        this.layout.mostrarComoPantallaActual("a");
    }
}
