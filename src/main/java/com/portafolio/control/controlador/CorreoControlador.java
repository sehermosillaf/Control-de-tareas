package com.portafolio.control.controlador;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.servicio.mail.EnvioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class CorreoControlador {
    @Autowired
    EnvioMail mailSender;
    @PostMapping(consumes = "text/plain")
    public void SendMailAssignTask(@RequestBody String correo) {
        mailSender.tareaAsignada(correo);
    }
}
