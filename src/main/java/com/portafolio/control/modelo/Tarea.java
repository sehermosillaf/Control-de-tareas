package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tarea")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NamedStoredProcedureQueries(
        {@NamedStoredProcedureQuery(name = "updateEstado",
                procedureName = "SP_AVANCE_TAREA"
        )
        })
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
    private LocalDate fechaCreacion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_termino")
    private LocalDate fechaTermino;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioResponsable;

    @ManyToOne(targetEntity = Estado.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "tarea",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<TareaSubordinada> subtareas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tarjeta" )
    private Tarjeta tarjeta;

    //Corrige conflictos entre Lambok y Set de tareas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea tarea = (Tarea) o;
        return getId().equals(tarea.getId()) && getNombre().equals(tarea.getNombre()) && getDescripcion().equals(tarea.getDescripcion()) && getFechaCreacion().equals(tarea.getFechaCreacion()) && getFechaInicio().equals(tarea.getFechaInicio()) && getFechaTermino().equals(tarea.getFechaTermino()) && getUsuarioResponsable().equals(tarea.getUsuarioResponsable()) && getSubtareas().equals(tarea.getSubtareas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getDescripcion(), getFechaCreacion(), getFechaInicio(), getFechaTermino(), getUsuarioResponsable(), getSubtareas());
    }
}
