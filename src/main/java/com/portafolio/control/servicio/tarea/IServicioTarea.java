package com.portafolio.control.servicio.tarea;

import com.portafolio.control.dao.TareaRechazadaDAO;
import com.portafolio.control.dto.TareaDTO;
import com.portafolio.control.modelo.Tarea;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioTarea {

    // Tareas
    List<Tarea> obtenerTodasLasTareas();

    Optional<Tarea> obtenerTareaPorID(Long id);

    List<Tarea> obtenerTareasPorUsuario(Long id);

    int tareasRechazadasPorUnidad(Long id);

    int tareasAtrasadasPorUnidad(Long id);

    int tareasTerminadasPorUnidad(Long id);

    int tareasAlertasPorUnidad(Long id);
    int tareasBuenasPorUnidad(Long id);

    ResponseEntity<Tarea> guardarTarea(Tarea tarea);

    void insertarTarea(TareaDTO tareaDTO);
    ResponseEntity<Tarea> eliminarTarea(Long id);

    void rechazarTarea(TareaRechazadaDAO tareaRechazadaDAO);
    ResponseEntity<Tarea> actualizarTarea(Long id, Tarea tarea);

    void terminarTarea(Long id);
    void actualizarEstadoTarea();

    int obtenerUsuarioCreador(Long idTarea);
}
