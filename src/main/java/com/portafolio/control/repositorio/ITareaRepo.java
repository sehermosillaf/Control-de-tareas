package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Estado;
import com.portafolio.control.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ITareaRepo extends JpaRepository<Tarea,Long> {
    @Procedure(name = "updateEstado")
    void actualizarEstado();

    @Query(nativeQuery = true,value = "select * from tarea where usuario_id = :id")
    List<Tarea> findTareasByUsuarioResponsable(@Param("id") Long id);
}
