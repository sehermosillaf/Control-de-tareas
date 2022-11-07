package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRolRepo extends JpaRepository<Rol,Long> {
    List<Rol> findRolByUsuarios(Usuario usuario);
}
