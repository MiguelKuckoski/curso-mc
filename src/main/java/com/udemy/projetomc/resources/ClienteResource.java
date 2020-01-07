package com.udemy.projetomc.resources;

import com.udemy.projetomc.domain.Cliente;
import com.udemy.projetomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.projetomc.domain.Categoria;
import com.udemy.projetomc.services.CategoriaService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = clienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}