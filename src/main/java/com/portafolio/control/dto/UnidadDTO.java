package com.portafolio.control.dto;

import lombok.Data;

@Data
public class UnidadDTO {
    private String nombre;
    private String descripcion;
    private String funcion;
    private Long idEmpresa;

    public UnidadDTO() {
    }

    public UnidadDTO(String nombre, String descripcion, String funcion, Long idEmpresa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.funcion = funcion;
        this.idEmpresa = idEmpresa;
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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
