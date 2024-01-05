package br.com.Cadastrodeprodutos.dto;

import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;

public record BuscarProdutoDto(Long codigo,String nome,String marca) {
  public BuscarProdutoDto(ProdutoModelo produto) {
	  this(produto.getCodigo(),produto.getNome(),produto.getMarca());
  }
}
