package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IRolRepo;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ServicioUsuarioImpl implements IServicioUsuario {
    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Autowired
    IRolRepo rolRepo;

    PasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorID(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public ResponseEntity<?> agregarUsuarioConRoles(String nombre,String apellido,String email,String pass, Byte enabled,Long unidadID,Long idRol) {
        Usuario user = usuarioRepo.insertarUsuarioConRoles(nombre,apellido,email,pass,enabled,unidadID,idRol);
        return ResponseEntity.ok(user);
    }

    @Override
    public List<?> obtenerAdmins() {
        return usuarioRepo.findAdminUsers();
    }

    @Override
    public List<?> obtenerFunc() {
        return usuarioRepo.findFuncUsers();
    }
    @Override
    public ResponseEntity<Usuario> agregarUsuario(Usuario usuario) {
        String encodedPass = this.encoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPass);
        Usuario usuarioNuevo = usuarioRepo.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, CREATED);
    }
    @Override
    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioActualizado = usuarioRepo.findById(id).orElseThrow(RuntimeException::new);//Todo:Crear excepcion personalizada\
        String encodedPass = this.encoder.encode(usuario.getPassword());
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setApellido(usuario.getApellido());
        usuarioActualizado.setEmail(usuario.getEmail());
        usuarioActualizado.setPassword(encodedPass);
        usuarioActualizado.setRoles(usuario.getRoles());
        usuarioActualizado.setEnabled(usuario.getEnabled());
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
    public ResponseEntity<?> validateCredentials(String email, String password) {
        Usuario usuario = usuarioRepo.findUsuarioByEmail(email);
        //Match entre la passw raw con la encoded
        try {
            if (this.encoder.matches(password, usuario.getPassword())) {
                return ResponseEntity.ok(usuario);
            }
        } catch (Exception e) {
            return (ResponseEntity<Usuario>) ResponseEntity.status(NOT_FOUND);
        }
        return (ResponseEntity<Usuario>) ResponseEntity.status(NOT_FOUND);
    }

}
