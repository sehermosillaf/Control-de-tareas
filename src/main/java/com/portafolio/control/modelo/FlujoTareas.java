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
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SP_INSERTAR_FLUJO",
                procedureName = "SP_INSERTAR_FLUJO",
                parameters = {
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_NOMBRE", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_DESCRIPCION", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_TAREA_ID", type=Long.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_UNIDAD_ID", type=Long.class)
                }
        )
})
public class FlujoTareas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "tarea_id")
    private Set<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
