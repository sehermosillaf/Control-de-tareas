package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {

    @Id
    private Long id;
    private String nombre;
    private String direccion;
    private String correo;
    private String rubro;
}
