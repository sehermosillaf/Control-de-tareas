package com.portafolio.control.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;
    private String nombre;
    private String direccion;
    private String correo;
    private String rubro;
    
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Unidad> unidades;

}
