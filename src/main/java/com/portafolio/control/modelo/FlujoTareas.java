package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "proceso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlujoTareas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "tareas")
    private Set<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
