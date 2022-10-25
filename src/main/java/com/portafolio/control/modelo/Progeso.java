package com.portafolio.control.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "progreso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Progeso implements Serializable {
    @Id
    private Long id;
    private Float porcentaje;

}
