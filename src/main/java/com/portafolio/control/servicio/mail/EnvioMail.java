package com.portafolio.control.servicio.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EnvioMail {
    @Autowired
    private JavaMailSender mail;

    public void SendEmail(String to, String subject, String content) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);
        mail.send(email);
    }
    public void tareaAsignada(String correo) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(correo);
        email.setSubject("Nueva tarea");
        email.setText("Tiene una nueva tarea asignada con nombre");
        mail.send(email);
    }

    public void alertaAtraso(String correo){

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(correo);
        email.setSubject("Alerta atraso");
        email.setText("La tarea que tiene asignada tiene menos de una semana para completar su plazo limite)");
        mail.send(email);
    }
}
