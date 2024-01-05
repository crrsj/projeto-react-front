package br.com.Cadastrodeprodutos.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Cadastrodeprodutos.componentes.RespostaModelo;

import br.com.Cadastrodeprodutos.dto.AtualizarDto;
import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;
import br.com.Cadastrodeprodutos.repositorio.ProdutoRepositorio;


@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	@Autowired
	private RespostaModelo rm;
	
	
	
	public List<ProdutoModelo>listar(){		
		return repositorio.findAll();
	}
	
	public ResponseEntity<?> cadastrar(ProdutoModelo cadastro) {
		if(cadastro.getNome().equals("")) {
			rm.setMensagem("O nome do produto é obrigatório");
			return new ResponseEntity<RespostaModelo>(rm,HttpStatus.NOT_FOUND);
		}else if(cadastro.getMarca().equals("")){
		  rm.setMensagem("A marca é obrigatório");	
		  return new ResponseEntity<RespostaModelo>(rm,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<ProdutoModelo>(repositorio.save(cadastro),HttpStatus.CREATED);
			
		}
		
	}
		 
	
	public AtualizarDto atualizarCadastro(AtualizarDto atualize) {
		var alterar = repositorio.getReferenceById(atualize.codigo());
		alterar.updata(atualize);
		return new AtualizarDto(alterar);
	}
	
	public ResponseEntity<RespostaModelo> deletar(Long codigo) {
		repositorio.deleteById(codigo);
		rm.setMensagem("Produto removido com sucesso");
		return new ResponseEntity<RespostaModelo>(rm,HttpStatus.NO_CONTENT);
	}
	 public ProdutoModelo buscarId(Long codigo) {
	  return repositorio.getReferenceById(codigo);
	  }

	
  }
	
	 
		
	
	

