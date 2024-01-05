package br.com.Cadastrodeprodutos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;



public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long> {

	

}
