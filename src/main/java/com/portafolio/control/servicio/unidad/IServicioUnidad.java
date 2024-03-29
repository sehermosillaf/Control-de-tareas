package com.portafolio.control.servicio.unidad;

import com.portafolio.control.dto.UnidadDTO;
import com.portafolio.control.modelo.Unidad;
import com.portafolio.control.repositorio.IUnidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServicioUnidad {


    List<Unidad> obtenerUnidades();
    List<Unidad> obtenerUnidadesPorEmpresa(Long id);
    ResponseEntity<Unidad> agregarUnidad(Unidad unidad);

    void insertarUnidad(UnidadDTO unidadDTO);
}
