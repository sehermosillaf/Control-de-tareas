package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepo extends JpaRepository<Estado,Long> {
}
