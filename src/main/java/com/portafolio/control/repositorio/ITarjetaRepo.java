package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarjetaRepo extends JpaRepository<Tarjeta,Long> {
}
