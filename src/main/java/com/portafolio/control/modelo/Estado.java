package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado implements Serializable {

    @Id
    @Column(name = "id_estado")
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "estado",fetch = FetchType.LAZY)
    private List<Tarea> tareas;
}
