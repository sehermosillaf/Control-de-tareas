package com.portafolio.control.servicio.rol;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.repositorio.IRolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRolImpl implements IServicioRol{

    @Autowired
    private IRolRepo rolRepo;

    @Override
    public List<Rol> obtenerRoles() {
        return rolRepo.findAll();
    }
}
