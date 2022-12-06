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

    @Procedure(name="SP_TERMINAR_TAREA")
    void terminarTarea(@Param("P_ID_TAREA") Long idTarea);

    @Query(value = "SELECT COUNT(ID_TAREA) FROM TAREA WHERE ESTADO_ID = 5 AND ID_UNIDAD = :id",nativeQuery = true)
            int tareasRechazadasPorUnidad(@Param("id")Long id);
    @Query(value = "SELECT COUNT(ID_TAREA) FROM TAREA WHERE ESTADO_ID = 4 AND ID_UNIDAD = :id",nativeQuery = true)
    int tareasTerminadasPorUnidad(@Param("id")Long id);
    @Query(value = "SELECT COUNT(t) FROM Tarea t where t.estado.id = 2 and t.unidad.id = :id")
    int tareasAlertasPorUnidad(@Param("id")Long id);

//    @Query(value = "SELECT COUNT(t) FROM Tarea t where t.estado.id = 2 and t.unidad.id = :id")

    @Query(value = "SELECT COUNT(ID_TAREA) FROM TAREA WHERE ESTADO_ID = 3 AND ID_UNIDAD = :id",nativeQuery = true)
    int tareasAtrasadasPorUnidad(@Param("id")Long id);

    @Query(value = "SELECT COUNT(ID_TAREA) FROM TAREA WHERE ESTADO_ID = 1 AND ID_UNIDAD = :id",nativeQuery = true)
    int tareasBuenasPorUnidad(@Param("id")Long id);

    @Query(nativeQuery = true, value = "select * from tarea where usuario_id = ?1")
    List<Tarea> findTareasByUsuarioResponsable(Long id);

    @Procedure(name = "INSERTAR_TAREA")
    void insertarTarea(@Param("P_NOMBRE") String nombre, @Param("P_DESCRIPCION") String descripcion,
                       @Param("P_FECHA_CREACION") Date fechaCreacion, @Param("P_FECHA_INICIO") Date fechaInicio,
                       @Param("P_FECHA_TERMINO") Date fechaTermino, @Param("P_USUARIO_ID") Long usuarioResponsable,
                       @Param("P_USUARIO_CREADOR") Long usuarioCreador, @Param("P_UNIDAD_ID") Long unidadID);

    @Procedure(name = "SP_RECHAZAR_TAREA")
    void rechazarTarea(@Param("P_ID_TAREA") Long idTarea, @Param("P_JUSTIFICACION") String justificacion, @Param("P_USUARIO_RESPONSABLE") Long idResponsable);

    @Query(nativeQuery = true,value ="SELECT usuario_creador_id from tarea where id_tarea = :idTarea")
    int obtenerUsuarioCreador(@Param("idTarea") Long id);

    @Query(nativeQuery = true,value = "SELECT email from tarea where id_tarea = :idTarea")
    String obtenerEmailPorTareaID(@Param("idTarea")Long id);

}
