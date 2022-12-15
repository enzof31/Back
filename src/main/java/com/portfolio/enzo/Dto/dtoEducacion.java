
package com.portfolio.enzo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;    
    @NotBlank
    private String fechaE;    
    //creo los constructores
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String fechaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaE = fechaE;
    }

    

    //creo los getters and setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }
    
    
}
