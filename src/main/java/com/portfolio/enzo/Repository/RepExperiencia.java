package com.portfolio.enzo.Repository;


import com.portfolio.enzo.Entity.ExperienciaLab;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepExperiencia extends JpaRepository<ExperienciaLab, Integer>{
    public Optional<ExperienciaLab> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
