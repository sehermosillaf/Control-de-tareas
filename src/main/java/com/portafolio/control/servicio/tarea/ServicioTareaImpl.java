package com.portafolio.control.servicio.tarea;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class ServicioTareaImpl  implements IServicioTarea{

    @Autowired
    private ITareaRepo tareaRepo;

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
        return new ResponseEntity<>(tareaNueva, CREATED);
    }

}
