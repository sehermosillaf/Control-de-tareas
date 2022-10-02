package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaControlador {

    @Autowired
    private IServicioTarea servicioTarea;

    @GetMapping
    public List<Tarea> obtenerTodasLasTareas() {
        return servicioTarea.obtenerTodasLasTareas();
    }
    @GetMapping("/{id}")
    public Optional<Tarea> obtenerTareaPorID(@PathVariable Long id) {
        return servicioTarea.obtenerTareaPorID(id);
    }
}
