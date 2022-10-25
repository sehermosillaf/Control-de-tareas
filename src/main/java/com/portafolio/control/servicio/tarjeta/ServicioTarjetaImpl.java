package com.portafolio.control.servicio.tarjeta;

import com.portafolio.control.modelo.Tarjeta;
import com.portafolio.control.repositorio.ITarjetaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTarjetaImpl implements IServicioTarjeta{

    @Autowired
    private ITarjetaRepo tarjetaRepo;

    @Override
    public List<Tarjeta> obtenerTarjetas() {
        return tarjetaRepo.findAll();
    }

    @Override
    public Optional<Tarjeta> obtenerTarjetasPorID(Long id) {
        return tarjetaRepo.findById(id);
    }

    @Override
    public ResponseEntity<Tarjeta> agregarTarjeta(Tarjeta tarjeta) {
       Tarjeta nuevaTarjeta = tarjetaRepo.save(tarjeta);
        return ResponseEntity.ok(nuevaTarjeta);
    }

//    @Override
//    public ResponseEntity<Tarjeta> actualizarTarjeta(Long id, Tarjeta tarjeta) {
//        return null;
//    }

    @Override
    public ResponseEntity<Tarjeta> eliminarTarjeta(Long id) {
        Tarjeta tarjetaEliminada = tarjetaRepo.findById(id).get();
        tarjetaRepo.delete(tarjetaEliminada);
        return ResponseEntity.ok(tarjetaEliminada);
    }
}
