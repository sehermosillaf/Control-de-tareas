package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface ITareaRepo extends JpaRepository<Tarea,Long> {

}
