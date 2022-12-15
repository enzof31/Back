
package com.portfolio.enzo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
 
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
     @NotNull
    @Size(min=1, max=50, message="intente que sea entre 1 y 50 caracteres")
     private String nombre;
    @NotNull
    @Size(min=1, max=255, message="intente que sea entre 1 y 50 caracteres")
    private String descripcion;
    
    private String img;
    private String fecha;
    
    //contructores
    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion, String img, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.fecha = fecha;
    }
//getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
