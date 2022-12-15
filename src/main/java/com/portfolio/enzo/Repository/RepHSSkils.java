
package com.portfolio.enzo.Repository;

import com.portfolio.enzo.Entity.HSSkils;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepHSSkils extends JpaRepository<HSSkils, Integer>{
    Optional<HSSkils> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
