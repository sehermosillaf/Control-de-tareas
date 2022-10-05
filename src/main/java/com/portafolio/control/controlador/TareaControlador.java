package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public void agregarTarea(@RequestBody Tarea tarea){
        servicioTarea.guardarTarea(tarea);
    }
}
