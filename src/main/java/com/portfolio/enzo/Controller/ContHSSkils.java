
package com.portfolio.enzo.Controller;

import com.portfolio.enzo.Dto.dtoHSSkils;
import com.portfolio.enzo.Entity.HSSkils;
import com.portfolio.enzo.Security.Controller.Mensaje;
import com.portfolio.enzo.Service.ServHSSkils;
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
//cuando haga el deploy, pongo coma despues de la comilla y entre  comillas coloco el link de la pagina
@CrossOrigin(origins = {"http://localhost:4200/","https://frontendenzo.web.app"})
@RequestMapping("/skill")
public class ContHSSkils {
    @Autowired
    ServHSSkils  servHSSkils;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HSSkils>> list(){
        List<HSSkils> list = servHSSkils.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HSSkils> getById(@PathVariable("id") int id){
        if(!servHSSkils.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HSSkils hsSkils = servHSSkils.getOne(id).get();
        return new ResponseEntity(hsSkils, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHSSkils dtohsSkils){
        if(StringUtils.isBlank(dtohsSkils.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(servHSSkils.existsByNombre(dtohsSkils.getNombre()))
            return new ResponseEntity(new Mensaje ("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        
        HSSkils hsSkils = new HSSkils(dtohsSkils.getNombre(), dtohsSkils.getPorcentaje(), dtohsSkils.isCirculo());
        servHSSkils.save(hsSkils);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHSSkils dtohsSkils){
        if(!servHSSkils.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(servHSSkils.existsByNombre(dtohsSkils.getNombre()) && 
                servHSSkils.getByNombre(dtohsSkils.getNombre()).get() .getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isAllBlank(dtohsSkils.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HSSkils hsSkils = servHSSkils.getOne(id).get();
        hsSkils.setNombre(dtohsSkils.getNombre());
        hsSkils.setPorcentaje(dtohsSkils.getPorcentaje());
        hsSkils.setCirculo(dtohsSkils.isCirculo());
        
        servHSSkils.save(hsSkils);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servHSSkils.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        servHSSkils.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}

