package com.portafolio.control.dto;

import lombok.Data;

@Data
public class UserLogin {

    private String email;
    private String passw;
    private String rol;
    private Integer codigoAuth;
}
