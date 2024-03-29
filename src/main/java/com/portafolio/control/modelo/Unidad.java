package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "unidades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SP_INSERTAR_UNIDAD",
                procedureName = "SP_INSERTAR_UNIDAD",
                parameters = {
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_NOMBRE", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_DESCRIPCION", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_FUNCION", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_ID_EMPRESA", type=Long.class)
                }
        )
})
public class Unidad {
    @Id
    @Column(name = "id_unidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String funcion;

    @JsonIgnore
    @OneToMany(mappedBy = "unidad")
    private List<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

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
