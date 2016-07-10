package com.udemy.rrhh.barramenu;


import com.udemy.rrhh.layout.ControladorConNavegabilidad;

/**
 * Created by rene on 22/06/16.
 */
public class BarraMenuControlador extends ControladorConNavegabilidad {

    public void mostrarPantallaDepartamentos() {
        this.layout.mostrarComoPantallaActual("departamentos");
    }

    public void mostrarPantallaEmpleados() {
        this.layout.mostrarComoPantallaActual("empleados");
    }

    public void mostrarPantallaChart() {
        this.layout.mostrarComoPantallaActual("chart");
    }
}
