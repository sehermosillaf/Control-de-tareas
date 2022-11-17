package com.portafolio.control.servicio.flujos;

import com.portafolio.control.modelo.FlujoTareas;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IFlujoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioFlujo {
    List<FlujoTareas> obtenerFlujos();

    Optional<FlujoTareas> obtenerFlujosPorUsuario(Long id);

    ResponseEntity<FlujoTareas> agregarFlujo(FlujoTareas flujo);

    ResponseEntity<FlujoTareas> actualizarFlujo(Long id,FlujoTareas flujo);

    ResponseEntity<FlujoTareas> eliminarFlujo(Long id);
}
