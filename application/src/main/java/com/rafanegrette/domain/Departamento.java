package com.rafanegrette.domain;

public class Departamento {

    private final String name;
    private final Integer homicides;


    public Departamento(String name, Integer homicides) {
        this.name = name;
        this.homicides = homicides;
    }

    public String getName() {
        return name;
    }

    public Integer getHomicides() {
        return homicides;
    }
}
