package com.portafolio.control.servicio.usuario;

import com.portafolio.control.dto.UsuarioRegistro;
import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Service
public class ServicioUsuarioImpl implements IServicioUsuario{
    @Autowired
    private IUsuarioRepo usuarioRepo;


    private BCryptPasswordEncoder passwordEncoder;

    //Registrar
    @Override
    public Usuario guardarUsuarioRolFuncionario(UsuarioRegistro usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getNombre(),
                usuarioDTO.getApellido(),usuarioDTO.getEmail(),
                passwordEncoder.encode(usuarioDTO.getPassword()),Arrays.asList(new Rol("ROLE_FUNC")));

        return usuarioRepo.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password invalidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(),mappingRolesAuth(usuario.getRoles()));
    }

    private Collection<?extends GrantedAuthority> mappingRolesAuth(Collection<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }

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
        String encodedPass = this.passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPass);
        Usuario usuarioNuevo = usuarioRepo.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, CREATED);
    }

    @Override
    public ResponseEntity<Usuario> actualizarUsuario(Long id,Usuario usuario) {
        Usuario usuarioActualizado = usuarioRepo.findById(id).orElse(null);//Todo:Crear excepcion personalizada
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setApellido(usuario.getApellido());
        usuarioActualizado.setEmail(usuario.getEmail());
        usuarioActualizado.setPassword(usuario.getPassword());
        usuarioActualizado.setRoles(usuario.getRoles());
        usuarioRepo.save(usuarioActualizado);
        return ResponseEntity.ok(usuarioActualizado);
    }
    @Override
    public ResponseEntity<Usuario> eliminarUsuario(Long id) {
        Usuario usuarioPorEliminar = usuarioRepo.findById(id).orElse(null); //Todo:Crear excepcion personalizada
        usuarioRepo.delete(usuarioPorEliminar);
        return ResponseEntity.ok(usuarioPorEliminar);
    }

    @Override
    public int login(String email_aut, String psw_aut) {
        return 0;
    }


}
