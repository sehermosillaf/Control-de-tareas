package com.portafolio.control.servicio.subtarea;

import com.portafolio.control.dao.Subtarea;
import com.portafolio.control.dto.SubtareaDTO;
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
    public Optional<TareaSubordinada> obtenerSubtareaPorID(Long id) {
        return subtareaRepo.findById(id);
    }

    @Override
    public ResponseEntity<TareaSubordinada> actualizarSubtarea(Long id, TareaSubordinada subtarea) {
        TareaSubordinada subtareaPorActualizar = subtareaRepo.findById(id).get();
        subtareaPorActualizar.setDescripcion(subtarea.getDescripcion());
        subtareaPorActualizar.setNombre(subtarea.getNombre());
        subtareaPorActualizar.setFechaInicio(subtarea.getFechaInicio());
        subtareaPorActualizar.setFechaTermino(subtarea.getFechaTermino());
        subtareaPorActualizar.setTarea(subtarea.getTarea());
        subtareaRepo.save(subtareaPorActualizar);
        return ResponseEntity.ok(subtareaPorActualizar);
    }

    @Override
    public List<Subtarea> obtenerSubtareasPorTareaID(Long id) {
        return subtareaRepo.obtenerSubtareasPorTareaID(id);
    }

    @Override
    public void insertarSubtarea(SubtareaDTO subtareaDTO) {
         subtareaRepo.insertarSubtarea(subtareaDTO.getNombre(),subtareaDTO.getDescripcion(),subtareaDTO.getFechaCreacion(),subtareaDTO.getFechaInicio(),subtareaDTO.getFechaTermino(),subtareaDTO.getIdTarea());
    }

    @Override
    public ResponseEntity<TareaSubordinada> guardarSinAsignarSubtarea(TareaSubordinada subtarea) {
        TareaSubordinada nuevaSubtrea = subtareaRepo.save(subtarea);
        return new ResponseEntity<>(nuevaSubtrea,CREATED);
    }

//    @Override
//    public ResponseEntity<TareaSubordinada> guardarYAsignar(TareaSubordinada Subtarea,Long id) {
//        TareaSubordinada nuevaSubTarea = new TareaSubordinada();
//        nuevaSubTarea.setId(Subtarea.getId());
//        nuevaSubTarea.setNombre(Subtarea.getNombre());
//        nuevaSubTarea.setDescripcion(Subtarea.getDescripcion());
//        nuevaSubTarea.setFechaCreacion(Subtarea.getFechaCreacion());
//        nuevaSubTarea.setFechaInicio(Subtarea.getFechaInicio());
//        nuevaSubTarea.setFechaTermino(Subtarea.getFechaTermino());
//        nuevaSubTarea.setTarea(Subtarea.getTarea().);
//        return null;
//    }

    @Override
    public ResponseEntity<TareaSubordinada> eliminarSubtarea(Long id) {
        TareaSubordinada subtareaPorEliminar = subtareaRepo.findById(id).get();
        if (subtareaPorEliminar == null) {
            return (ResponseEntity<TareaSubordinada>) ResponseEntity.notFound();
        }
        subtareaRepo.deleteById(id);
        return ResponseEntity.ok(subtareaPorEliminar);
    }






}
