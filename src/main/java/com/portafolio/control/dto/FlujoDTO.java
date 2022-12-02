package com.portafolio.control.dto;

public class FlujoDTO {
    private String nombre;
    private String descripcion;
    private Long tareaid;
    private Long unidadid;

    public FlujoDTO() {
    }

    public FlujoDTO(String nombre, String descripcion, Long tareaid, Long unidadid) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tareaid = tareaid;
        this.unidadid = unidadid;
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

    public Long getTareaid() {
        return tareaid;
    }

    public void setTareaid(Long tareaid) {
        this.tareaid = tareaid;
    }

    public Long getUnidadid() {
        return unidadid;
    }

    public void setUnidadid(Long unidadid) {
        this.unidadid = unidadid;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
