package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.servicio.rol.IServicioRol;
import com.portafolio.control.servicio.rol.ServicioRolImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolControlador {

    @Autowired
    private IServicioRol servicioRol;

    @GetMapping
    public List<Rol> obtenerRoles(){
     return servicioRol.obtenerRoles();
    }
}
