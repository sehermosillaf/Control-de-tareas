package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUsuarioRepo;
import com.portafolio.control.servicio.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioControlador {

    @Autowired
    private IServicioUsuario servicioUsuario;

    @GetMapping("/users")
    public List<Usuario> obtenerTodosUsuarios(){
        return servicioUsuario.obtenerTodosUsuarios();
    }
}
