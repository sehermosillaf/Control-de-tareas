package com.portafolio.control.servicio.unidad;

import com.portafolio.control.modelo.Unidad;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUnidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUnidadImpl implements IServicioUnidad{
    @Autowired
    private IUnidadRepo unidadRepo;
    @Override
    public List<Unidad> obtenerUnidades() {
        return unidadRepo.findAll();
    }

    @Override
    public ResponseEntity<Unidad> agregarUnidad(Unidad unidad) {
        Unidad nuevaUnidad = unidadRepo.save(unidad);
        return ResponseEntity.ok(nuevaUnidad);
    }
}
