package com.portafolio.control.controlador;

import com.portafolio.control.dto.UsuarioFuncDTO;
import com.portafolio.control.dto.UsuarioRolesDTO;
import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.servicio.tarea.IServicioTarea;
import com.portafolio.control.servicio.usuario.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
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

    @GetMapping("/unit/{id}")
    public List<Usuario> obtenerUsuariosPorUnidad(@PathVariable Long id) {
        return servicioUsuario.obtenerUsuariosPorUnidad(id);
    }

    @GetMapping("/unit/{id}/func")
    public List<Usuario> obtenerFuncionariosPorUnidad(@PathVariable Long id) {
        return servicioUsuario.obtenerFuncionariosPorUnidad(id);
    }

    @GetMapping("/mail/{id}")
    public String obtenerMailPorID(@PathVariable Long id){
        return servicioUsuario.buscarEmailPorID(id);
    }

    @GetMapping("/admins")
    public List<?> obtenerAdmins() {
        return servicioUsuario.obtenerAdmins();
    }

    @GetMapping("/func")
    public List<UsuarioFuncDTO> obtenerFunc() {
        return servicioUsuario.obtenerFunc();
    }

    @PostMapping
    @ResponseBody
    public  ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        return servicioUsuario.agregarUsuario(usuario);
    }
    @PostMapping(value = "/register")
    @ResponseBody
    public void agregarUsuarioConRoles(@RequestBody UsuarioRolesDTO user) {
        servicioUsuario.agregarUsuarioConRoles(user);
    }
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
