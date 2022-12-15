
package com.portfolio.enzo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HSSkils {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  private String nombre;
  private int porcentaje;
  private boolean circulo;

//creo el constructor

    public HSSkils() {
    }

    public HSSkils(String nombre, int porcentaje, boolean circulo) {
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
  
  
}
