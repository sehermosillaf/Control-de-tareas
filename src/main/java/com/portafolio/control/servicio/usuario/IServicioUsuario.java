package com.portafolio.control.servicio.usuario;

import com.portafolio.control.dto.UsuarioFuncDTO;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario {
    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorID(Long id);

    ResponseEntity<?> agregarUsuarioConRoles(String nombre,String apellido,String email,String pass, Byte enabled,Long unidadID,Long idRol);

    List<?> obtenerAdmins();

    List<UsuarioFuncDTO> obtenerFunc();

    String buscarEmailPorID(Long id);

    ResponseEntity<Usuario> agregarUsuario(Usuario usuario);

    ResponseEntity<Usuario> actualizarUsuario(Long id,Usuario usuario);

    ResponseEntity<Usuario> eliminarUsuario(Long id);

    ResponseEntity<?> validateCredentials(String email, String password);


}
