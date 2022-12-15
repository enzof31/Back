
package com.portfolio.enzo.Controller;

import com.portfolio.enzo.Dto.dtoEducacion;
import com.portfolio.enzo.Entity.Educacion;
import com.portfolio.enzo.Security.Controller.Mensaje;
import com.portfolio.enzo.Service.ServEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
//cuando haga el deploy, pongo coma despues de la comilla y entre  comillas coloco el link de la pagina
@CrossOrigin(origins = {"http://localhost:4200/", "https://frontendenzo.web.app"})
public class ContEducacion {
    @Autowired
    ServEducacion servEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = servEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!servEducacion.existById(id)){
            return new ResponseEntity(new Mensaje("no existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = servEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servEducacion.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    servEducacion.delete(id);
    return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(servEducacion.existByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
    
        
        Educacion educacion = new Educacion (
        dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE(), dtoeducacion.getFechaE()
    );
    servEducacion.save(educacion);
    return new ResponseEntity(new Mensaje("Educaicion Creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!servEducacion.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    if(servEducacion.existByNombreE(dtoeducacion.getNombreE()) && servEducacion.getByNombre(dtoeducacion.getNombreE()).get().getId() !=id){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    
    if(StringUtils.isAllBlank(dtoeducacion.getNombreE())){
        return new ResponseEntity(new Mensaje("El campo no puede estar vacion"), HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = servEducacion.getOne(id).get();
    educacion.setNombreE(dtoeducacion.getNombreE());
    educacion.setDescripcionE(dtoeducacion.getDescripcionE());
    educacion.setFechaE(dtoeducacion.getFechaE());
    
    servEducacion.save(educacion);
    return new ResponseEntity(new Mensaje("EducacionActualizada"), HttpStatus.OK);
    }
}
