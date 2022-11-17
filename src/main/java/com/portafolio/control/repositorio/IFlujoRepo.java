package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.FlujoTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlujoRepo extends JpaRepository<FlujoTareas,Long> {
}
