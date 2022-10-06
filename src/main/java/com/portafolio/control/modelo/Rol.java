package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="ROL_SEQ", sequenceName="ROL_SEQ", allocationSize=100)
    @Column(name = "rol_id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY, targetEntity = Usuario.class)
    @JsonBackReference
    @JsonIgnoreProperties(value = {"roles"})
    private List<Usuario> usuarios;

}
