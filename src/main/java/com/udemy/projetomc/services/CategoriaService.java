package com.udemy.projetomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udemy.projetomc.services.exceptions.ObjectNotFoundException;
import com.udemy.projetomc.domain.Categoria;
import com.udemy.projetomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	protected CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria insert(Categoria obj) {
		obj.setId(null);
    	return categoriaRepository.save(obj);
	}

    public Categoria update(Categoria obj) {
	    find(obj.getId());
        return categoriaRepository.save(obj);
    }
}
