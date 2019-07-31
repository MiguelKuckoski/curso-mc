package com.udemy.projetomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.projetomc.domain.Categoria;
import com.udemy.projetomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	protected CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElse(null);
	}
}
