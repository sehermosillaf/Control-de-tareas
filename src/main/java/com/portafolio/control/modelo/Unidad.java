package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
