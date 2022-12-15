
package com.portfolio.enzo.Controller;

import com.portfolio.enzo.Dto.DtoExperiencia;
import com.portfolio.enzo.Entity.ExperienciaLab;
import com.portfolio.enzo.Security.Controller.Mensaje;
import com.portfolio.enzo.Service.ServExperiencia;
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
@RequestMapping("/explab")
//cuando haga el deploy, pongo coma despues de la comilla y entre  comillas coloco el link de la pagina
@CrossOrigin(origins = {"http://localhost:4200/","https://frontendenzo.web.app"})
public class ContExperiencia {
    @Autowired
    ServExperiencia servExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLab>> list(){
        List<ExperienciaLab> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLab> getById(@PathVariable("id") int id){
        if(!servExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLab experiencia = servExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(servExperiencia.existByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje ("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLab experiencia = new ExperienciaLab(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getFechaE());
        servExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        if(!servExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(servExperiencia.existByNombreE(dtoexp.getNombreE()) && 
                servExperiencia.getByNombreE(dtoexp.getNombreE()).get() .getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isAllBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLab experiencia = servExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setFechaE(dtoexp.getFechaE());
        
        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        servExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
