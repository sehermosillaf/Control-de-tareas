package com.portafolio.control.dao;

public class TareaRechazadaDAO {
    private Long idTarea;
    private String justificacion;
    private Long idResponsable;

    public TareaRechazadaDAO() {
    }

    public TareaRechazadaDAO(Long idTarea, String justificacion, Long idResponsable) {
        this.idTarea = idTarea;
        this.justificacion = justificacion;
        this.idResponsable = idResponsable;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }
}
