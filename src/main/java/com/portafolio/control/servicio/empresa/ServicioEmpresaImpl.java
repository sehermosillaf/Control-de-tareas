package com.portafolio.control.servicio.empresa;

import com.portafolio.control.modelo.Empresa;
import com.portafolio.control.repositorio.IEmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpresaImpl implements IServicioEmpresa {

    @Autowired
    private IEmpresaRepo empresaRepo;

    @Override
    public List<Empresa> obtenerTodosEmpresas() {
        return empresaRepo.findAll();
    }

    @Override
    public Optional<Empresa> obtenerEmpresaPorID(Long id) {
        return empresaRepo.findById(id);
    }

    @Override
    public ResponseEntity<Empresa> agregarEmpresa(Empresa empresa) {
        Empresa nuevaEmpresa = empresaRepo.save(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }

//    @Override
//    public ResponseEntity<Empresa> actualizarEmpresa(Long id, Empresa empresa) {
//        return ;
//    }

    @Override
    public ResponseEntity<Empresa> eliminarEmpresa(Long id) {
        Empresa empresaPorEliminar = empresaRepo.findById(id).get();
        return ResponseEntity.ok(empresaPorEliminar);
    }
}
