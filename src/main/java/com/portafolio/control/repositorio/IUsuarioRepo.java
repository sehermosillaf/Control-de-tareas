package com.portafolio.control.repositorio;

import com.portafolio.control.dto.UsuarioAdminDTO;
import com.portafolio.control.modelo.Rol;
import com.portafolio.control.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
    Boolean existsByEmail(String email);
    Usuario findUsuarioByEmail(String email);
    @Query(value = "SELECT U.USUARIO_ID,U.NOMBRE || ' ' || U.APELLIDO AS NOMBRE_COMPLETO,U.EMAIL,U.PASS,R.ROL_ID FROM USUARIOS U JOIN USUARIO_ROLES R ON U.USUARIO_ID = R.USUARIO_ID WHERE R.ROL_ID = 1", nativeQuery = true)
    List<?> findAdminUsers();
    @Query(value = "SELECT U.USUARIO_ID,U.NOMBRE || ' ' || U.APELLIDO AS NOMBRE_COMPLETO,U.EMAIL,U.PASS,R.ROL_ID FROM USUARIOS U JOIN USUARIO_ROLES R ON U.USUARIO_ID = R.USUARIO_ID WHERE R.ROL_ID = 2", nativeQuery = true)
    List<?> findFuncUsers();

    @Procedure(name = "crear_usuario_roles")
    Usuario insertarUsuarioConRoles(@Param("P_NOMBRE") String nombre,@Param("P_APELLIDO") String apellido,
                          @Param("P_EMAIL") String email,
                          @Param("P_PASS") String pass,
                          @Param("P_ENABLED") Byte enabled,
                          @Param("P_ID_UNIDAD") Long idunidad,
                          @Param("P_ROL_ID") Long rol_id);
}
