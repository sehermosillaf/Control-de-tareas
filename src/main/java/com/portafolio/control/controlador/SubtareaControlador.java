package com.portafolio.control.controlador;

import com.portafolio.control.dao.Subtarea;
import com.portafolio.control.modelo.TareaSubordinada;
import com.portafolio.control.servicio.subtarea.IServicioSubtarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subtareas")
public class SubtareaControlador {
    @Autowired
    private IServicioSubtarea servicioSubtarea;

    @GetMapping
    public List<TareaSubordinada> obtenerTareasSubordinadas() {
        return servicioSubtarea.obtenerSubtareas();
    }
    @GetMapping("/{id}")
    public Optional<TareaSubordinada> obtenerTareasSubordinadas(@PathVariable Long id) {
        return servicioSubtarea.obtenerSubtareaPorID(id);
    }
    @GetMapping("/tarea/{id}")
    public List<Subtarea> obtenerSubtareasPorTareaID(@PathVariable Long id){
        return servicioSubtarea.obtenerSubtareasPorTareaID(id);
    }
    @PostMapping
    @ResponseBody
    public void agregarSubTarea(@RequestBody TareaSubordinada subtarea) {
        servicioSubtarea.guardarSinAsignarSubtarea(subtarea);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TareaSubordinada> actualizarTareaSubordianda(@PathVariable Long id, @RequestBody TareaSubordinada subtarea) {
        return servicioSubtarea.actualizarSubtarea(id,subtarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TareaSubordinada> eliminarTareaPorID(@PathVariable Long id) {
        return servicioSubtarea.eliminarSubtarea(id);
    }




}
