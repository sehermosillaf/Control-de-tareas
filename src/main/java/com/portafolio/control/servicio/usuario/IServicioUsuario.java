package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario {
    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorID(Long id);

    Usuario guardarUsuario(Usuario usuario);

}
