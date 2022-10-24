package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tarea_subordinada")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TareaSubordinada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_seq", sequenceName="id_seq")
    @Column(name = "id_subtarea")
    private Long id;

    @Column(name = "nombre_subtarea")
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



    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "tarea_id_tarea", referencedColumnName = "id_tarea")
    private Tarea tarea;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TareaSubordinada)) return false;
        TareaSubordinada that = (TareaSubordinada) o;
        return getId().equals(that.getId()) && getNombre().equals(that.getNombre()) && getDescripcion().equals(that.getDescripcion()) && getFechaCreacion().equals(that.getFechaCreacion()) && getFechaInicio().equals(that.getFechaInicio()) && getFechaTermino().equals(that.getFechaTermino()) && getTarea().equals(that.getTarea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getDescripcion(), getFechaCreacion(), getFechaInicio(), getFechaTermino(), getTarea());
    }
}
