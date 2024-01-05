package br.com.Cadastrodeprodutos.dto;

import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;

public record BuscarDto(Long codigo,String nome,String marca) {
	public BuscarDto(ProdutoModelo buscar) {
		this(buscar.getCodigo(),buscar.getNome(),buscar.getMarca()); 
	}



}
