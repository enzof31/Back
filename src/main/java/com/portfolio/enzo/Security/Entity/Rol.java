
package com.portfolio.enzo.Security.Entity;

import com.portfolio.enzo.Security.Enums.RolName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolNombre;

//Genero el Constructor

    public Rol() {
    }

    public Rol(RolName rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    //Genero los Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolName rolNombre) {
        this.rolNombre = rolNombre;
    }


}
