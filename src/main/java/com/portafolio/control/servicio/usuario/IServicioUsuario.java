package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario {
    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorID(Long id);

    ResponseEntity<Usuario> agregarUsuario(Usuario usuario);

    ResponseEntity<Usuario> actualizarUsuario(Long id,Usuario usuario);

    ResponseEntity<Usuario> eliminarUsuario(Long id);

    Boolean validate(String email,String password);
}
