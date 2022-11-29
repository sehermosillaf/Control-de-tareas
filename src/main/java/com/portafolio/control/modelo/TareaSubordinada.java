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
@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(
                        name = "SP_INSERTAR_SUBTAREA",
                        procedureName = "SP_INSERTAR_SUBTAREA",
                        parameters = {
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESCRIPCION", type = String.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_CREACION", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_INICIO", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_TERMINO", type = Date.class),
                                @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_TAREA", type = Long.class)
                        })
        }
)
public class TareaSubordinada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "id_tarea")
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
