package com.portafolio.control.servicio.tarjeta;

import com.portafolio.control.modelo.Tarjeta;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IServicioTarjeta {
    List<Tarjeta> obtenerTarjetas();

    Optional<Tarjeta> obtenerTarjetasPorID(Long id);

    ResponseEntity<Tarjeta> agregarTarjeta(Tarjeta tarjeta);

//    ResponseEntity<Tarjeta> actualizarTarjeta(Long id,Tarjeta tarjeta);

    ResponseEntity<Tarjeta> eliminarTarjeta(Long id);
}
