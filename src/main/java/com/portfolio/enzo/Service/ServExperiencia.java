
package com.portfolio.enzo.Service;

import com.portfolio.enzo.Entity.ExperienciaLab;
import com.portfolio.enzo.Repository.RepExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServExperiencia {
    
    @Autowired
    RepExperiencia repExperiencia;
    
    public List<ExperienciaLab> list(){
        return repExperiencia.findAll();
    }
    
    public  Optional<ExperienciaLab> getOne(int id){
        return repExperiencia.findById(id);
    }
    
    public Optional<ExperienciaLab> getByNombreE(String nombreE){
        return repExperiencia.findByNombreE(nombreE);
    }
    
    public void save (ExperienciaLab expe){
        repExperiencia.save(expe);
    }
    
    public void delete(int id){
        repExperiencia.deleteById(id);
    }
    
    public boolean  existById(int id){
        return repExperiencia.existsById(id);
    }
    public boolean existByNombreE(String nombreE){
        return repExperiencia.existsByNombreE(nombreE);
    }
            
    
}
