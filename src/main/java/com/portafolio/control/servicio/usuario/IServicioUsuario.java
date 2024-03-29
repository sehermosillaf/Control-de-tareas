package com.portafolio.control.servicio.usuario;

import com.portafolio.control.dto.UsuarioFuncDTO;
import com.portafolio.control.dto.UsuarioRolesDTO;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario {
    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorID(Long id);

    List<Usuario> obtenerUsuariosPorUnidad(Long id);

    List<Usuario> obtenerFuncionariosPorUnidad(Long id);

    List<Usuario> obtenerFuncionariosPorEmpresa(Long id);

    List<?> obtenerAdmins();

    List<UsuarioFuncDTO> obtenerFunc();

    String buscarEmailPorID(Long id);

    ResponseEntity<Usuario> agregarUsuario(Usuario usuario);
    void agregarUsuarioConRoles(UsuarioRolesDTO usuarioRolesDTO);

    ResponseEntity<Usuario> actualizarUsuario(Long id,Usuario usuario);

    ResponseEntity<Usuario> eliminarUsuario(Long id);

    ResponseEntity<?> validateCredentials(String email, String password);


}
