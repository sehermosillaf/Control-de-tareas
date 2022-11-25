package com.portafolio.control.dto;

public class UsuarioRolesDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String pass;
    private Byte enabled;
    private Long idunidad;
    private Long rolid;

    public UsuarioRolesDTO(String nombre, String apellido, String email, String pass, Byte enabled, Long idunidad, Long rolid) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
        this.idunidad = idunidad;
        this.rolid = rolid;
    }

    public UsuarioRolesDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public Long getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Long idunidad) {
        this.idunidad = idunidad;
    }

    public Long getRolid() {
        return rolid;
    }

    public void setRolid(Long rolid) {
        this.rolid = rolid;
    }
}
