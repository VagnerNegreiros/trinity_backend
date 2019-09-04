package com.trinity.vagnernegreiros.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trinity.vagnernegreiros.backend.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.user_email=:user_email and u.user_password=:user_password")
    List<Usuario> findUserByEmailAndPassword(@Param("user_email") String user_email , @Param("user_password") String user_password );

}