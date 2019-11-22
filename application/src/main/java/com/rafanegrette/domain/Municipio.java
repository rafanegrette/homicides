package com.rafanegrette.domain;

public class Municipio {

    private final String nombre;
    private final Integer homicidios;
    private final Departamento departamento;

    public Municipio(String nombre, Integer homicidios, Departamento departamento) {
        this.nombre = nombre;
        this.homicidios = homicidios;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getHomicidios() {
        return homicidios;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
