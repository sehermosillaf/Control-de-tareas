package com.portafolio.control.dto;

import java.io.Serializable;
import java.util.Date;

public class TareaDTO {
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaTermino;
    private Long usuarioResponsable;

    public TareaDTO() {
    }

    public TareaDTO(String nombre, String descripcion, Date fechaCreacion, Date fechaInicio, Date fechaTermino, Long usuarioResponsable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.usuarioResponsable = usuarioResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Long getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Long usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }
}
