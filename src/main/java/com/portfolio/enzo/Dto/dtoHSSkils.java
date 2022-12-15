
package com.portfolio.enzo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHSSkils {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    private boolean circulo;
//creo los constructores

    public dtoHSSkils() {
    }

    public dtoHSSkils(String nombre, int porcentaje, boolean circulo) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.circulo = circulo;
    }
    
    //creo los getters and setters
    public boolean isCirculo() {
        return circulo;
    }


    public void setCirculo(boolean circulo) {
        this.circulo = circulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
