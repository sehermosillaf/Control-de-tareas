package com.portafolio.control.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioAdminDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String pass;
    private Byte enabled;
    private Long unidadID;
    private Long rol_id;

}
