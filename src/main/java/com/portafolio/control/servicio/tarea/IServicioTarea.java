package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Tarea;

import java.util.List;
import java.util.Optional;

public interface IServicioTarea {


    List<Tarea> obtenerTodasLasTareas();

    Optional<Tarea> obtenerTareaPorID(Long id);

    Tarea guardarTarea(Tarea tarea);

}
