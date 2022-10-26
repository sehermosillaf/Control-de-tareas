package com.portafolio.control.servicio.usuario;

import com.portafolio.control.dto.UsuarioRegistro;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IServicioUsuario extends UserDetailsService {
    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorID(Long id);

    ResponseEntity<Usuario> agregarUsuario(Usuario usuario);

    ResponseEntity<Usuario> actualizarUsuario(Long id,Usuario usuario);

    ResponseEntity<Usuario> eliminarUsuario(Long id);

    int login(String email_aut, String psw_aut);
    Usuario guardarUsuarioRolFuncionario(UsuarioRegistro usuarioDTO);

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
