package com.portafolio.control.servicio.usuario;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IRolRepo;
import com.portafolio.control.repositorio.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class ServicioUsuarioImpl implements IServicioUsuario{
    @Autowired
    private IUsuarioRepo usuarioRepo;


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
    public ResponseEntity<Usuario> agregarUsuario(Usuario usuario) {
        String encodedPass = this.encoder.encode(usuario.getPassword());
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


}
