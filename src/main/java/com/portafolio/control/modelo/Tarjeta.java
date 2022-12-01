package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "tarjeta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tarjeta implements Serializable {
    @Id
    @Column(name = "id_tarjeta")
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Progeso progeso;
}
