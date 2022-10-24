package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "equipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipo implements Serializable {

    @Id
    private Long id;
    @Column(name = "nombre_equipo")
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "equipo")
    private List<FlujoTareas> flujos;
}
