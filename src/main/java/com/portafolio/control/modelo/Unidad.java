package com.portafolio.control.modelo;

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
    @ManyToOne
    @JoinColumn(name = "unidades")
    private Empresa empresa;
}
