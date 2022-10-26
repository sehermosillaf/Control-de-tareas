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

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Rol.class)
    @JoinTable(name = "usuario_roles",
               joinColumns = {
            @JoinColumn(name = "usuario_id",referencedColumnName = "usuario_id")

    },
            inverseJoinColumns = {
            @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
            }
    )
    private Collection<Rol> roles;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, targetEntity = Tarea.class,cascade = CascadeType.ALL)
    private Collection<Tarea> tareas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;


    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles, Collection<Tarea> tareas, Cargo cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.tareas = tareas;
        this.cargo = cargo;
    }

    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles, Collection<Tarea> tareas, Cargo cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.tareas = tareas;
        this.cargo = cargo;
    }
}
