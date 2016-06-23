package com.udemy.rrhhdepartamentos.barramenu;


import com.udemy.rrhhdepartamentos.layout.ControladorConNavegabilidad;

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
}
