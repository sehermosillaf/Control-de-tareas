package com.portafolio.control.repositorio;

import com.portafolio.control.dao.Subtarea;
import com.portafolio.control.modelo.TareaSubordinada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaSubordiandaRepo extends JpaRepository<TareaSubordinada, Long> {

    @Query(value = "SELECT ID_SUBTAREA, NOMBRE_SUBTAREA,DESCRIPCION,FECHA_CREACION,FECHA_INICIO,FECHA_TERMINO,ID_TAREA FROM TAREA_SUBORDINADA WHERE ID_TAREA= :id",nativeQuery = true )
    List<Subtarea>obtenerSubtareasPorTareaID(@Param("id")Long id);

}
