
package com.portfolio.enzo.Repository;

import com.portfolio.enzo.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepEducacion  extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
