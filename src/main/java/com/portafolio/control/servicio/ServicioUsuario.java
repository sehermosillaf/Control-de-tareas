package com.portafolio.control.servicio;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario implements IServicioUsuario{
    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepo.findAll();
    }
}
