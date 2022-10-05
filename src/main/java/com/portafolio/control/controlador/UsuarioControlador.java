package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.servicio.usuario.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsuarioControlador {
    @Autowired
    private IServicioUsuario servicioUsuario;

    @GetMapping
    public List<Usuario> obtenerTodosUsuarios(){
        return servicioUsuario.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorID(@PathVariable Long id){
        return servicioUsuario.obtenerUsuarioPorID(id); //Todo:Add custom exception
    }
    @PostMapping
    @ResponseBody public void agregarUsuario(@RequestBody Usuario usuario) {
        servicioUsuario.agregarUsuario(usuario);
    }

}
