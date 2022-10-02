package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepo extends JpaRepository<Tarea,Long> {
}
