package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Unidad;
import com.portafolio.control.servicio.unidad.IServicioUnidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadControlador {
    @Autowired
    private IServicioUnidad servicioUnidad;

    @GetMapping
    public List<Unidad> obtenerUnidades(){
        return servicioUnidad.obtenerUnidades();
    }

    @GetMapping("/empresa/{id}")
    public List<Unidad> obtenerUnidadesPorEmpresa(@PathVariable Long id) {
        return servicioUnidad.obtenerUnidadesPorEmpresa(id);
    }

    @PostMapping
    public ResponseEntity<Unidad> agregarUnidad(@RequestBody Unidad unidad) {
        return servicioUnidad.agregarUnidad(unidad);
    }
}
