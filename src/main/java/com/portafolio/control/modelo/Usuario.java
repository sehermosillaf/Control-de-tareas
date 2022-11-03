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
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usuario_id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "pass")
    private String password;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
               joinColumns = {
            @JoinColumn(name = "usuario_id",referencedColumnName = "usuario_id")

    },
            inverseJoinColumns = {
            @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
            }
    )
    private List<Rol> roles;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Tarea> tareas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

}
