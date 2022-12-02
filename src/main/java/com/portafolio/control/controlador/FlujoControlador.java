package com.portafolio.control.controlador;

import com.portafolio.control.dto.FlujoDTO;
import com.portafolio.control.modelo.FlujoTareas;
import com.portafolio.control.servicio.flujos.IServicioFlujo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flujos")
public class FlujoControlador {
    @Autowired
    private IServicioFlujo servicioFlujo;

    @GetMapping
    public List<FlujoTareas> obtenerTodoslosFlujos(){
       return servicioFlujo.obtenerFlujos();
    }

    @PostMapping
    @ResponseBody
    public void insertarFlujo(@RequestBody FlujoDTO flujoDto){
         servicioFlujo.insertarFlujo(flujoDto);
    }
}
