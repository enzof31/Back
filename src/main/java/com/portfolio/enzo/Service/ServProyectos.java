
package com.portfolio.enzo.Service;

import com.portfolio.enzo.Entity.Proyectos;
import com.portfolio.enzo.Repository.RepProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServProyectos {
    @Autowired
    RepProyectos repProyectos;
    
    public List<Proyectos> list(){
        return repProyectos.findAll();
    }
    
    public  Optional<Proyectos> getOne(int id){
        return repProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return repProyectos.findByNombre(nombre);
    }
    
    public void save (Proyectos proyectos){
        repProyectos.save(proyectos);
    }
    
    public void delete(int id){
        repProyectos.deleteById(id);
    }
    
    public boolean  existById(int id){
        return repProyectos.existsById(id);
    }
    public boolean existByNombre(String nombre){
        return repProyectos.existsByNombre(nombre);
    }
}
