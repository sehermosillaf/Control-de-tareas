package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Empresa;
import com.portafolio.control.servicio.empresa.IServicioEmpresa;
import com.portafolio.control.servicio.empresa.ServicioEmpresaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaControlador {

    @Autowired
    private IServicioEmpresa servicioEmpresa;

    @GetMapping
    public List<Empresa> obtenerTodasEmpresas(){
        return servicioEmpresa.obtenerTodosEmpresas();
    }
}
