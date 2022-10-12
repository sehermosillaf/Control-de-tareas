package com.portafolio.control.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "progreso")
public class Progeso implements Serializable {
    @Id
    private Long id;
    private Float porcentaje;
}
