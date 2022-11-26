package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ITareaRepo extends JpaRepository<Tarea, Long> {

    Tarea findTareasById(Long id);

    @Procedure(name = "updateEstado")
    void actualizarEstado();

    @Query(nativeQuery = true, value = "select * from tarea where usuario_id = ?1")
    List<Tarea> findTareasByUsuarioResponsable(Long id);

    @Procedure(name = "INSERTAR_TAREA")
    void insertarTarea(@Param("P_NOMBRE") String nombre, @Param("P_DESCRIPCION") String descripcion,
                       @Param("P_FECHA_CREACION") Date fechaCreacion, @Param("P_FECHA_INICIO") Date fechaInicio,
                       @Param("P_FECHA_TERMINO") Date fechaTermino, @Param("P_USUARIO_ID") Long usuarioResponsable,
                       @Param("P_USUARIO_CREADOR") Long usuarioCreador, @Param("P_UNIDAD_ID") Long unidadID);

    @Procedure(name = "SP_RECHAZAR_TAREA")
    void rechazarTarea(@Param("P_ID_TAREA") Long idTarea, @Param("P_JUSTIFICACION") String justificacion, @Param("P_USUARIO_RESPONSABLE") Long idResponsable);
}
