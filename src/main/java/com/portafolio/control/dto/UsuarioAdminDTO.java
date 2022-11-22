package com.portafolio.control.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioAdminDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String pass;
    private int rol_id;

}
