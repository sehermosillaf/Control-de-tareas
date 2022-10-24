package com.portafolio.control.dto;

import com.portafolio.control.modelo.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long userID;
    private Long IDtarea;
    private String nombreTarea;
}
