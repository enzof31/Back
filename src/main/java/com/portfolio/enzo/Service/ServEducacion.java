
package com.portfolio.enzo.Service;

import com.portfolio.enzo.Entity.Educacion;
import com.portfolio.enzo.Repository.RepEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEducacion {
    @Autowired
    RepEducacion repEducacion;
    
    public List<Educacion> list(){
        return repEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int  id){
        return repEducacion.findById(id);
    }
    public Optional<Educacion> getByNombre(String nombreE){
        return repEducacion.findByNombreE(nombreE);
    }
    public void save(Educacion educacion){
        repEducacion.save(educacion);
    }
    public void delete (int id){
        repEducacion.deleteById(id);
    }
    public boolean existById(int id){
        return repEducacion.existsById(id);
    }
    public boolean existByNombreE(String nombreE){
        return repEducacion.existsByNombreE(nombreE);
    }
}
