package com.portafolio.control.servicio.flujos;

import com.portafolio.control.dto.FlujoDTO;
import com.portafolio.control.modelo.FlujoTareas;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioFlujo {
    List<FlujoTareas> obtenerFlujos();

    Optional<FlujoTareas> obtenerFlujosPorUsuario(Long id);

    ResponseEntity<FlujoTareas> agregarFlujo(FlujoTareas flujo);

    ResponseEntity<FlujoTareas> actualizarFlujo(Long id,FlujoTareas flujo);

    ResponseEntity<FlujoTareas> eliminarFlujo(Long id);

    void insertarFlujo  (FlujoDTO flujoDTO);
}
