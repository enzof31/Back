
package com.portfolio.enzo.Controller;

import com.portfolio.enzo.Dto.dtoProyectos;
import com.portfolio.enzo.Entity.Proyectos;
import com.portfolio.enzo.Security.Controller.Mensaje;
import com.portfolio.enzo.Service.ServProyectos;
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
@RequestMapping("/proyectos")
//cuando haga el deploy, pongo coma despues de la comilla y entre  comillas coloco el link de la pagina
@CrossOrigin(origins = {"http://localhost:4200","https://frontendenzo.web.app"})
public class ContProyectos {
        @Autowired
        ServProyectos servProyectos;
        
        @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = servProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!servProyectos.existById(id)){
            return new ResponseEntity(new Mensaje("no existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = servProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servProyectos.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    servProyectos.delete(id);
    return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(servProyectos.existByNombre(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
    
        
        Proyectos proyectos = new Proyectos (
        dtoproyectos.getNombre(), dtoproyectos.getDescripcion(), dtoproyectos.getImg(), dtoproyectos.getFecha()
    );
    servProyectos.save(proyectos);
    return new ResponseEntity(new Mensaje("Proyecto Creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!servProyectos.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    if(servProyectos.existByNombre(dtoproyectos.getNombre()) && servProyectos.getByNombre(dtoproyectos.getNombre()).get().getId() !=id){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isAllBlank(dtoproyectos.getNombre())){
        return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
    }

    
    Proyectos proyectos = servProyectos.getOne(id).get();
    proyectos.setNombre(dtoproyectos.getNombre());
    proyectos.setFecha(dtoproyectos.getFecha());
    proyectos.setDescripcion(dtoproyectos.getDescripcion());
    proyectos.setImg(dtoproyectos.getImg());
    
    servProyectos.save(proyectos);
    return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }
        
}
