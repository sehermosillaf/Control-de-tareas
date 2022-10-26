package com.portafolio.control.controlador;

import com.portafolio.control.config.JWTAuthResonseDTO;
import com.portafolio.control.config.JwtTokenProvider;
import com.portafolio.control.dto.UsuarioLogin;
import com.portafolio.control.repositorio.IRolRepo;
import com.portafolio.control.repositorio.IUsuarioRepo;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.driver.JsonWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Autowired
    private IRolRepo rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwt;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody UsuarioLogin loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        //obtiene el token del jwtTokenProvider
        String token = jwt.generarToken(authentication);
        return ResponseEntity.ok(new JWTAuthResonseDTO(token));
    }
}
