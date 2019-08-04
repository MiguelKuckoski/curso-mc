package com.udemy.projetomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.projetomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	protected ProdutoRepository produtoRepository;
}
