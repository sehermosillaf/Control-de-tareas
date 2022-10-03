package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.servicio.rol.IServicioRol;
import com.portafolio.control.servicio.rol.ServicioRolImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RolControlador {

    @Autowired
    private IServicioRol servicioRol;

    @GetMapping
    public List<Rol> obtenerRoles(){
        return servicioRol.obtenerRoles();
    }

    @PostMapping
    public void agregarRol(@RequestBody Rol rol){
        servicioRol.agregarRol(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        return servicioRol.actualizarRol(id,rol).getBody();
    }
}
