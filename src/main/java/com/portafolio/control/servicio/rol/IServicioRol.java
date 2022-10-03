package com.portafolio.control.servicio.rol;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IServicioRol {

    List<Rol> obtenerRoles();
    Rol agregarRol(Rol rol);

    ResponseEntity<Rol> actualizarRol(Long id,Rol rol);

}
