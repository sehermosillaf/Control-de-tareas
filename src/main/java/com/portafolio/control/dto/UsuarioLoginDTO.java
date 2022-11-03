package com.portafolio.control.dto;

import com.portafolio.control.modelo.Usuario;
import com.portafolio.control.repositorio.IUsuarioRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UsuarioLoginDTO {

    @Autowired
    private IUsuarioRepo usuarioRepo;
    private String email;
    private String passw;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean validate(String email,String password) {

        Usuario usuario = usuarioRepo.findUsuarioByEmail(email);

        if(!usuarioRepo.existsByEmail(email)){
            return false;
        }

        if(!this.encoder.matches(this.passw, usuario.getPassword())){
            return false;
        }
        return true;
    }
}
