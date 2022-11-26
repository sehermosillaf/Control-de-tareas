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
    private Long usuarioCreador;

    private Long unidadID;

    public TareaDTO() {
    }

    public TareaDTO(String nombre, String descripcion, Date fechaCreacion, Date fechaInicio, Date fechaTermino, Long usuarioResponsable, Long usuarioCreador, Long unidadID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.usuarioResponsable = usuarioResponsable;
        this.usuarioCreador = usuarioCreador;
        this.unidadID = unidadID;
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

    public Long getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Long usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Long getUnidadID() {
        return unidadID;
    }

    public void setUnidadID(Long unidadID) {
        this.unidadID = unidadID;
    }
}
