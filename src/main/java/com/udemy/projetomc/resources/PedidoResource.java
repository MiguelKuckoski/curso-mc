package com.udemy.projetomc.resources;

import com.udemy.projetomc.domain.Pedido;
import com.udemy.projetomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = pedidoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
