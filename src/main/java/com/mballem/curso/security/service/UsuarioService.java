package com.mballem.curso.security.service;

import org.springframework.stereotype.Service;

import com.mballem.curso.security.domain.Usuario;
import com.mballem.curso.security.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository repository;
	
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
}
