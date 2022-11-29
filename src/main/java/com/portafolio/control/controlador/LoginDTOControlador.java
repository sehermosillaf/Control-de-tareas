package com.portafolio.control.controlador;

import com.portafolio.control.dto.UsuarioLoginDTO;
import com.portafolio.control.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginDTOControlador {

    public UsuarioLoginDTO loginDTO;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        if(loginDTO.validate(usuario.getEmail(),usuario.getPassword())) {
            return "Login";
        };
        return "xD";
    }




}
