package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Tarjeta;
import com.portafolio.control.servicio.tarjeta.IServicioTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaControlador {
    @Autowired
    private IServicioTarjeta servicioTarjeta;

    @GetMapping
    public List<Tarjeta> getAllTarjetas() {
        return servicioTarjeta.obtenerTarjetas();
    }


}
