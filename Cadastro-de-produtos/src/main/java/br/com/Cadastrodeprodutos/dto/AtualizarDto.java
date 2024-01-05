package br.com.Cadastrodeprodutos.dto;

import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;

public record AtualizarDto(Long codigo,String nome,String marca) {
  public AtualizarDto(ProdutoModelo alterar) {
	  this(alterar.getCodigo(),alterar.getNome(),alterar.getMarca());
  }

 
}
