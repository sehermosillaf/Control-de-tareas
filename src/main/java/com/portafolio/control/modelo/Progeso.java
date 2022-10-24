package com.portafolio.control.modelo;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;
@Entity
@Table(name = "progreso")
public class Progeso implements Serializable {
    @Id
    private Long id;
    private Float porcentaje;

    @OneToMany(mappedBy = "progreso")
    private List<Tarjeta> tarjetas;
}
