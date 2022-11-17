package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepo extends JpaRepository<Empresa,Long> {
}
