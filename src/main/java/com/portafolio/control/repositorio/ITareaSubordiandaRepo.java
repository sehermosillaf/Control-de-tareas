package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.TareaSubordinada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaSubordiandaRepo extends JpaRepository<TareaSubordinada, Long> {

    @Query(value = "SELECT subtarea from TareaSubordinada subtarea GROUP BY subtarea.tarea.id")
    List<TareaSubordinada> subtareasGroupByTareaID(@Param("id") Long id);
}
