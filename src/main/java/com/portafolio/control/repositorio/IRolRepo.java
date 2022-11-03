package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepo extends JpaRepository<Rol,Long> {
}
