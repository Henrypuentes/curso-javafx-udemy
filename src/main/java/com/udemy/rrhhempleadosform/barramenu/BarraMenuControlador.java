package com.udemy.rrhhempleadosform.barramenu;


import com.udemy.rrhhempleadosform.layout.ControladorConNavegabilidad;

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
