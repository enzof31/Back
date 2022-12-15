
package com.portfolio.enzo.Security.Service;

import com.portfolio.enzo.Security.Entity.Rol;
import com.portfolio.enzo.Security.Enums.RolName;
import com.portfolio.enzo.Security.Repository.IntRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IntRolRepository intRolRepository;
    
    public Optional<Rol> getByRolNombre(RolName rolNombre){
        return intRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        intRolRepository.save(rol);
    }
}
