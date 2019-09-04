package com.trinity.vagnernegreiros.backend.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.trinity.vagnernegreiros.backend.model.Usuario;
import com.trinity.vagnernegreiros.backend.repository.UsuarioRepository;
import com.trinity.vagnernegreiros.backend.util.JWTUtil;
import com.trinity.vagnernegreiros.backend.util.Util;

@RestController
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
	ResponseEntity<?> login(@RequestBody Usuario usuarioRequest , HttpServletResponse response) {

		ResponseEntity<?> responseReturn = new ResponseEntity<>(null, HttpStatus.OK);

		System.out.println(usuarioRequest.getUser_email());
		System.out.println(Util.generateMD5(usuarioRequest.getUser_password()));
		
		List<Usuario> listUsuario = usuarioRepository.findUserByEmailAndPassword(usuarioRequest.getUser_email(), Util.generateMD5(usuarioRequest.getUser_password()));
		
		if(listUsuario.isEmpty()) {
			return new ResponseEntity<>(listUsuario, HttpStatus.NOT_FOUND);
		}
		
		Usuario usuarioEncontrado = listUsuario.get(0);
		
		response.setHeader("token", Util.generateMD5(usuarioRequest.getUser_email()));
		
        return new ResponseEntity<>(listUsuario, HttpStatus.OK);
    }
	
}
