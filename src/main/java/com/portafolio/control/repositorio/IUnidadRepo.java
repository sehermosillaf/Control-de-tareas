package com.portafolio.control.repositorio;

import com.portafolio.control.modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUnidadRepo extends JpaRepository<Unidad,Long> {
    @Query(value = "select * from unidades where id_empresa = :id", nativeQuery = true)
    List<Unidad> obtenerUnidadesPorEmpresa(@Param("id") Long id);

    @Procedure(name = "SP_INSERTAR_UNIDAD")
    void insertarUnidad(@Param("P_NOMBRE") String nombre,
                                 @Param("P_DESCRIPCION") String descripcion,
                                 @Param("P_FUNCION") String funcion,
                                 @Param("P_ID_EMPRESA") Long idEmpresa);
}
