package com.portafolio.control.controlador;

import com.portafolio.control.dao.TareaRechazadaDAO;
import com.portafolio.control.dto.TareaDTO;
import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/user/{id}")
    public List<Tarea> obtenerTareasPorUsuario(@PathVariable Long id) {
        return servicioTarea.obtenerTareasPorUsuario(id);
    }
    @PostMapping
    @ResponseBody
    public void agregarTarea(@RequestBody Tarea tarea){
        servicioTarea.guardarTarea(tarea);
    }

    @PostMapping("/add")
    public void insertarTarea(@RequestBody TareaDTO tareaDTO) {
        servicioTarea.insertarTarea(tareaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarea> eliminarTarea(@PathVariable Long id){
        return servicioTarea.eliminarTarea(id);
    }


    @GetMapping("/unidad/rechazadas/{id}")
    public int tareasRechazadasPorUnidad(@PathVariable Long id) {
        return servicioTarea.tareasRechazadasPorUnidad(id);
    }

    @PostMapping("/rechazar")
    public void rechazarTarea(@RequestBody TareaRechazadaDAO tarea) {
        servicioTarea.rechazarTarea(tarea);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id,@RequestBody Tarea tarea) {
        return servicioTarea.actualizarTarea(id,tarea);
    }
    @GetMapping("/estado")
    public void actualizarEstado() {
        servicioTarea.actualizarEstadoTarea();
    }

    @GetMapping("/creador/{idTarea}")
    public int obtenerUsuarioCreador(@PathVariable Long idTarea){
        return servicioTarea.obtenerUsuarioCreador(idTarea);
    }
}
