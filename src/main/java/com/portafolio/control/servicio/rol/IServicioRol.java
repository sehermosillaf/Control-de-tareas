package com.portafolio.control.servicio.rol;

import com.portafolio.control.modelo.Rol;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServicioRol {

    List<Rol> obtenerRoles();
    Rol agregarRol(Rol rol);

    ResponseEntity<Rol> actualizarRol(Long id,Rol rol);
    ResponseEntity<Rol> eliminarRol(Long id);
}
