package com.portafolio.control.controlador;

import com.portafolio.control.servicio.mail.EnvioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class CorreoControlador {
    @Autowired
    private EnvioMail correo;

    @GetMapping
    public void sendMail(){
        correo.SendEmail("se.hermosillaf@gmail.com", "testing","testing desde spring");
    }
}
