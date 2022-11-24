package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidadRepo extends JpaRepository<Unidad,Long> {
}
