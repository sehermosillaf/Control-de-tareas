package com.portafolio.control.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControlador {

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }
}
