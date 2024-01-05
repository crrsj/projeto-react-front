package br.com.Cadastrodeprodutos.dto;

import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;

public record ProdutoModeloDto(Long codigo,String nome,String marca) {

	public ProdutoModeloDto(ProdutoModelo cadastro) {
		this(cadastro.getCodigo(),cadastro.getNome(),cadastro.getMarca());
	}

}
