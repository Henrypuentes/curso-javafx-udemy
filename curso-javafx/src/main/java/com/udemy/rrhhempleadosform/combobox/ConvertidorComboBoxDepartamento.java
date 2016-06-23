package com.udemy.rrhhempleadosform.combobox;

import com.udemy.tablas.Departamento;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rene on 22/06/16.
 */
public class ConvertidorComboBoxDepartamento extends StringConverter<Departamento> {

    Map<Integer, Departamento> departamentos = new HashMap<Integer, Departamento>();

    @Override
    public String toString(Departamento departamento) {
        departamentos.put(departamento.getId(), departamento);
        return departamento.getNombre();
    }

    @Override
    public Departamento fromString(String arg) {
        return null;
    }
}
