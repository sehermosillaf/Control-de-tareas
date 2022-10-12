package com.portafolio.control.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Comuna")
public class Comuna implements Serializable {

    @Id
    @Column(name = "id_comuna")
    private Long id;
    private String nombre;
}
