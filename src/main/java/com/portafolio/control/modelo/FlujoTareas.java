package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proceso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlujoTareas implements Serializable {
    @Id
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
