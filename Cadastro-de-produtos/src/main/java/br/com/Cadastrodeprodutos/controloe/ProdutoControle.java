package br.com.Cadastrodeprodutos.controloe;



import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.Cadastrodeprodutos.componentes.RespostaModelo;
import br.com.Cadastrodeprodutos.dto.AtualizarDto;
import br.com.Cadastrodeprodutos.dto.BuscarDto;

import br.com.Cadastrodeprodutos.dto.ProdutoModeloDto;
import br.com.Cadastrodeprodutos.modelo.ProdutoModelo;
import br.com.Cadastrodeprodutos.servico.ProdutoServico;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("produto")
@CrossOrigin(origins = "*")
public class ProdutoControle {
	
	@Autowired
	private ProdutoServico servico;
	
	@PostMapping("/cadastro")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody  ProdutoModeloDto prod){
 	var cadastro = new ProdutoModelo(prod);
 	return servico.cadastrar(cadastro);     
    
	
     }
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProdutoModeloDto>> lista(){
		var list = servico.listar().stream().map(ProdutoModeloDto::new).toList();
		return ResponseEntity.ok(list);
	}
	@PutMapping("/alterar")
	@Transactional
    public ResponseEntity<AtualizarDto>atualizar(@RequestBody AtualizarDto atualize){	 
	 servico.atualizarCadastro(atualize);
	return ResponseEntity.ok().build();
	
	 
   }
    @DeleteMapping("/remover/{codigo}")
    @Transactional
	public ResponseEntity<RespostaModelo>excluir(@PathVariable Long codigo){		
	return	servico.deletar(codigo);
		
		
	}
    @GetMapping("/{codigo}")
    public ResponseEntity<BuscarDto>buscarId(@PathVariable Long codigo ){
     var buscar = servico.buscarId(codigo); 
     return ResponseEntity.ok().body(new BuscarDto(buscar));
    } 
	   
   
}