package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tarea")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_termino")
    private Date fechaTermino;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(targetEntity = Estado.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tarea")
    private Estado estado;
    @JsonIgnore
    @OneToMany(mappedBy = "tarea",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<TareaSubordinada> subtareas;


    @ManyToOne
    @JoinColumn(name = "tarjeta" )
    private Tarjeta tarjeta;

    //Corrige conflictos entre Lambok y Set de tareas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea tarea = (Tarea) o;
        return getId().equals(tarea.getId()) && getNombre().equals(tarea.getNombre()) && getDescripcion().equals(tarea.getDescripcion()) && getFechaCreacion().equals(tarea.getFechaCreacion()) && getFechaInicio().equals(tarea.getFechaInicio()) && getFechaTermino().equals(tarea.getFechaTermino()) && getUsuario().equals(tarea.getUsuario()) && getSubtareas().equals(tarea.getSubtareas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getDescripcion(), getFechaCreacion(), getFechaInicio(), getFechaTermino(), getUsuario(), getSubtareas());
    }
}
