package com.portafolio.control.servicio.flujos;

import com.portafolio.control.modelo.FlujoTareas;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IFlujoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioFlujoImpl implements IServicioFlujo{
    @Autowired
    private IFlujoRepo flujoRepo;

    @Override
    public List<FlujoTareas> obtenerFlujos() {
        return flujoRepo.findAll();
    }

    @Override
    public Optional<FlujoTareas> obtenerFlujosPorUsuario(Long id) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<FlujoTareas> agregarFlujo(FlujoTareas flujo) {
        FlujoTareas flujos = flujoRepo.save(flujo);
        return ResponseEntity.ok(flujos);
    }

    @Override
    public ResponseEntity<FlujoTareas> actualizarFlujo(Long id, FlujoTareas flujo) {
        FlujoTareas FlujoPorActualizar = flujoRepo.findById(id).get();
        return null;
    }

    @Override
    public ResponseEntity<FlujoTareas> eliminarFlujo(Long id) {
        return null;
    }
}
