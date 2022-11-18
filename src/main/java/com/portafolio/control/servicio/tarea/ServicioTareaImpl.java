package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Estado;
import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.repositorio.IEstadoRepo;
import com.portafolio.control.repositorio.ITareaRepo;
import com.portafolio.control.repositorio.ITareaSubordiandaRepo;
import com.portafolio.control.servicio.estado.ServicioEstadoImpl;
import com.portafolio.control.servicio.mail.EnvioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioTareaImpl  implements IServicioTarea{

    @Autowired
    private ITareaRepo tareaRepo;

    @Autowired
    private IEstadoRepo estadoRepo;

    @Autowired
    private ServicioEstadoImpl servicioEstado;

    @Autowired
    private ITareaSubordiandaRepo tareaSubordiandaRepo;

    @Autowired
    private EnvioMail email;

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepo.findAll();
    }

    @Override
    public Optional<Tarea> obtenerTareaPorID(Long id) {
        return tareaRepo.findById(id);
    }

    @Override
    public ResponseEntity<Tarea> guardarTarea(Tarea tarea) {
        if(tarea != null){
            Tarea tareaBody = tareaRepo.save(tarea);
            return ResponseEntity.ok(tareaBody);
        } else {
            return (ResponseEntity<Tarea>) ResponseEntity.notFound();
        }

    }

    @Override
    public ResponseEntity<Tarea> eliminarTarea(Long id) {
        Tarea tareaPorEliminar = tareaRepo.findById(id).orElse(null);
        if(tareaPorEliminar == null) {
            return (ResponseEntity<Tarea>) ResponseEntity.notFound();
        }
        tareaRepo.delete(tareaPorEliminar);
        return ResponseEntity.ok(tareaPorEliminar);
    }

    @Override
    public ResponseEntity<Tarea> actualizarTarea(Long id,Tarea tarea) {
        //Todo:Crear excepcion personalizada
        Tarea tareaPorActualizar = tareaRepo.findById(id).get();
        tareaPorActualizar.setNombre(tarea.getNombre());
        tareaPorActualizar.setDescripcion(tarea.getDescripcion());
        tareaPorActualizar.setSubtareas(tarea.getSubtareas());
        tareaPorActualizar.setEstado(tarea.getEstado());
        tareaPorActualizar.setFechaInicio(tarea.getFechaInicio());
        tareaPorActualizar.setFechaTermino(tarea.getFechaTermino());
        tareaRepo.save(tareaPorActualizar);
        return ResponseEntity.ok(tarea);
    }

    @Override
    public void actualizarEstadoTarea() {
        tareaRepo.actualizarEstado();
    }


}
