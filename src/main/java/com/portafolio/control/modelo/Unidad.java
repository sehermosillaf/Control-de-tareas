package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "unidad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unidad {
    @Id
    @Column(name = "id_unidad")
    private Long id;
    private String nombre;
    private String descripcion;
    private String funcion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
