
package com.portfolio.enzo.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class dtoProyectos {
    
    @NotBlank
     private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private String fecha;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String descripcion, String img, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
