package com.portafolio.control.servicio.rol;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.repositorio.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IServicioRol {

    List<Rol> obtenerRoles();
}
