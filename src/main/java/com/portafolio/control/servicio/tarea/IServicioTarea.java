package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Tarea;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioTarea {

    // Tareas
    List<Tarea> obtenerTodasLasTareas();

    Optional<Tarea> obtenerTareaPorID(Long id);

    ResponseEntity<Tarea> guardarTarea(Tarea tarea);

    ResponseEntity<Tarea> eliminarTarea(Long id);

    ResponseEntity<Tarea> actualizarTarea(Long id, Tarea tarea);

    void actualizarEstadoTarea();

}
