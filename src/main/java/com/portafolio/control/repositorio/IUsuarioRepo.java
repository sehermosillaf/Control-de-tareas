package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {

    Usuario findByEmail(String email);

}
