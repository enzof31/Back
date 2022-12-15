
package com.portfolio.enzo.Service;

import com.portfolio.enzo.Entity.HSSkils;
import com.portfolio.enzo.Repository.RepHSSkils;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ServHSSkils {
    @Autowired
    RepHSSkils repHSSkils;
    
    public List<HSSkils> list(){
        return repHSSkils.findAll();
    }
    
    public Optional<HSSkils> getOne(int id){
        return  repHSSkils.findById(id);
    }
    
    public Optional<HSSkils> getByNombre(String nombre){
        return repHSSkils.findByNombre(nombre);
    }
    
    public void save (HSSkils skill){
        repHSSkils.save(skill);
    }
    
    public void delete(int id){
        repHSSkils.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repHSSkils.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repHSSkils.existsByNombre(nombre);
    }
}
