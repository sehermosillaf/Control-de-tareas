package com.portafolio.control.servicio.estado;

import com.portafolio.control.modelo.Tarea;
import com.portafolio.control.repositorio.IEstadoRepo;
import com.portafolio.control.repositorio.ITareaRepo;
import com.portafolio.control.servicio.mail.EnvioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEstadoImpl implements IServicioEstado{

    @Autowired
    ITareaRepo tareaRepo;
    @Autowired
    IEstadoRepo estadoRepo;
    @Autowired
    EnvioMail mail;

    @Override
    public void alertaAtraso(Tarea tarea) {
        if(tarea.getNombre().equals("amarillo")){
            mail.SendEmail("se.hermosillaf@gmail.com","Alerta atraso","La tarea '" + tarea.getNombre() +"' que tiene asignada tiene menos de una semana para completar su plazo limite");
        }
        if(tarea.getNombre().equals("rojo")){
            mail.SendEmail(tarea.getUsuarioResponsable().getEmail(),"Atraso de tarea","La tarea '" + tarea.getNombre() +"' que tiene asignada completo su plazo limite");
        }
    }
}
