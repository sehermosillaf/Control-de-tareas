package com.portafolio.control.dto;

import com.portafolio.control.modelo.Tarea;
import lombok.Data;

import java.util.Date;

public class TareaEstadoDTO {
    private Date fechaInicio;
    private Date fechaTermino;
    private Date fechaCreacion;
    private String nombre;
    private Float porcentaje;

    public TareaEstadoDTO() {
    }

    public TareaEstadoDTO(Date fechaInicio, Date fechaTermino, Date fechaCreacion, String nombre, Float porcentaje) {
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}