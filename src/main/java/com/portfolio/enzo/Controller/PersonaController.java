
package com.portfolio.enzo.Controller;

import com.portfolio.enzo.Dto.dtoPersona;
import com.portfolio.enzo.Entity.Persona;
import com.portfolio.enzo.Security.Controller.Mensaje;
import com.portfolio.enzo.Service.ImplementPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
//cuando haga el deploy, pongo coma despues de la comilla y entre  comillas coloco el link de la pagina
@CrossOrigin(origins = {"http://localhost:4200","https://frontendenzo.web.app"})
public class PersonaController {
    @Autowired
    ImplementPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existById(id)){
            return new ResponseEntity(new Mensaje("no existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servEducacion.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    servEducacion.delete(id);
    return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
    
        
        Persona persona = new Persona (
        dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getDescripcion(), dtopersona.getImg()
    );
   personaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona Creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
    if(personaService.existByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() !=id){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isAllBlank(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("El campo no puede estar vacion"), HttpStatus.BAD_REQUEST);
    }
    Persona persona = personaService.getOne(id).get();
    persona.setNombre(dtopersona.getNombre());
    persona.setApellido(dtopersona.getApellido());
    persona.setDescripcion(dtopersona.getDescripcion());
    persona.setImg(dtopersona.getImg());
    
    personaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
}
