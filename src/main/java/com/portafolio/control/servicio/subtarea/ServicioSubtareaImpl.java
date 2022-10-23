package com.portafolio.control.servicio.subtarea;

import com.portafolio.control.modelo.TareaSubordinada;
import com.portafolio.control.repositorio.ITareaSubordiandaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class ServicioSubtareaImpl implements IServicioSubtarea{

    @Autowired
    private ITareaSubordiandaRepo subtareaRepo;
    @Override
    public List<TareaSubordinada> obtenerSubtareas() {
        return subtareaRepo.findAll();
    }

    @Override
    public Optional<TareaSubordinada> subtareaPorID(Long id) {
        return subtareaRepo.findById(id);
    }

    @Override
    public ResponseEntity<TareaSubordinada> actualizarSubtarea(Long id, TareaSubordinada subtarea) {
        TareaSubordinada subtareaPorActualizar = subtareaRepo.findById(id).orElse(new TareaSubordinada());
        subtareaPorActualizar.setDescripcion(subtarea.getDescripcion());
        subtareaPorActualizar.setNombre(subtarea.getNombre());
        subtareaPorActualizar.setFechaInicio(subtarea.getFechaInicio());
        subtareaPorActualizar.setFechaTermino(subtarea.getFechaTermino());
        subtareaPorActualizar.setTarea(subtarea.getTarea());
        subtareaRepo.save(subtareaPorActualizar);
        return ResponseEntity.ok(subtareaPorActualizar);
    }

    @Override
    public ResponseEntity<TareaSubordinada> guardarSubtarea(TareaSubordinada subtarea) {
        TareaSubordinada nuevaSubtrea = subtareaRepo.save(subtarea);
        return new ResponseEntity<>(nuevaSubtrea,CREATED);
    }

    @Override
    public ResponseEntity<TareaSubordinada> eliminarSubtarea(Long id) {
        TareaSubordinada subtareaPorEliminar = subtareaRepo.findById(id).orElse(null);
        if (subtareaPorEliminar == null) {
            return (ResponseEntity<TareaSubordinada>) ResponseEntity.notFound();
        }
        subtareaRepo.deleteById(id);
        return ResponseEntity.ok(subtareaPorEliminar);
    }



}
