package com.portafolio.control.servicio.empresa;

import com.portafolio.control.modelo.Empresa;
import com.portafolio.control.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServicioEmpresa {

    List<Empresa> obtenerTodosEmpresas();

    Optional<Empresa> obtenerEmpresaPorID(Long id);

    ResponseEntity<Empresa> agregarEmpresa(Empresa empresa);

//    ResponseEntity<Empresa> actualizarEmpresa(Long id,Empresa empresa);

    ResponseEntity<Empresa> eliminarEmpresa(Long id);


}
