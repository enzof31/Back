
package com.portfolio.enzo.Security.Repository;

import com.portfolio.enzo.Security.Entity.Rol;
import com.portfolio.enzo.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntRolRepository  extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolName rolNombre);
}
