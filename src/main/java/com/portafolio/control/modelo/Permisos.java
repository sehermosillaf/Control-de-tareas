package com.portafolio.control.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "usuario_roles")
public class Permisos {
    private Long rol_id;
    private Long usuario_id;
}
