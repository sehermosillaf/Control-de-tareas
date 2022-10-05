package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {
//    List<Usuario> findByNombreContaining(String nombre);
}
