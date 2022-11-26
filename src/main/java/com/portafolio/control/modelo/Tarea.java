package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.*;
import oracle.sql.DATE;
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
        ),
                @NamedStoredProcedureQuery(
                        name = "INSERTAR_TAREA",
                        procedureName = "SP_INSERTAR_TAREA",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESCRIPCION", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_CREACION", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_INICIO", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_TERMINO", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO_ID", type = Long.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO_CREADOR",type = Long.class),
                                @StoredProcedureParameter(mode=ParameterMode.IN,name = "P_UNIDAD_ID",type = Long.class)
                        }
                ),
                @NamedStoredProcedureQuery(name = "SP_RECHAZAR_TAREA",
                procedureName = "SP_RECHAZAR_TAREA",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_TAREA",type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN,name = "P_JUSTIFICACION",type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN,name = "P_USUARIO_RESPONSABLE",type = Long.class)
                })
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_termino")
    private Date fechaTermino;
    @Column(name = "justificacion")
    private String justificacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioResponsable;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_creador_id")
    private Usuario usuarioCreador;

    @ManyToOne(targetEntity = Estado.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "tarea", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TareaSubordinada> subtareas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tarjeta")
    private Tarjeta tarjeta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;

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
