package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.ITareaRepo;
import com.portafolio.control.repositorio.ITareaSubordiandaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class ServicioTareaImpl  implements IServicioTarea{

    @Autowired
    private ITareaRepo tareaRepo;

    @Autowired
    private ITareaSubordiandaRepo tareaSubordiandaRepo;

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
        Tarea tareaNueva = tareaRepo.save(tarea);
        if(tareaNueva == null) {
            return (ResponseEntity<Tarea>) ResponseEntity.notFound();
        } else {
            return new ResponseEntity<>(tareaNueva, CREATED);
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
        Tarea tareaPorActualizar = tareaRepo.findById(id).orElse(null);//Todo:Crear excepcion personalizada
        tareaPorActualizar.setNombre(tarea.getNombre());
        tareaPorActualizar.setDescripcion(tarea.getDescripcion());
        tareaPorActualizar.setEstado(tarea.getEstado());
        tareaPorActualizar.setSubtareas(tarea.getSubtareas());
        tareaPorActualizar.setFechaInicio(tarea.getFechaInicio());
        tareaPorActualizar.setFechaTermino(tarea.getFechaTermino());
        tareaRepo.save(tareaPorActualizar);
        return ResponseEntity.ok(tarea);
    }






}
