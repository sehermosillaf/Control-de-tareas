package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< Updated upstream
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
>>>>>>> Stashed changes

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"tareas"})
public class Usuario implements Serializable {
<<<<<<< Updated upstream
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="USER_SEQ", sequenceName="USER_SEQ", allocationSize=100)
=======

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="id_seq", sequenceName="id_seq")
>>>>>>> Stashed changes
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

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Rol.class)
    @JoinTable(name = "usuario_roles",
               joinColumns = {
            @JoinColumn(name = "usuario_id",referencedColumnName = "usuario_id")

    },
            inverseJoinColumns = {
            @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
            }
    )
    private List<Rol> roles;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, targetEntity = Tarea.class)
    private List<Tarea> tareas;
}
