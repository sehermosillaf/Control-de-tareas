package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.FlujoTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlujoRepo extends JpaRepository<FlujoTareas,Long> {

    @Procedure(name = "SP_INSERTAR_FLUJO")
    void insertarFlujoPlsql(@Param("P_NOMBRE") String nombre,
                       @Param("P_DESCRIPCION") String descripcion,
                       @Param("P_TAREA_ID") Long tareaID,
                       @Param("P_UNIDAD_ID") Long unidadID);
}
