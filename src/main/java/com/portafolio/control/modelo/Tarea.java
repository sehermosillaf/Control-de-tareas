package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tarea")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne(targetEntity = Usuario.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



    @OneToMany(mappedBy = "tarea",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<TareaSubordinada> subtareas;

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
