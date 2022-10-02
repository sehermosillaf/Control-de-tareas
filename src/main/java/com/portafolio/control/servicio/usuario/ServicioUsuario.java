package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario implements IServicioUsuario{
    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorID(Long id) {
        return usuarioRepo.findById(id);
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }
}
