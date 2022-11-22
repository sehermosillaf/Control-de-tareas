package com.portafolio.control.controlador;

import com.portafolio.control.dto.UsuarioAdminDTO;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.servicio.estado.IServicioEstado;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import com.portafolio.control.servicio.usuario.IServicioUsuario;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsuarioControlador {
    @Autowired
    private IServicioUsuario servicioUsuario;

    @Autowired
    IServicioTarea servicioTarea;
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios(){
        return servicioUsuario.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorID(@PathVariable Long id){
        return servicioUsuario.obtenerUsuarioPorID(id); //Todo:Add custom exception
    }

    @GetMapping("/admins")
    public List<?> obtenerAdmins() {
        return servicioUsuario.obtenerAdmins();
    }

    @GetMapping("/func")
    public List<?> obtenerFunc() {
        return servicioUsuario.obtenerFunc();
    }

    @PostMapping
    @ResponseBody
    public  ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        return servicioUsuario.agregarUsuario(usuario);
    }
    @PostMapping(value = "/register", produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> agregarUsuarioConRoles(@RequestBody UsuarioAdminDTO usuarioDTO) {
        return servicioUsuario.agregarUsuarioConRoles(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getEmail(), usuarioDTO.getPass(), usuarioDTO.getEnabled(), usuarioDTO.getUnidadID(), usuarioDTO.getRol_id());    }
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuario) {
        return servicioUsuario.actualizarUsuario(id,usuario);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id) {
        return servicioUsuario.eliminarUsuario(id);
    }
    @PostMapping(value = "/login",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        return servicioUsuario.validateCredentials(usuario.getEmail(), usuario.getPassword());
    }



}
