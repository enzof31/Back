
package com.portfolio.enzo.Repository;

import com.portfolio.enzo.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface RepProyectos extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
