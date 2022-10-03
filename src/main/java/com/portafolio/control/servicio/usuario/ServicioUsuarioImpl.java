package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IRolRepo;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuarioImpl implements IServicioUsuario{
    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Autowired
    private IRolRepo rolRepo;

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorID(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public ResponseEntity<Usuario> agregarUsuario(Usuario usuario) {
        Usuario usuarioNuevo = usuarioRepo.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);

    }


}
