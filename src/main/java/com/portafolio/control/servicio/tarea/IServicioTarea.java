package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioTarea {


    List<Tarea> obtenerTodasLasTareas();

    Optional<Tarea> obtenerTareaPorID(Long id);

    ResponseEntity<Tarea> guardarTarea(Tarea tarea);

}
