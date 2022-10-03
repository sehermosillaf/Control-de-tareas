package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="USER_SEQ", sequenceName="USER_SEQ", allocationSize=100)
    @Column(name = "usuario_id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "pass")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
               joinColumns = {
            @JoinColumn(name = "usuario_id",referencedColumnName = "usuario_id")

    },
            inverseJoinColumns = {
            @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
            }

    )
    @JsonManagedReference
    @JsonIgnore
    private List<Rol> roles;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    @JsonBackReference
    @JsonIgnore
    private List<Tarea> tareas;
}
