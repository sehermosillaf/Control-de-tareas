package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SP_INSERT_USER_ROLE",
                procedureName = "SP_INSERT_USER_ROLE",
                parameters = {
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_NOMBRE", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_APELLIDO", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_EMAIL", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_PASS", type=String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_ENABLED", type=Byte.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_ID_UNIDAD", type=Long.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name="P_ROL_ID", type=Long.class)
                }
        )
        })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "pass")
    private String password;
    @Column(name = "enabled")
    private Byte enabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
            joinColumns = {
                    @JoinColumn(name = "usuario_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "rol_id")
            }
    )
    private List<Rol> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioResponsable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Tarea> tareas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cargo",referencedColumnName = "id_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "id_unidad",referencedColumnName = "id_unidad")
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
