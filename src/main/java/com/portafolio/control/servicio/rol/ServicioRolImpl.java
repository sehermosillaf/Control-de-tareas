package com.portafolio.control.servicio.rol;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.repositorio.IRolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Service
public class ServicioRolImpl implements IServicioRol{

    @Autowired
    private IRolRepo rolRepo;

    @Override
    public List<Rol> obtenerRoles() {
        return rolRepo.findAll();
    }

    @Override
    public Rol agregarRol(Rol rol) {
        return rolRepo.save(rol);
    }

    @Override
    public ResponseEntity<Rol> actualizarRol(Long id,Rol rol) {
        Rol rolActualizado = rolRepo.findById(id).orElse(null);//Todo:Crear Excepcion personalizadas
        rolActualizado.setNombre(rol.getNombre());
        rolRepo.save(rolActualizado);
        return ResponseEntity.ok(rolActualizado);
    }
    @Override
    public ResponseEntity<Rol> eliminarRol(Long id) {
        Rol rolPorEliminar = rolRepo.findById(id).orElse(null);//Todo:Crear Exception personalizada
        if(rolPorEliminar == null) {
            return (ResponseEntity<Rol>) ResponseEntity.notFound();
        }
        rolRepo.delete(rolPorEliminar);
        return ResponseEntity.ok(rolPorEliminar);
    }


}
