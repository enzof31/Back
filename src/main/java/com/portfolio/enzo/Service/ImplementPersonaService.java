
package com.portfolio.enzo.Service;

import com.portfolio.enzo.Entity.Persona;
import com.portfolio.enzo.Repository.IntPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImplementPersonaService  {
    
    @Autowired
    IntPersonaRepository intPersonaRepository;
 
    public List<Persona> list(){
        return intPersonaRepository.findAll();
    }
    
    public  Optional<Persona> getOne(int id){
        return intPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return intPersonaRepository.findByNombre(nombre);
    }
    
    public void save (Persona persona){
        intPersonaRepository.save(persona);
    }
    
    public void delete(int id){
        intPersonaRepository.deleteById(id);
    }
    
    public boolean  existById(int id){
        return intPersonaRepository.existsById(id);
    }
    public boolean existByNombre(String nombre){
        return intPersonaRepository.existsByNombre(nombre);
    }
            
}
