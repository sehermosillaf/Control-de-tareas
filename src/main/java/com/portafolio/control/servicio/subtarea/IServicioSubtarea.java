package com.portafolio.control.servicio.subtarea;

import com.portafolio.control.modelo.TareaSubordinada;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioSubtarea {

    List<TareaSubordinada> obtenerSubtareas();

    ResponseEntity<TareaSubordinada> guardarSubtarea(TareaSubordinada subtarea);

    ResponseEntity<TareaSubordinada> eliminarSubtarea(Long id);

    Optional<TareaSubordinada> subtareaPorID(Long id);

    ResponseEntity<TareaSubordinada> actualizarSubtarea(Long id,TareaSubordinada subtarea);
}
